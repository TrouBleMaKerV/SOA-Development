package edu.nju.model.student;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "学期类型", namespace = NameSpace.JW_NAME_SPACE)
@XmlEnum
public enum TermType {

    大一第一学期,
    大一第二学期,
    大二第一学期,
    大二第二学期,
    大三第一学期,
    大三第二学期,
    大四第一学期,
    大四第二学期;

    public String value() {
        return name();
    }

    public static TermType fromValue(String v) {
        return valueOf(v);
    }
}
