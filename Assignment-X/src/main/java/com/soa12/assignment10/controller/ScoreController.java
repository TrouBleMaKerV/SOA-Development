package com.soa12.assignment10.controller;

import com.soa12.assignment10.controllerWS.ScoreManage;
import com.soa12.assignment10.dao.ScoreDao;
import com.soa12.assignment10.model.ScoreEntity;
import com.soa12.assignment10.schemaModel.*;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */

@WebService(name = "ScoreManage",targetNamespace = "http://jw.nju.edu.cn/schema")
@Component
public class ScoreController implements ScoreManage{

    @Resource
    private ScoreDao scoreDao;

    @Override
    public void addScore(Holder<CourseScoreListType> courseScoreListTypeHolder) throws IdNotFoundException, ScoreModifyException, ScoreTypeException {
        ScoreEntity scoreEntityCurrent = null;
        List<ScoreEntity> scoreEntities = new ArrayList<>();
        List<CourseScore> courseScores = courseScoreListTypeHolder.value.getCourseScores();
        courseScores.forEach(courseScore -> courseScore.getCourseScoreTypes().forEach(courseScoreType -> {
            ScoreEntity scoreEntity = new ScoreEntity();
            scoreEntity.setCid(courseScore.getCid());
            scoreEntity.setScoreType(courseScore.getScoreType());
            scoreEntity.setSid(courseScoreType.getSid());
            scoreEntity.setScore(courseScoreType.getScore());
            scoreEntities.add(scoreEntity);
        }));
        try {
            for (ScoreEntity scoreEntity: scoreEntities) {
                scoreEntityCurrent = scoreEntity;
                scoreDao.save(scoreEntity);
            }
        } catch (Exception e) {
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,scoreEntityCurrent==null?"null":scoreEntityCurrent.getSid(),"");
        }
    }

    @Override
    public CourseScoreListType getScore(String parameters) throws IdNotFoundException {
        CourseScoreListType courseScoreListType = new CourseScoreListType();
        List<ScoreEntity> scoreEntities = scoreDao.findBySid(parameters);
        if (scoreEntities == null || scoreEntities.isEmpty())
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, parameters,"");
        List<CourseScore> courseScores = new ArrayList<>();
        out:for (ScoreEntity tScoreEntity: scoreEntities) {
            for (CourseScore courseScore: courseScores) {
                if (courseScore.getCid().equals(tScoreEntity.getCid())
                        && courseScore.getScoreType().equals(tScoreEntity.getScoreType())) {
                    courseScore.getCourseScoreTypes().add(new CourseScoreType(tScoreEntity.getSid(),tScoreEntity.getScore()));
                    continue out;
                }
            }
            CourseScore courseScore = new CourseScore(new ArrayList(new CourseScoreType(tScoreEntity.getSid(),tScoreEntity.getScore())),
                    tScoreEntity.getCid(),tScoreEntity.getScoreType());
            courseScores.add(courseScore);
        }
        courseScoreListType.setCourseScores(courseScores);
        return courseScoreListType;
    }

    @Override
    public void modifyScore(Holder<CourseScoreListType> parameters) throws IdNotFoundException, ScoreModifyException, ScoreTypeException {
        validate(parameters.value.getCourseScores());
        ScoreEntity scoreEntityCurrent = null;
        List<ScoreEntity> scoreEntities = new ArrayList<>();
        List<CourseScore> courseScores = parameters.value.getCourseScores();
        courseScores.forEach(courseScore -> courseScore.getCourseScoreTypes().forEach(courseScoreType -> {
            ScoreEntity scoreEntity = new ScoreEntity();
            scoreEntity.setCid(courseScore.getCid());
            scoreEntity.setScoreType(courseScore.getScoreType());
            scoreEntity.setSid(courseScoreType.getSid());
            scoreEntity.setScore(courseScoreType.getScore());
            scoreEntities.add(scoreEntity);
        }));
        try {
            for (ScoreEntity scoreEntity: scoreEntities) {
                scoreEntityCurrent = scoreEntity;
                scoreDao.save(scoreEntity);
            }
        } catch (Exception e) {
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩,scoreEntityCurrent==null?"null":scoreEntityCurrent.getSid(),"");
        }
    }


    private void validate(List<CourseScore> courseScores) throws ScoreModifyException {
        for (CourseScore courseScore : courseScores) {
            for (CourseScoreType courseScoreType : courseScore.getCourseScoreTypes()) {
                if (courseScoreType.getScore() > 100 || courseScoreType.getScore() < 0)
                    throw new ScoreModifyException(0,"score range error(acccept 0-100)","score");
                if (courseScoreType.getSid().length()!=9)
                    throw new ScoreModifyException(1,"student id length must be 9","sid");
            }
        }
    }

}
