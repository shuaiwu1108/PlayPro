package models.ETMS;

import java.io.Serializable;

public class EtmsCancelReq implements Serializable {
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String sign = "1.0ETS_420000000000";
    public String orderno;
    public String netticketid;
    public String startstationcode;
    public String canceltime;
    public String operatorname;
    public String operatorcode;
    public String requestcode;
}
