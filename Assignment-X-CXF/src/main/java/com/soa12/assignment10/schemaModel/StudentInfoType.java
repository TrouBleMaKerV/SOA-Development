package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "用户信息类型")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentInfoType {
    @XmlElement(name = "学号",required = true)
    protected int studentId;
    @XmlElement(name = "姓名",required = true)
    protected String studentName;
    @XmlElement(name = "入学时间",required = true)
    protected String time;
    @XmlElement(name = "学籍状态",required = true)
    protected String state;
    @XmlElement(name = "性别",required = true)
    protected String sex;
    @XmlElement(name = "生日",required = true)
    protected String birthday;
    @XmlElement(name = "身份证号",required = true)
    protected String IDcard;
    @XmlElement(name = "所在部门",required = true)
    protected String department;

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDepartment() {
        return department;
    }

    public String getIDcard() {
        return IDcard;
    }

    public String getSex() {
        return sex;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

