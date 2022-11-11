package job.ETMS;

import models.ETMS.EtmsChangeReq;
import models.ETMS.EtmsChangeRes;
import models.ETMS.EtmsInfo;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /alterticket
 * 改签接口：
 * 1. 标识当前改签，生成一个新客票， 状态03
 * 2. 更改原有车票信息，不重新生成客票， 状态08
 */
public class EtmsChange extends Job {
    public EtmsChangeReq etmsChangeReq;

    public EtmsChange(EtmsChangeReq etmsChangeReq){
        this.etmsChangeReq = etmsChangeReq;
    }

    public EtmsChangeRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsChangeReq);
        play.Logger.info("ETMS.change===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/alterticket", jsr);
        play.Logger.info("ETMS.change===>" + res);
        EtmsChangeRes ctr = (EtmsChangeRes) JsonUtil.readJson2Entity(res, EtmsChangeRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 8;
            e.statusrs = status + "-8";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("netticketid=?", ctr.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-8";
            e.save();
            return null;
        }
        return ctr;
    }
}
