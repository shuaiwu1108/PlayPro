package models.ETMS;

import java.io.Serializable;

public class EtmsChangeReq implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String orderno;
    public String netticketid;
    public String ticketstatus;
    public String alterrate;
    public String alterfee;
    public String operatorname;
    public String operatorcode;
    public String selltime;
    public String altertime;
    public String departdate;
    public String departtime;
    public String startstationcode;
    public String startstationname;
    public String reachstationcode;
    public String reachstationname;
    public String scheduleproperty;
    public String schedulecode;
    public String scheduletype;
    public String planbuscode;
    public String licenseplatecolor;
    public String vehicletype;
    public String vehiclelevel;
    public String linecode;
}
