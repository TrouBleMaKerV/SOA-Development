package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "UserIdType")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserIdType {

    @XmlElement(name = "学号")
    protected int studentId;

//    public AuthRequestType(String mail,String pass){
//        email=mail;
//        password=pass;
//    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
