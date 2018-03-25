package com.soa12.assignment10.controllerWS;

import com.soa12.assignment10.schemaModel.AuthRequestType;
import com.soa12.assignment10.schemaModel.IdNotFoundException;
import com.soa12.assignment10.schemaModel.IdentifyType;
import com.soa12.assignment10.schemaModel.PasswordErrorException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Auth",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Auth{

    @WebMethod
    public IdentifyType identify(@WebParam(name = "认证请求", targetNamespace = "http://jw.nju.edu.cn/schema") AuthRequestType authRequestType)
            throws IdNotFoundException,PasswordErrorException;

}
