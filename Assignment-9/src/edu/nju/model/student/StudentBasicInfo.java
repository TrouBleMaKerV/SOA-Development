package edu.nju.model.student;

import edu.nju.Common.NameSpace;
import edu.nju.model.nju.PersonInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "学生基本信息",namespace = NameSpace.JW_NAME_SPACE)
@XmlAccessorType(value = XmlAccessType.FIELD)
public class StudentBasicInfo {

    @XmlElement(name = "学号",namespace = NameSpace.JW_NAME_SPACE)
    private String sid;

    @XmlElement(name = "入学时间")
    private Date date;

    @XmlElement(name = "学籍状态",namespace = NameSpace.JW_NAME_SPACE)
    private StudentStatus studentStatus;

    @XmlElement(name = "基本信息",namespace = NameSpace.NJU_NAME_SPACE)
    private PersonInfo sPersonInfo;

    public StudentBasicInfo(){}

    public StudentBasicInfo(String id,Date date,StudentStatus status,PersonInfo info){
        this.sid=id;
        this.date=date;
        this.studentStatus=status;
        this.sPersonInfo=info;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public PersonInfo getsPersonInfo() {
        return sPersonInfo;
    }

    public void setsPersonInfo(PersonInfo sPersonInfo) {
        this.sPersonInfo = sPersonInfo;
    }
}
