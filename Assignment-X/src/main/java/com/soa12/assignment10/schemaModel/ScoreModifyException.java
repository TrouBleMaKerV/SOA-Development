package com.soa12.assignment10.schemaModel;

import javax.xml.ws.WebFault;
import java.math.BigInteger;

/**
 * Created by Administrator on 2018/3/26.
 */
@WebFault(name = "InvalidParamFault", targetNamespace = "http://jw.nju.edu.cn/schema")
public class ScoreModifyException extends Exception
{


    private FaultType faultInfo;


    public ScoreModifyException(String message, FaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ScoreModifyException(int index, String info, String indexName) {
        super(info);
        faultInfo = new FaultType(new BigInteger(index+""),info, indexName);
    }


    public ScoreModifyException(String message, FaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }



    public FaultType getFaultInfo() {
        return faultInfo;
    }

}
