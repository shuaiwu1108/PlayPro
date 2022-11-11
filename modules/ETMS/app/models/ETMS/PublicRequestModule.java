package models.ETMS;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.Valid;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicRequestModule implements Serializable {
    private static final long serialVersionUID = 1L;

    @Required
    @MaxSize(value = 20)
    @Valid(message = "请求唯一标识, 长度不超过20")
    public String requestid;

    @Required
    @MaxSize(value = 30)
    @Valid(message = "用户ID信息, 后台用来控制权限")
    public String userid;

    @Required
    @MaxSize(value = 50)
    @Valid(message = "用户名信息, 后台用来控制权限")
    public String username;

    @Required
    @MaxSize(value = 14)
    @Valid(message = "交易时间戳, 格式: YYYYMMDDhhmmss")
    public String timestamp;

    public static PublicRequestModule newInstance(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        PublicRequestModule req = new PublicRequestModule();
        req.requestid = sdf2.format(new Date()) + (int)(Math.random()*1000-1);
        req.userid = "admin";
        req.username = "admin";
        req.timestamp = sdf.format(new Date());
        return req;
    }
}
