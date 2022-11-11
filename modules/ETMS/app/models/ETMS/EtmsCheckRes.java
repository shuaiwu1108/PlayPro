package models.ETMS;

import java.io.Serializable;

public class EtmsCheckRes implements Serializable {
    public PublicResponseModule publicresponse;
    public String netticketid;
    public String ticketstatus;
    public String customername;
    public String certificatetype;
    public String idnumber;
    public String schedulecode;
    public String departdate;
    public String departtime;
    public Double ticketprice;
    public Double maxticketprice;
    public String startstationcode;
    public String startstationname;
    public String reachstationcode;
    public String reachstationname;
}
