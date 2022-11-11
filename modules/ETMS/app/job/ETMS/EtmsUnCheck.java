package job.ETMS;

import models.ETMS.EtmsInfo;
import models.ETMS.EtmsUnCheckReq;
import models.ETMS.EtmsUnCheckRes;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /recovercheckinticket
 * 退检接口， 站务退检成功后调用
 */
public class EtmsUnCheck extends Job {
    public EtmsUnCheckReq etmsUnCheckReq;

    public EtmsUnCheck(EtmsUnCheckReq etmsUnCheckReq){
        this.etmsUnCheckReq = etmsUnCheckReq;
    }

    public EtmsUnCheckRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsUnCheckReq);
        play.Logger.info("ETMS.uncheck===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/recovercheckinticket", jsr);
        play.Logger.info("ETMS.uncheck===>" + res);
        EtmsUnCheckRes ctr = (EtmsUnCheckRes) JsonUtil.readJson2Entity(res, EtmsUnCheckRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 1;
            e.statusrs = status + "-1";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("netticketid=?", ctr.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-1";
            e.save();
            return null;
        }
        return ctr;
    }
}
