package models.ETMS;

import java.io.Serializable;

public class EtmsUploadRes implements Serializable {
    public PublicResponseModule publicresponse;
    public String ticketid;
    public String netticketid;
    public String seatnumber;
    public String customername;
    public String certificatetype;
    public String idnumber;
    public String departdate;
    public String departtime;
    public String schedulecode;
    public String startstationcode;
}
