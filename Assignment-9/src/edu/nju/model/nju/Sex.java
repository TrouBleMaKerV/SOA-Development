package edu.nju.model.nju;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "性别",namespace = NameSpace.NJU_NAME_SPACE)
@XmlEnum
public enum Sex {
    男,
    女,
    保留;

    public String value() {
        return name();
    }

    public static Sex fromValue(String v) {
        return valueOf(v);
    }
}
