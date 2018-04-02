package com.soa12.assignment10.controller;

import com.soa12.assignment10.controllerWS.UserManage;
import com.soa12.assignment10.dao.StudentDao;
import com.soa12.assignment10.dao.impl.StudentDaoImpl;
import com.soa12.assignment10.model.StudentsEntity;
import com.soa12.assignment10.schemaModel.*;
import org.apache.cxf.interceptor.Fault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

@WebService(name = "UserManage",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
public class UserManageController implements UserManage {
    private StudentDao studentDao = StudentDaoImpl.getInstance();

    @WebMethod(action = "UserManage/searchInfo")
    @WebResult(name = "学生信息类型", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "auth/verifyRequest", output = "auth/verifyResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public StudentInfoType searchInfo(UserIdType userIdType) throws IdNotFoundException {
        Logger logger = LoggerFactory.getLogger(AuthController.class);
        logger.error("进入查看学生信息环节");
        int id = userIdType.getStudentId();
        StudentsEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new Fault(new IdNotFoundException(NotFoundReasonType.学号不存在,String.valueOf(id),"不存在该学号"));
        }
        StudentInfoType studentInfoType = new StudentInfoType();
        studentInfoType.setBirthday(studentEntity.getBirthday());
        studentInfoType.setDepartment(studentEntity.getDepartment());
        studentInfoType.setIDcard(studentEntity.getiDcard());
        studentInfoType.setSex(studentEntity.getSex());
        studentInfoType.setState(studentEntity.getState());
        studentInfoType.setStudentName(studentEntity.getStudentName());
        studentInfoType.setStudentId(studentEntity.getId());
        studentInfoType.setTime(studentEntity.getTime());

        return studentInfoType;
    }

    @WebMethod(action = "UserManage/deleteInfo")
    @WebResult(name = "学生信息类型", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "auth/verifyRequest", output = "auth/verifyResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public boolean deleteInfo(UserIdType userIdType) throws IdNotFoundException {
        int id = userIdType.getStudentId();
        StudentsEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new Fault(new IdNotFoundException(NotFoundReasonType.学号不存在,String.valueOf(id),"不存在该学号"));
        }
        studentDao.delete(studentEntity);
        return true;
    }

    @WebMethod(action = "UserManage/modifyInfo")
    @WebResult(name = "学生信息类型", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "auth/verifyRequest", output = "auth/verifyResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public StudentInfoType modifyInfo(StudentInfoType studentInfoType) throws IdNotFoundException {
        int id = studentInfoType.getStudentId();
        StudentsEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new Fault(new IdNotFoundException(NotFoundReasonType.学号不存在,String.valueOf(id),"不存在该学号"));
        }
        studentEntity.setBirthday(studentInfoType.getBirthday());
        studentEntity.setDepartment(studentInfoType.getDepartment());
        studentEntity.setiDcard(studentInfoType.getIDcard());
        studentEntity.setSex(studentInfoType.getSex());
        studentEntity.setState(studentInfoType.getState());
        studentEntity.setStudentName(studentInfoType.getStudentName());
        studentEntity.setId(studentInfoType.getStudentId());
        studentEntity.setTime(studentInfoType.getTime());
        studentDao.update(studentEntity);
        return studentInfoType;
    }

    @WebMethod(action = "UserManage/addInfo")
    @WebResult(name = "学生信息类型", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "auth/verifyRequest", output = "auth/verifyResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public StudentInfoType addInfo(StudentInfoType studentInfoType) throws IdNotFoundException {
        int id = studentInfoType.getStudentId();
        StudentsEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity != null){
            throw new Fault( new IdNotFoundException(NotFoundReasonType.学号已存在,String.valueOf(id),"已存在该学号"));
        }
        studentEntity = new StudentsEntity();
        studentEntity.setBirthday(studentInfoType.getBirthday());
        studentEntity.setDepartment(studentInfoType.getDepartment());
        studentEntity.setiDcard(studentInfoType.getIDcard());
        studentEntity.setSex(studentInfoType.getSex());
        studentEntity.setState(studentInfoType.getState());
        studentEntity.setStudentName(studentInfoType.getStudentName());
        studentEntity.setId(studentInfoType.getStudentId());
        studentEntity.setTime(studentInfoType.getTime());
        studentDao.save(studentEntity);
        return studentInfoType;
    }
}
