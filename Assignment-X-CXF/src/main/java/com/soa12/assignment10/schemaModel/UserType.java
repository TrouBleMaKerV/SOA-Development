package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "身份种类")
@XmlEnum
public enum UserType {
    本科生,
    研究生,
    老师;

    public String value(){
        return name();
    }
}
