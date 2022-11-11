package models.ETMS;

import java.util.List;

public class OPSellResponse extends PubResponse{
	public String uid;//商户idString(10)不可选(返回状态码为0000时)
	public String orderno;//订单号String(40)不可选(返回状态码为0000时)
	public Integer ticketcount;//总票数Int(10)不可选(返回状态码为0000时)
	public String departstationcode; // 电子客票平台发车站编码，organization.stationcode
	public String departorgcode;//发车站编码String(20)不可选(返回状态码为0000时)
	public String departorgname;//发车站名称String(50)不可选(返回状态码为0000时)
	public String departcity;//发车城市String(30)不可选
	public String reachstationname;//到达站名称String(100)不可选(返回状态码为0000时)
	public String reachstationcode;//到达站编码String(100)不可选(返回状态码为0000时)
	public String departdate;//发车日期String(10)yyyy-MM-dd不可选(返回状态码为0000时)
	public String departtime;//发车时间String(5)HH:mm不可选(返回状态码为0000时)
	public String schedulecode;//班次编码String(20)不可选(返回状态码为0000时)
	public String vehicletype;//车辆类型String(20)如：大型高一不可选
	public String seattype;//座位类型String(10)不可选
	public String vehicleno;//车牌号String20N
	public String distance;//里程String40N
	public String ticketentrance;//检票口String40N
	public String waitingroom;//候车厅String40N
	public String buspark;//乘车卡位String40N
	public String scheduletype;//班次类型String1Y
	public boolean isovertime;//是否加班boolean1Y
	public boolean islineschedule;//是否流水班boolean1Y
	public String starttime;//始发时间String5Y
	public String endtime;//末班时间String5Y
	public List<OPSellTicketOut> tickets;//车票信息String车票信息json格式见下表不可选(返回状态码为0000时)

}
