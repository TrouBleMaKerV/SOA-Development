package edu.nju.model.nju;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "人员信息",namespace = NameSpace.NJU_NAME_SPACE,propOrder = {"pName","pBirth","pSex","pId","pDepartment"})
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PersonInfo {

    @XmlElement(name = "姓名",namespace = NameSpace.NJU_NAME_SPACE)
    private String pName;

    @XmlElement(name = "出生日期")
    private Date pBirth;

    @XmlElement(name = "性别",namespace = NameSpace.NJU_NAME_SPACE)
    private Sex pSex;

    @XmlElement(name = "身份证号",namespace = NameSpace.NJU_NAME_SPACE)
    private String pId;

    @XmlElement(name = "所在部门",namespace = NameSpace.NJU_NAME_SPACE)
    private Department pDepartment;

    public PersonInfo(){

    }

    public PersonInfo(String name,Date birth,Sex sex,String id,Department department){
        this.pName=name;
        this.pBirth=birth;
        this.pSex=sex;
        this.pId=id;
        this.pDepartment=department;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getpBirth() {
        return pBirth;
    }

    public void setpBirth(Date pBirth) {
        this.pBirth = pBirth;
    }

    public Sex getpSex() {
        return pSex;
    }

    public void setpSex(Sex pSex) {
        this.pSex = pSex;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Department getpDepartment() {
        return pDepartment;
    }

    public void setpDepartment(Department pDepartment) {
        this.pDepartment = pDepartment;
    }
}
