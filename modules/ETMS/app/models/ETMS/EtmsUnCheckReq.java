package models.ETMS;

import java.io.Serializable;

public class EtmsUnCheckReq implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String orderno;
    public String netticketid;
    public String startstationcode;

    public String operatorname;
    public String operatorcode;
    public String recoverchecktime;
}
