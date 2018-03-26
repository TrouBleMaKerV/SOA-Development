package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

/**
 * Created by Administrator on 2018/3/26.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultType", propOrder = {

})
public class FaultType {

    @XmlElement(name = "ParamIndex", required = true)
    protected BigInteger paramIndex;
    @XmlElement(name = "FaultInfo", required = true)
    protected String faultInfo;
    @XmlAttribute(name = "ParamName")
    protected String paramName;

    public FaultType(BigInteger paramIndex, String faultInfo, String paramName) {
        this.paramIndex = paramIndex;
        this.faultInfo = faultInfo;
        this.paramName = paramName;
    }

    public BigInteger getParamIndex() {
        return paramIndex;
    }


    public void setParamIndex(BigInteger value) {
        this.paramIndex = value;
    }


    public String getFaultInfo() {
        return faultInfo;
    }


    public void setFaultInfo(String value) {
        this.faultInfo = value;
    }


    public String getParamName() {
        return paramName;
    }


    public void setParamName(String value) {
        this.paramName = value;
    }
}
