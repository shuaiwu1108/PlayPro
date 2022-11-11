package models.ETMS;

import java.util.List;

public class OPSellRequest {
	public String version;//版本号String接口文档版本号不可选1.0
	public String uid;//商户idString(10)不可选1000000001
	public String orderno;//订单号String(40)不可选451653631236
	public String eticket;//是否电子票String(1)0:不是电子票（实时出票）1:是电子票（非实时出票）不可选
	public String ordercustomername;//订单人姓名String(20)可选张三
	public String ordersex;//订单人性别String(1)可选男
	public Integer ordercertificatetype;//订单人证件类型Int(1)证件类型：0：身份证，1：学生证，2：军官证，3：驾驶证，4：护照，5：港澳通行证可选1
	public String ordercertificateno;//订单人证件号String(30)可选231222198809066274
	public String orderphone;//订单人手机号String(15)可选
	public String orderemail;//订单邮箱String(50)可选
	public String exchangefee;//交易手续费Double(10)可选
	public String sellway;//售票方式String0-网站售票，1-自助机售票，2-手机售票，3-联网车站售票，4-代售窗口售票 5-本站售票 6-android 7-IOS 8-移动WEB 9-三方售票10-微信可选0
	public String paymethod;//支付方式String0-现金,1-贵客卡积分,2-贵客卡余额,3-银联卡 ,4-支付宝, 5-微信, 6-公务卡, 7-公交一卡通,8-银联钱包,9-线下微信 默认为3可选0
	public String canreturnmoneyback;//是否支持原路返还String0-不支持原路返还退款，1-支持原路返还退款。如果不传，默认为0可选0
	public String equipmentproviders;//设备提供商编码（售票提供商代码）String设备提供商机构编码，由联网综合管理系统定义不可选ZJYS或HUBYZCZ_SELL
	public String ticketoutlets;//售票点名称/自助机摆放地址String车站的售票点名称、或代理点名称、或站外自助机摆放地址。如果不传，默认为售票机构名称 可选
	public String seller;//售票员姓名/自助机唯一标识String窗口售票员姓名（或编码）、或自助机唯一标识。如果不传，默认为售票机构名称 可选
	public String accountorgcode;//收款机构编码String自助机银行卡支付售票时，收款机构有可能不等于售票机构。如果不传，默认为售票机构编码可选
	public String paymerchantname;//支付商户名称可选
	public String paymerchantsign;//支付商户对应收款账户可选
	public String paymerchantchannelname;//支付商户渠道名称可选
	public List<OPSellTicketIn> tickets;//车票信息String不可选

}
