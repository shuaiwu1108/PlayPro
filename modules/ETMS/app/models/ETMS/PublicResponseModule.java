package models.ETMS;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.Valid;
import java.io.Serializable;

public class PublicResponseModule implements Serializable {

    @Required
    @MaxSize(value = 20)
    @Valid(message = "请求唯一标识, 请求中的requestid")
    public String requestid;

    @Required
    @MaxSize(value = 5)
    @Valid(message = "响应编码, 10000表示成功, 其它为失败")
    public String responseCode;

    @Required
    @MaxSize(value = 50)
    @Valid(message = "响应信息")
    public String responseMsg;
}
