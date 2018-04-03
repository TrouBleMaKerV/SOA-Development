package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "成绩类型")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddScoreType {

    @XmlElement(name = "学号",required = true)
    protected String sid;
    @XmlElement(name = "课程编号",required = true)
    protected String cid;
    @XmlElement(name = "成绩类型",required = true)
    protected String type;
    @XmlElement(name = "分数",required = true)
    protected int score;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
