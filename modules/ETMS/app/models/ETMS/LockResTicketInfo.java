package models.ETMS;

public class LockResTicketInfo {
	public String tickettype;//票种String(10)Q：全票、B：半票、X：学生票、D：优惠票 Y:折扣票 W:往返票 L:联程票不可选
	public String netticketid;//电子票IDString(40)不可选
	public Double price;//票价Double(10)不可选
	public String seatno;//座位号String(4)不可选
	public String takekid;//是否带儿童String(1)不可选
	public String seattype;//坐型String(20)普通座、商务座、卧铺等等不可选
}
