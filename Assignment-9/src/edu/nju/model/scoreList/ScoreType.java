package edu.nju.model.scoreList;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "成绩性质", namespace = NameSpace.JW_NAME_SPACE)
@XmlEnum
public enum  ScoreType {

    平时成绩,
    作业成绩,
    期中成绩,
    期末成绩,
    总评成绩;

    public String value() {
        return name();
    }

    public static ScoreType fromValue(String v) {
        return valueOf(v);
    }
}
