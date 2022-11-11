package models.ETMS;

import java.io.Serializable;
import java.util.List;

public class EtmsCommonReq<T> implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public String orderno;
    public String schedulecode;
    public String departdate;
    public String departtime;
    public String bookingtype;
    public String sellorgan;
    public String paytype;
    public String startstationcode;
    public String startstationname;
    public String reachstationcode;
    public String reachstationname;
    public String scheduleproperty;
    public String scheduletype;
    public String planbuscode;
    public String licenseplatecolor;
    public String vehicletype;
    public String vehiclelevel;
    public String linecode;
    public List<T> seatinfos;
}
