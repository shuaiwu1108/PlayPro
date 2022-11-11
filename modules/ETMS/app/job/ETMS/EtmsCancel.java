package job.ETMS;

import models.ETMS.EtmsCancelReq;
import models.ETMS.EtmsCancelRes;
import models.ETMS.EtmsInfo;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * 先实现功能，再实现异步JOB
 * /cancelticket
 * 销票接口，仅中心特权退票后调用
 */
public class EtmsCancel extends Job {
    public EtmsCancelReq etmsCancelReq;

    public EtmsCancel(EtmsCancelReq etmsCancelReq){
        this.etmsCancelReq = etmsCancelReq;
    }

    public EtmsCancelRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsCancelReq);
        play.Logger.info("ETMS.cancel===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/cancelticket", jsr);
        play.Logger.info("ETMS.cancel===>" + res);
        EtmsCancelRes ctr = (EtmsCancelRes) JsonUtil.readJson2Entity(res, EtmsCancelRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 5;
            e.statusrs = status + "-5";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("netticketid=?", this.etmsCancelReq.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-5";
            e.save();
        }
        return ctr;
    }
}
