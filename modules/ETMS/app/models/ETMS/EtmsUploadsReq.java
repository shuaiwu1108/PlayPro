package models.ETMS;

import java.io.Serializable;
import java.util.List;

public class EtmsUploadsReq implements Serializable {
    public String sign = "1.0ETS_420000000000";
    public PublicRequestModule publicrequest = PublicRequestModule.newInstance();
    public List<EtmsUploadsInfo> paperinfos;
}
