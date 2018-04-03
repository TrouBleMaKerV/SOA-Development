package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlType(name = "成绩性质")
@XmlEnum
public enum ScoreType {

    平时成绩,
    作业成绩,
    期中成绩,
    期末成绩,
    总评成绩;

    public String value() {
        return name();
    }

    public static ScoreType fromValue(String val) {
        return valueOf(val);
    }

}
