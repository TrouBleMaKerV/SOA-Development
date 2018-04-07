package com.soa12.assignment10.controllerWS;

import com.soa12.assignment10.schemaModel.*;

import javax.jws.WebParam;
import javax.xml.ws.Holder;

public interface ScoreManage {

    CourseScoreListType getScore(@WebParam UserIdType userIdType)throws IdNotFoundException;
    CourseScoreListType addScore(@WebParam AddScoreType addScoreType)throws IdNotFoundException;
    CourseScoreListType modifyScore(@WebParam AddScoreType addScoreType)throws IdNotFoundException;
    CourseScoreListType deleteScore(@WebParam AddScoreType addScoreType)throws IdNotFoundException;
}
