package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "账号认证类型",propOrder = {
        "email","password"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthRequestType {

    @XmlElement(name = "邮箱")
    protected String email;

    @XmlElement(name = "密码")
    protected String password;

//    public AuthRequestType(String mail,String pass){
//        email=mail;
//        password=pass;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
