package models.ETMS;

import java.util.List;

public class LockRequestApi {
	public String version;//版本号String接口文档版本号不可选1.0
	public String uid;//商户idString(10)不可选1000000001
	public String suppliercode;//售票提供商代码String可选ZJYS, HUBYZCZ_SELL
	public String departstationcode; // 电子客票标准编码
	public String departorgcode;//客运站编码String(20)不可选
	public String schedulecode;//班次编码String(20)不可选113
	public String reachstationcode;//到达站编码String(20)不可选
	public String departdate;//发车日期String(10)不可选2014-09-12
	public String orderno;//订单号String(40)不可选
	public String departtime;//发车时间String(40)不可选12:00
	public String seattype;//座位类型String(20)不可选
	public Integer ticketcount;//票数Int(10)不可选1
	public String ordercustomername;//订单人姓名String(20)可选张三
	public Integer ordercertificatetype;//订单人证件类型Int(1)证件类型：0：身份证，1：学生证，2：军官证，3：驾驶证，4：护照，5：港澳通行证可选1
	public String ordercertificateno;//订单人证件号String(30)可选231222198809066274
	public String orderphone;//订单人手机号String(15)可选
	public String ordersex;//订单人性别String(1)可选男
	public String orderemail;//订单邮箱String(50)可选
	public Integer lockdelay;//锁位时长int可选锁座时间
	public List<TicketInfo> tickets;//购票基本信息列表Stringjson格式不可选

}
