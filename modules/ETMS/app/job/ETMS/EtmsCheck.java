package job.ETMS;

import models.ETMS.EtmsCheckReq;
import models.ETMS.EtmsCheckRes;
import models.ETMS.EtmsInfo;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /checkinticket
 * 检票接口，站务检票后调用，站务-》前置机-》中心-》省ET
 */
public class EtmsCheck extends Job {
    public EtmsCheckReq etmsCheckReq;

    public EtmsCheck(EtmsCheckReq etmsCheckReq){
        this.etmsCheckReq = etmsCheckReq;
    }


    public EtmsCheckRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsCheckReq);
        play.Logger.info("ETMS.check===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/checkinticket", jsr);
        play.Logger.info("ETMS.check===>" + res);
        EtmsCheckRes ctr = (EtmsCheckRes) JsonUtil.readJson2Entity(res, EtmsCheckRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 7;
            e.statusrs = status + "-7";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-7";
            e.save();
        }
        return ctr;
    }
}
