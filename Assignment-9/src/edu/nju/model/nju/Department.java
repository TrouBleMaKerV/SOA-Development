package edu.nju.model.nju;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="部门信息",namespace = NameSpace.NJU_NAME_SPACE,propOrder = {"dId","dName","dPhone","campus","dLocation"})
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Department {

    @XmlElement(name = "部门编号",namespace = NameSpace.NJU_NAME_SPACE)
    private String dId;

    @XmlElement(name = "部门名称",namespace = NameSpace.NJU_NAME_SPACE)
    private String dName;

    @XmlElement(name = "部门电话",namespace = NameSpace.NJU_NAME_SPACE)
    private String dPhone;

    @XmlElement(name = "校区",namespace = NameSpace.NJU_NAME_SPACE)
    private Campus campus;

    @XmlElement(name = "部门地址",namespace = NameSpace.NJU_NAME_SPACE)
    private String dLocation;

    public Department(){}

    public Department(String id,String name,String phone,Campus campus,String location){
        this.dId=id;
        this.dName=name;
        this.dPhone=phone;
        this.campus=campus;
        this.dLocation=location;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public String getdLocation() {
        return dLocation;
    }

    public void setdLocation(String dLocation) {
        this.dLocation = dLocation;
    }
}
