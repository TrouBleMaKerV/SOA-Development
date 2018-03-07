package edu.nju.model.student;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "学籍状态", namespace = NameSpace.JW_NAME_SPACE)
@XmlEnum
public enum StudentStatus {
    有,
    无;
    public String value() {
        return name();
    }

    public static StudentStatus fromValue(String v) {
        return valueOf(v);
    }
}
