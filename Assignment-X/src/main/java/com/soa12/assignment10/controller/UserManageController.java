package com.soa12.assignment10.controller;

import com.soa12.assignment10.controllerWS.UserManage;
import com.soa12.assignment10.dao.StudentDao;
import com.soa12.assignment10.model.StudentEntity;
import com.soa12.assignment10.schemaModel.IdNotFoundException;
import com.soa12.assignment10.schemaModel.NotFoundReasonType;
import com.soa12.assignment10.schemaModel.UserIdType;
import com.soa12.assignment10.schemaModel.StudentInfoType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "UserManage",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
public class UserManageController implements UserManage{
    @Resource
    private StudentDao studentDao;

    @Override
    public StudentInfoType searchInfo(UserIdType userIdType) throws IdNotFoundException {
        String id = userIdType.getStudentId();
        StudentEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,id,"不存在该学号");
        }
        StudentInfoType studentInfoType = new StudentInfoType();
        studentInfoType.setBirthday(studentEntity.getBirthday());
        studentInfoType.setDepartment(studentEntity.getDepartment());
        studentInfoType.setIDcard(studentEntity.getIDcard());
        studentInfoType.setSex(studentEntity.getSex());
        studentInfoType.setState(studentEntity.getState());
        studentInfoType.setStudentName(studentEntity.getStudentName());
        studentInfoType.setStudentId(studentEntity.getStudentId());
        studentInfoType.setTime(studentEntity.getTime());

        return studentInfoType;
    }

    @Override
    public boolean deleteInfo(UserIdType userIdType) throws IdNotFoundException {
        String id = userIdType.getStudentId();
        StudentEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,id,"不存在该学号");
        }
        studentDao.delete(studentEntity);
        return true;
    }

    @Override
    public StudentInfoType modifyInfo(StudentInfoType studentInfoType) throws IdNotFoundException {
        String id = studentInfoType.getStudentId();
        StudentEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity == null){
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,id,"不存在该学号");
        }
        studentEntity.setBirthday(studentInfoType.getBirthday());
        studentEntity.setDepartment(studentInfoType.getDepartment());
        studentEntity.setIDcard(studentInfoType.getIDcard());
        studentEntity.setSex(studentInfoType.getSex());
        studentEntity.setState(studentInfoType.getState());
        studentEntity.setStudentName(studentInfoType.getStudentName());
        studentEntity.setStudentId(studentInfoType.getStudentId());
        studentEntity.setTime(studentInfoType.getTime());
        studentDao.update(studentEntity);
        return studentInfoType;
    }

    @Override
    public StudentInfoType addInfo(StudentInfoType studentInfoType) throws IdNotFoundException {
        String id = studentInfoType.getStudentId();
        StudentEntity studentEntity = studentDao.getStudent(id);
        if (studentEntity != null){
            throw new IdNotFoundException(NotFoundReasonType.学号已存在,id,"已存在该学号");
        }
        studentEntity.setBirthday(studentInfoType.getBirthday());
        studentEntity.setDepartment(studentInfoType.getDepartment());
        studentEntity.setIDcard(studentInfoType.getIDcard());
        studentEntity.setSex(studentInfoType.getSex());
        studentEntity.setState(studentInfoType.getState());
        studentEntity.setStudentName(studentInfoType.getStudentName());
        studentEntity.setStudentId(studentInfoType.getStudentId());
        studentEntity.setTime(studentInfoType.getTime());
        studentDao.save(studentEntity);
        return studentInfoType;
    }
}
