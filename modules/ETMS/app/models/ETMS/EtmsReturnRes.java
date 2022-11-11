package models.ETMS;

import java.io.Serializable;

public class EtmsReturnRes implements Serializable {
    public PublicResponseModule publicresponse;
    public String orderno;
    public String netticketid;
    public String ticketstatus;
    public String customername;
    public String certificatetype;
    public String idnumber;
    public Double ticketprice;
}
