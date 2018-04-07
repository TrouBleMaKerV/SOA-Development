package com.soa12.assignment10.controller;

import com.soa12.assignment10.controllerWS.ScoreManage;
import com.soa12.assignment10.dao.ScoreDao;
import com.soa12.assignment10.model.ScoreEntity;
import com.soa12.assignment10.schemaModel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import java.util.ArrayList;
import java.util.List;

@WebService(name = "ScoreManage",targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
public class ScoreManageController implements ScoreManage {

    @Resource
    private ScoreDao scoreDao;

    @WebMethod(action = "ScoreManage/getScore")
    @WebResult(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "ScoreManage/getScoreRequest", output = "ScoreManage/getScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public CourseScoreListType getScore(UserIdType userIdType) throws IdNotFoundException {
        CourseScoreListType courseScoreListType = new CourseScoreListType();
        String sid = String.valueOf(userIdType.getStudentId());
        System.out.println(sid);
        List<ScoreEntity> scoreEntities = new ArrayList<>();
        scoreEntities = scoreDao.findBySid(sid);
        if (scoreEntities == null || scoreEntities.isEmpty()){
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, sid,"");
        }
        List<CourseScore> courseScores = new ArrayList<>();
        out:for (ScoreEntity scoreEntity: scoreEntities) {
            for (CourseScore courseScore: courseScores) {
                if (courseScore.getCid().equals(scoreEntity.getCid())
                        && courseScore.getScoreType().equals(scoreEntity.getScoreType())) {
                    courseScore.getCourseScoreTypes().add(new CourseScoreType(scoreEntity.getSid(),scoreEntity.getScore()));
                    continue out;
                }
            }
            List<CourseScoreType> courseScoreTypes = new ArrayList<>();
            courseScoreTypes.add(new CourseScoreType(scoreEntity.getSid(),scoreEntity.getScore()));
            CourseScore courseScore = new CourseScore(courseScoreTypes, scoreEntity.getCid(),ScoreType.valueOf(scoreEntity.getScoreType()));
            courseScores.add(courseScore);
        }
        courseScoreListType.setCourseScores(courseScores);
        return courseScoreListType;
    }

    @WebMethod(action = "ScoreManage/addScore")
    @WebResult(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "ScoreManage/addScoreRequest", output = "ScoreManage/addScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public CourseScoreListType addScore(AddScoreType addScoreType) throws IdNotFoundException {
        String sid = addScoreType.getSid();

//        List<ScoreEntity> scoreEntities = new ArrayList<>();
//        scoreEntities = scoreDao.findBySid(sid);
//        if (scoreEntities == null || scoreEntities.isEmpty()){
//            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, sid,"");
//        }

        String cid = addScoreType.getCid();

        int score = addScoreType.getScore();
        if (score < 0 || score > 100){
            throw new IdNotFoundException(NotFoundReasonType.输入成绩得分不合法, score+"","");
        }

        String type = addScoreType.getType();
        ScoreType scoreType = null;
        if (type.equals("期中成绩")){
            scoreType = ScoreType.期中成绩;
        }else if (type.equals("总评成绩")){
            scoreType = ScoreType.总评成绩;
        }else if (type.equals("平时成绩")){
            scoreType = ScoreType.平时成绩;
        }
        if (scoreType == null){
            throw new IdNotFoundException(NotFoundReasonType.输入成绩类型不合法, type,"");
        }

        int s = Integer.parseInt(sid);
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setCid(cid);
        scoreEntity.setScoreType(type);
        scoreEntity.setSid(sid);
        scoreEntity.setScore(score);
        scoreDao.save(scoreEntity);
        UserIdType userIdType = new UserIdType(s);
        return getScore(userIdType);
    }

    @WebMethod(action = "ScoreManage/modifyScore")
    @WebResult(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "ScoreManage/modifyScoreRequest", output = "ScoreManage/modifyScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public CourseScoreListType modifyScore(AddScoreType addScoreType) throws IdNotFoundException {
        String sid = addScoreType.getSid();

        List<ScoreEntity> scoreEntities = new ArrayList<>();
        scoreEntities = scoreDao.findBySid(sid);
        if (scoreEntities == null || scoreEntities.size()==0){
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, sid,"");
        }

        boolean cidExist=false;
        for(ScoreEntity score:scoreEntities){
            if (addScoreType.getCid().equals(score.getCid())){
                cidExist=true;
            }
        }
        if (cidExist==false){
            throw new IdNotFoundException(NotFoundReasonType.课程不存在,addScoreType.getCid(),"课程编号不存在");
        }

        String cid = addScoreType.getCid();

        int score = addScoreType.getScore();
        if (score < 0 || score > 100){
            throw new IdNotFoundException(NotFoundReasonType.输入成绩得分不合法, score+"","");
        }

        String type = addScoreType.getType();
        System.out.println("获取到的类型"+type);
        ScoreType scoreType = null;
        if (type.equals("期中成绩")){
            scoreType = ScoreType.期中成绩;
        }else if (type.equals("总评成绩")){
            scoreType = ScoreType.总评成绩;
        }else if (type.equals("平时成绩")){
            scoreType = ScoreType.平时成绩;
        }
        if (scoreType == null){
            throw new IdNotFoundException(NotFoundReasonType.输入成绩类型不合法, type,"");
        }

        int s = Integer.parseInt(sid);

        //用来存储符合条件的score
        ScoreEntity tempScore=new ScoreEntity();
        for (ScoreEntity score1:scoreEntities){
            if (score1.getCid().equals(cid) && score1.getSid().equals(sid) && score1.getScoreType().equals(type)){
                tempScore=score1;
            }
        }

        tempScore.setScore(score);
        System.out.println("修改成绩准备回填成绩这时候成绩的类型为"+tempScore.getScoreType());
        scoreDao.update(tempScore);
        UserIdType userIdType = new UserIdType(s);
        return getScore(userIdType);
    }

    @WebMethod(action = "ScoreManage/deleteScore")
    @WebResult(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @Action(input = "ScoreManage/deleteScoreRequest", output = "ScoreManage/deleteScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class)
    })
    public CourseScoreListType deleteScore(AddScoreType addScoreType) throws IdNotFoundException {
        String sid = addScoreType.getSid();

        List<ScoreEntity> scoreEntities = new ArrayList<>();
        scoreEntities = scoreDao.findBySid(sid);
        if (scoreEntities == null || scoreEntities.size()==0){
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, sid,"");
        }

        ScoreEntity todele = new ScoreEntity();
        boolean cidExist=false;
        for(ScoreEntity score:scoreEntities){
            if (addScoreType.getCid().equals(score.getCid()) && addScoreType.getType().equals(score.getScoreType()) && addScoreType.getScore() == score.getScore()){
                cidExist=true;
                todele = score;
            }
        }
        if (cidExist==false){
            throw new IdNotFoundException(NotFoundReasonType.该成绩不存在,addScoreType.getCid(),"该成绩不存在");
        }

        int s = Integer.parseInt(sid);
        scoreDao.delete(todele);
        UserIdType userIdType = new UserIdType(s);
        return getScore(userIdType);
    }



}

