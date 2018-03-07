package edu.nju.model.student;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "学生列表类型", namespace = NameSpace.JW_NAME_SPACE, propOrder = {
        "students"
})
@XmlRootElement(name = "学生列表", namespace = NameSpace.JW_NAME_SPACE)
public class StudentList {

    @XmlElement(name = "学生", namespace = NameSpace.JW_NAME_SPACE)
    private List<StudentInfo> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public List<StudentInfo> getStudents() {
        return students;
    }

    public void setStudents(List<StudentInfo> students) {
        this.students = students;
    }

    public void addStudent(StudentInfo student) {
        students.add(student);
    }
}
