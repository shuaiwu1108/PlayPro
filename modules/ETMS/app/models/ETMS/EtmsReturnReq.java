package models.ETMS;

import java.io.Serializable;

public class EtmsReturnReq implements Serializable {
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String sign = "1.0ETS_420000000000";
    public String orderno;
    public String netticketid;
    public String startstationcode;
    public String customername;
    public String certificatetype;
    public String idnumber;
    public String schedulecode;
    public String returnorgan;
    public String returnorgancode;
    public Double returnrate;
    public Double returnfee;
    public String operatorname;
    public String operatorcode;
    public String selltime;
    public String returntime;
}
