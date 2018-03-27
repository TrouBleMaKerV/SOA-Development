package com.soa12.assignment10.controllerWS;

import com.soa12.assignment10.schemaModel.IdNotFoundException;
import com.soa12.assignment10.schemaModel.StudentInfoType;
import com.soa12.assignment10.schemaModel.UserIdType;

import javax.jws.WebParam;


public interface UserManage {

    public StudentInfoType searchInfo(@WebParam UserIdType userIdType)throws IdNotFoundException;


    public boolean deleteInfo(@WebParam UserIdType userIdType)throws IdNotFoundException;


    public StudentInfoType modifyInfo(@WebParam StudentInfoType studentInfoType)throws IdNotFoundException;

    public StudentInfoType addInfo(@WebParam StudentInfoType studentInfoType)throws IdNotFoundException;

}
