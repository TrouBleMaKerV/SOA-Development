package com.soa12.assignment10.schemaModel;

import javax.xml.ws.WebFault;

/**
 * Created by Administrator on 2018/3/26.
 */

@WebFault(name = "InvalidParamFault", targetNamespace = "http://jw.nju.edu.cn/schema")
public class ScoreTypeException extends Exception{
    private FaultType faultInfo;

    public ScoreTypeException(String message, FaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }


    public ScoreTypeException(String message, FaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }


    public FaultType getFaultInfo() {
        return faultInfo;
    }
}
