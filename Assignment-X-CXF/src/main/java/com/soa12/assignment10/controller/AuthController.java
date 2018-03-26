package com.soa12.assignment10.controller;

import com.soa12.assignment10.dao.UserDao;
import com.soa12.assignment10.dao.impl.UserDaoImpl;
import com.soa12.assignment10.model.UsersEntity;
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


@WebService(name = "Auth",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
public class AuthController {


    private UserDao userDao= UserDaoImpl.getInstance();

    @WebMethod(action = "auth/identify")
    @WebResult(name = "身份类型", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "auth/verifyRequest", output = "auth/verifyResponse", fault = {
            @FaultAction(className = IdNotFoundException.class),
            @FaultAction(className = PasswordErrorException.class)
    })

    public IdentifyType identify(
            AuthRequestType authRequestType) throws IdNotFoundException,PasswordErrorException {

        Logger logger = LoggerFactory.getLogger(AuthController.class);
        logger.error("进入了服务器的验证环节");
        String email=authRequestType.getEmail();
        System.out.println("服务器接收到数据：账户——"+email);
        UsersEntity user=userDao.getUser(email);
        if (user==null){
            throw new Fault(new IdNotFoundException(NotFoundReasonType.邮箱不存在,email,"不存在该邮箱"));
        }
        if (!authRequestType.getPassword().equals(user.getPassword())){
            throw new PasswordErrorException("密码错误",email,"error password!");
        }
        IdentifyType identifyType=new IdentifyType();
        identifyType.setEmail(email);
        identifyType.setUserType(user.getType());
        return identifyType;
    }

    public static void main(String[] args){

        AuthRequestType authRequestType=new AuthRequestType();
        authRequestType.setEmail("151250004@smail.nju.edu.cn");
        authRequestType.setPassword("151250004");
        try {
            AuthController authController=new AuthController();
            IdentifyType identifyType=authController.identify(authRequestType);
            System.out.println(identifyType.getUserType());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
