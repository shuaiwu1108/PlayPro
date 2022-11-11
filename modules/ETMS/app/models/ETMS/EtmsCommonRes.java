package models.ETMS;

import java.io.Serializable;
import java.util.List;

public class EtmsCommonRes<T> implements Serializable {
    public PublicResponseModule publicresponse;

    public String orderno;

    public List<T> ticketinfos;
}
