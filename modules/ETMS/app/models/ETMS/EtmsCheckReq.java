package models.ETMS;

import java.io.Serializable;

public class EtmsCheckReq implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String orderno;
    public String netticketid;
    public String startstationcode;
    public String customername;
    public String checkintime;
    public String ticketbarrier;//检票口
    public String ticketchecktype;
    public String checkmachineno;
    public String checkvouchertype;
    public String certificatetype;
    public String idnumber;
    public String departdate;
    public String departtime;
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
