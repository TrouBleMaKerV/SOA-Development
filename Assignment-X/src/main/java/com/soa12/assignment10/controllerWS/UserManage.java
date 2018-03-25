package com.soa12.assignment10.controllerWS;

import com.soa12.assignment10.schemaModel.IdNotFoundException;
import com.soa12.assignment10.schemaModel.UserIdType;
import com.soa12.assignment10.schemaModel.StudentInfoType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "UserManage",targetNamespace = "http://jw.nju.edu.cn/schema",wsdlLocation = "../../../wsdl/PersonalInfoManage.wsdl")
public interface UserManage {
    @WebMethod
    @WebResult(name = "searchInfo", targetNamespace = "http://www.example.com/oms")
    public StudentInfoType searchInfo(@WebParam(name = "搜索学生", targetNamespace = "http://jw.nju.edu.cn/schema") UserIdType userIdType)throws IdNotFoundException;

    @WebMethod
    @WebResult(name = "deleteInfo", targetNamespace = "http://www.example.com/oms")
    public boolean deleteInfo(@WebParam(name = "删除学生", targetNamespace = "http://jw.nju.edu.cn/schema") UserIdType userIdType)throws IdNotFoundException;

    @WebMethod
    @WebResult(name = "modifyInfo", targetNamespace = "http://www.example.com/oms")
    public StudentInfoType modifyInfo(@WebParam(name = "修改学生信息", targetNamespace = "http://jw.nju.edu.cn/schema") StudentInfoType studentInfoType)throws IdNotFoundException;

    @WebMethod
    @WebResult(name = "addInfo", targetNamespace = "http://www.example.com/oms")
    public StudentInfoType addInfo(@WebParam(name = "添加学生", targetNamespace = "http://jw.nju.edu.cn/schema") StudentInfoType studentInfoType)throws IdNotFoundException;

}
