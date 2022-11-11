package job.ETMS;

import models.ETMS.EtmsLashUpReq;
import models.ETMS.PublicResponseModule;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /uploadLashUpTkts
 * 应急票信息上传接口， 站务、自助机， 取票成功后调用
 */
public class EtmsLashUp extends Job {
    public EtmsLashUpReq etmsLashUpReq;

    public EtmsLashUp(EtmsLashUpReq etmsLashUpReq){
        this.etmsLashUpReq = etmsLashUpReq;
    }

    public PublicResponseModule doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsLashUpReq);
        play.Logger.info("ETMS.lashup===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/uploadLashUpTkts", jsr);
        play.Logger.info("ETMS.lashup===>" + res);
        PublicResponseModule ctr = (PublicResponseModule) JsonUtil.readJson2Entity(res, PublicResponseModule.class);
        return ctr;
    }
}
