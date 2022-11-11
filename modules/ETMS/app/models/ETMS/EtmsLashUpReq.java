package models.ETMS;

import java.io.Serializable;
import java.util.List;

public class EtmsLashUpReq implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public List<EtmsLashUpInfo> lashupinfos;
}
