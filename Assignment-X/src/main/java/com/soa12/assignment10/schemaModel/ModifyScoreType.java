package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyScoreType", propOrder = {
        "courseScoreListType"
})
public class ModifyScoreType {

    @XmlElement(name = "courseScoreListType",required = true)
    protected CourseScoreListType courseScoreListType;


    public CourseScoreListType getCourseScoreListType() {
        return courseScoreListType;
    }

    public void setCourseScoreListType(CourseScoreListType value) {
        this.courseScoreListType = value;
    }

}
