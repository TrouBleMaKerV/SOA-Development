package com.soa12.assignment10.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "students", schema = "soa", catalog = "")
public class StudentEntity {
    @Column(name = "id")
    private String studentId;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "time")
    private String time;

    @Column(name = "state")
    private String state;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "IDcard")
    private String IDcard;

    @Column(name = "department")
    private String department;

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSex() {
        return sex;
    }

    public String getIDcard() {
        return IDcard;
    }

    public String getDepartment() {
        return department;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getTime() {
        return time;
    }

    public String getState() {
        return state;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setState(String state) {
        this.state = state;
    }
}
