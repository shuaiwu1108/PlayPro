package job.ETMS;

import models.ETMS.EtmsInfo;
import models.ETMS.EtmsReturnReq;
import models.ETMS.EtmsReturnRes;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /returnticket
 * 退票接口， 站务、中心， 退票成功后调用
 */
public class EtmsReturn  extends Job {
    public EtmsReturnReq etmsReturnReq;

    public EtmsReturn(EtmsReturnReq etmsReturnReq){
        this.etmsReturnReq = etmsReturnReq;
    }

    public EtmsReturnRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsReturnReq);
        play.Logger.info("ETMS.return===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/returnticket", jsr);
        play.Logger.info("ETMS.return===>" + res);
        EtmsReturnRes ctr = (EtmsReturnRes) JsonUtil.readJson2Entity(res, EtmsReturnRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            EtmsInfo e = EtmsInfo.find("etmsid=?", ctr.netticketid).first();
            int status = e.status;
            e.status = 6;
            e.statusrs = status + "-6";
            e.save();
        } else {
            EtmsInfo e = EtmsInfo.find("netticketid=?", this.etmsReturnReq.netticketid).first();
            int status = e.status;
            e.statusrs = status + "-6";
            e.save();
        }
        return ctr;
    }
}
