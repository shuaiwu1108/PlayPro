package models.ETMS;

import java.util.List;

public class LockResponseApi extends PubResponse{
	public String uid;//商户idString(10)不可选(返回状态码为0000时)1000000001
	public String orderno;//订单号String(40)不可选(返回状态码为0000时)760811426
	public String departorgname;//发车站名称String(50)不可选(返回状态码为0000时)扎兰屯站
	public String departorgcode;//发车站编码String(20)不可选(返回状态码为0000时)
	public String reachstationname;//到达站名称String(100)不可选(返回状态码为0000时)大杨树
	public String reachstationcode;//到达站编码String(100)不可选(返回状态码为0000时)
	public String departdate;//发车日期String(10)yyyy-MM-dd不可选(返回状态码为0000时)2014-05-23
	public String departtime;//发车时间String(5)HH:mm不可选(返回状态码为0000时)14:23
	public String schedulecode;//班次编码String(20)不可选(返回状态码为0000时)114
	public Integer ticketcount;//总票数Int(10)不可选(返回状态码为0000时)1
	public Integer insurcecount;//保票数Int(10)不可选(返回状态码为0000时)
	public String locktime;//锁座时间String(20)yyyy-MM-dd HH:mm:ss不可选(返回状态码为0000时)2014-04-25 17:27:05
	public String unlocktime;//解锁时间String(20)yyyy-MM-dd HH:mm:ss不可选(返回状态码为0000时)
	public String seattype;//座位类型String(10)不可选普通座
	public List<LockResTicketInfo> tickets;//车票信息String车票信息json格式见下表不可选(返回状态码为0000时)

}
