package models.ETMS;

public class TicketInfo {
	public String tickettype;//票种String(1)Q：全票、B：半票、X：学生票、D：优惠票 Y:折扣票 W:往返票 L:联程票不可选Q
	public Double price;//票价double(10)传入票价，用于验证不可选100
	public String customername;//乘车人姓名String(20)可选张三
	public String sex;//乘车人性别String(1)可选男
	public String certificatetype;//乘车人证件类型Int(1)证件类型：0：身份证，1：学生证，2：军官证，3：驾驶证，4：护照，5：港澳通行证可选1
	public String certificateno;//乘车人证件号String(30)可选231222198809066274
	public String phone;//乘车人手机号String(15)可选
	public String takekid;//是否带儿童String(1)0:不带1:带不可选
}
