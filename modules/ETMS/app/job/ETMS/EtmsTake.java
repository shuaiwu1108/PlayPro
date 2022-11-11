package job.ETMS;

import models.ETMS.EtmsInfo;
import models.ETMS.EtmsTakeReq;
import models.ETMS.EtmsTakeRes;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /taketicket
 * 取票接口， 站务、自助机， 取票成功后调用
 */
public class EtmsTake extends Job {
    public EtmsTakeReq etmsTakeReq;

    public EtmsTake(EtmsTakeReq etmsTakeReq){
        this.etmsTakeReq = etmsTakeReq;
    }

    public EtmsTakeRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsTakeReq);
        play.Logger.info("ETMS.take===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/taketicket", jsr);
        play.Logger.info("ETMS.take===>" + res);
        EtmsTakeRes ctr = (EtmsTakeRes) JsonUtil.readJson2Entity(res, EtmsTakeRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 2;
            e.statusrs = status + "-2";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("netticketid=?", ctr.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-2";
            e.save();
            return null;
        }
        return ctr;
    }
}
