package job.ETMS;

import models.ETMS.EtmsUploadsReq;
import models.ETMS.PublicResponseModule;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

/**
 * /uploadpapertktinfo
 * 纸质票信息上传接口， 站务、自助机， 取票成功后调用
 */
public class EtmsUpload extends Job {
    public EtmsUploadsReq etmsUploadsReq;

    public EtmsUpload(EtmsUploadsReq etmsUploadsReq){
        this.etmsUploadsReq = etmsUploadsReq;
    }

    public PublicResponseModule doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsUploadsReq);
        play.Logger.info("ETMS.uploads===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/uploadpapertktinfo", jsr);
        play.Logger.info("ETMS.uploads===>" + res);
        PublicResponseModule ctr = (PublicResponseModule) JsonUtil.readJson2Entity(res, PublicResponseModule.class);
        return ctr;
    }
}
