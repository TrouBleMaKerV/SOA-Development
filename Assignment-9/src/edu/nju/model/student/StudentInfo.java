package edu.nju.model.student;


import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "学生信息",namespace = NameSpace.JW_NAME_SPACE)
public class StudentInfo {

    @XmlElement(name = "学生基本信息",namespace = NameSpace.JW_NAME_SPACE)
    private StudentBasicInfo basicInfo;

//    @XmlElementWrapper(name = "学生成绩")
//    @XmlElementWrapper(name = "学生成绩",namespace = NameSpace.JW_NAME_SPACE);
    @XmlElements(value = {@XmlElement(name = "成绩详情",namespace = NameSpace.JW_NAME_SPACE)})
    private List<ScoreInfo> scoreInfos;

    public StudentInfo(){

    }

    public StudentInfo(StudentBasicInfo studentBasicInfo,List<ScoreInfo> scoreInfos){
        this.basicInfo=studentBasicInfo;
        this.scoreInfos=scoreInfos;
    }

    public StudentBasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(StudentBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<ScoreInfo> getScoreInfos() {
        return scoreInfos;
    }

    public void setScoreInfos(List<ScoreInfo> scoreInfos) {
        this.scoreInfos = scoreInfos;
    }
}
