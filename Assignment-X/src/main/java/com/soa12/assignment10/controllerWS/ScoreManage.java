package com.soa12.assignment10.controllerWS;

import com.soa12.assignment10.schemaModel.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.*;

/**
 * Created by Administrator on 2018/3/26.
 */

@WebService(name = "ScoreManage",targetNamespace = "http://jw.nju.edu.cn/schema",wsdlLocation = "../../../wsdl/Score.wsdl")
public interface ScoreManage {

    @WebMethod(action = "score/addScore")
    @RequestWrapper(localName = "addScore", targetNamespace = "http://jw.nju.edu.cn/schema", className = "cn.edu.nju.jw.schema.AddScoreType")
    @ResponseWrapper(localName = "modifyScore", targetNamespace = "http://jw.nju.edu.cn/schema", className = "cn.edu.nju.jw.schema.ModifyScoreType")
    @Action(input = "score/addScoreRequest", output = "score/addScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class, value = "score/addScore/Fault/IdNotFoundException"),
            @FaultAction(className = ScoreTypeException.class, value = "score/addScore/Fault/ScoreTypeException"),
            @FaultAction(className = ScoreModifyException.class, value = "score/addScore/Fault/ScoreModifyException"),

    })
    void addScore(
            @WebParam(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", mode = WebParam.Mode.INOUT)
                    Holder<CourseScoreListType> courseScoreListTypeHolder)
            throws  IdNotFoundException, ScoreModifyException, ScoreTypeException
            ;


    @WebMethod(action = "score/getScore")
    @WebResult(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "score/getScoreRequest", output = "score/getScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class, value = "score/getScore/Fault/IdNotFoundException")
    })
    CourseScoreListType getScore(
            @WebParam(name = "学号", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
                    String parameters)
            throws IdNotFoundException
    ;


    @WebMethod(action = "score/modifyScore")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "score/modifyScoreRequest", output = "score/modifyScoreResponse", fault = {
            @FaultAction(className = IdNotFoundException.class, value = "score/modifyScore/Fault/IdNotFoundException"),
            @FaultAction(className = ScoreTypeException.class, value = "score/modifyScore/Fault/ScoreTypeException"),
            @FaultAction(className = ScoreModifyException.class, value = "score/modifyScore/Fault/ScoreModifyException"),
    })
    void modifyScore(
            @WebParam(name = "课程成绩列表", targetNamespace = "http://jw.nju.edu.cn/schema", mode = WebParam.Mode.INOUT, partName = "parameters")
                    Holder<CourseScoreListType> parameters)
            throws  IdNotFoundException, ScoreModifyException, ScoreTypeException
    ;

}
