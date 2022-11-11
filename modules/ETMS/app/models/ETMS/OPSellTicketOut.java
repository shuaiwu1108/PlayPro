package models.ETMS;

public class OPSellTicketOut {
	public String netticketid;//电子票IDString(40)不可选
	public String seatno;//座位号String(4)不可选
	public String ticketno;//车票号String(30)不可选
	public Double servicefee;//服务费double(10)不可选
	public String tickettype;//票种String(10)Q：全票、B：半票、X：学生票、D：优惠票 Y:折扣票 W:往返票 L:联程票不可选
	public Double price;//票价double(10)不可选
	public String verificationcode;//取票密码String(20)可选
	public String customername;//乘客姓名String(50)不可选
	public Integer certificatetype;//证件类型Int(10)证件类型：0：身份证，1：学生证，2：军官证，3：驾驶证，4：护照，5：港澳通行证不可选
	public String certificateno;//证件号String(30)不可选
	public String phone;//手机号String(20)可选
	public Double stationservicefee;//站务费double可选
	public Double fuelprice;//燃油附加费double可选
	public String selltime;//售票时间String(20)yyyyMMddHHmmss不可选
	public Double premium;//保费double可选
	public String insureprintno;//保险票号String50可选
	public String insuretype;//保险产品种类编码String50Y
	public Double insureemoney;//意外伤害保险金额doubleN
	public Double insureemmoney;//意外伤害医疗保险金额doubleN
	public String insuranceno;//保险单号String50N
	public String insurecompanyname;//保险公司名称String500Y
	public String temp1;//预留字段String50N
	public String temp2;//预留字段String50N
	public String extendsinfo;//售票附加信息String1000N

}
