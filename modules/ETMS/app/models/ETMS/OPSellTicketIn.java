package models.ETMS;

public class OPSellTicketIn {

	public String tickettype;//票种String(1)Q：全票、B：半票、X：学生票、D：优惠票 Y:折扣票 W:往返票 L:联程票不可选
	public String netticketid;//电子票IDString(40)不可选
	public String takekid;//是否携带儿童String(1)0：不带1：带不可选
	public String seatno;//座位号String(5)不可选
	public Double price;//票价Double(10)不可选
	public Double servicefee;//服务费Double(10)不可选
	public String ticketno;//打印票号String(50)如果不是电子票，改字段须传实际车票号码，如果是电子票，可不传不可选
	public String customername;//乘车人姓名String(50)可选
	public String sex;//乘车人性别String(1)可选
	public Integer certificatetype;//乘车人证件类型Int(10)证件类型：0：身份证，1：学生证，2：军官证，3：驾驶证，4：护照，5：港澳通行证可选
	public String certificateno;//乘车人证件号String(30)可选
	public String phone;//乘车人手机号String(20)可选
	public String verificationcode;//取票密码String(20)可选
	public Double insureemoney;//意外伤害保险金额doubleN
	public Double insureemmoney;//意外伤害医疗保险金额doubleN
	public String insuranceno;//保险单号String50N
	public String insurecompanyname;//保险公司名称String500Y
	public String iseinsurance;//是否是电子保单String10Y
	public String insureprintno;//保险票号String50N
	public String temp1;//预留字段String50N
	public String temp2;//预留字段String50N
	public String extendsinfo;//售票附加信息String1000N

}
