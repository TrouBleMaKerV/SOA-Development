package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "身份类型")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentifyType {

    @XmlElement(name = "邮箱",required = true)
    protected String email;
    @XmlElement(name = "身份",required = true)
    protected UserType userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
