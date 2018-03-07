package edu.nju.model.nju;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "校区地址", namespace = NameSpace.NJU_NAME_SPACE)
@XmlEnum
public enum  Campus {
    鼓楼,
    仙林;

    public String value() {
        return name();
    }

    public static Campus fromValue(String v) {
        return valueOf(v);
    }
}
