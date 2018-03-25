package com.soa12.assignment10.controller;

import com.soa12.assignment10.controllerWS.Auth;
import com.soa12.assignment10.dao.UserDao;
import com.soa12.assignment10.model.UsersEntity;
import com.soa12.assignment10.schemaModel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(name = "Auth",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
public class AuthController implements Auth {
    @Resource
    private UserDao userDao;

    @Override
    public IdentifyType identify(AuthRequestType authRequestType) throws IdNotFoundException,PasswordErrorException{
        String email=authRequestType.getEmail();
        UsersEntity user=userDao.getUser(email);
        if (user==null){
            throw new IdNotFoundException(NotFoundReasonType.邮箱不存在,email,"不存在该邮箱");
        }
        if (!authRequestType.getPassword().equals(user.getPassword())){
            throw new PasswordErrorException("密码错误",email,"error password!");
        }
        IdentifyType identifyType=new IdentifyType();
        identifyType.setEmail(email);
        UserType userType=UserType.valueOf(user.getType());
        identifyType.setUserType(userType);
        return identifyType;
    }

}
