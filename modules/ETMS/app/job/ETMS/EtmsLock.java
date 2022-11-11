package job.ETMS;

import models.ETMS.*;
import org.apache.commons.lang.StringUtils;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;

import java.util.*;

/**
 * /createticket
 * 获取电子票号接口，中心锁座后开始调用
 */
public class EtmsLock  extends Job {
    public EtmsCommonReq etmsCommonReq;

    public EtmsLock(EtmsCommonReq etmsCommonReq){
        this.etmsCommonReq = etmsCommonReq;
    }

    public EtmsLock(LockRequestApi lockRequestApi, LockResponseApi lockResponseApi, String routecode){
        etmsCommonReq = new EtmsCommonReq<SeatInfos>();
        etmsCommonReq.orderno = lockRequestApi.orderno;
        etmsCommonReq.schedulecode = lockRequestApi.schedulecode;
        etmsCommonReq.departdate = StringUtils.join(lockRequestApi.departdate.split("-"), "");
        etmsCommonReq.departtime = StringUtils.join(lockRequestApi.departtime.split(":"), "")+"00";
        etmsCommonReq.bookingtype = "01";
        etmsCommonReq.sellorgan = "湖北道路客运联网中心官网";
        etmsCommonReq.paytype = "3";
        etmsCommonReq.startstationcode = lockRequestApi.departstationcode;
        etmsCommonReq.startstationname = lockResponseApi.departorgname;
        etmsCommonReq.reachstationcode = lockRequestApi.reachstationcode;
        etmsCommonReq.reachstationname = lockResponseApi.reachstationname;
        etmsCommonReq.scheduleproperty = "1";
        etmsCommonReq.scheduletype = "1";
        etmsCommonReq.planbuscode = "";
        etmsCommonReq.licenseplatecolor = "1";
        etmsCommonReq.vehicletype = "12";
        etmsCommonReq.vehiclelevel = "1";
        etmsCommonReq.linecode = routecode;

        List<SeatInfos> seatInfos = new ArrayList<SeatInfos>();
        for (int i = 0; i< lockRequestApi.tickets.size(); i++) {
            TicketInfo ticketInfo = lockRequestApi.tickets.get(i);
            LockResTicketInfo info = lockResponseApi.tickets.get(i);
            SeatInfos s = new SeatInfos();
            s.netticketid = info.netticketid;
            s.tickettype = "1";
            s.kidseats = 0;
            s.seatnumber = info.seatno;
            s.ticketprice = ticketInfo.price;
            s.maxticketprice = ticketInfo.price;
            s.seattype = "1";
            s.customername = ticketInfo.customername;
            s.certificatetype = "1";
            s.idnumber = ticketInfo.certificateno;
            s.mobilephonenumber = ticketInfo.phone;
            s.insuranceno = "";
            seatInfos.add(s);
        }
        etmsCommonReq.seatinfos = seatInfos;
    }

    public EtmsCommonRes doJobWithResult(){
        String etms_url = PropertyUtil.getProperty("etms.url");
        String jsr = JsonUtil.parseObject(this.etmsCommonReq);
        play.Logger.info("ETMS.lock===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/createticket", jsr);
        play.Logger.info("ETMS.lock===>" + res);
        EtmsCommonRes<TicketInfos> ctr = (EtmsCommonRes) JsonUtil.readJson2Entity(res, EtmsCommonRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            for(Object tmp : this.etmsCommonReq.seatinfos){
                SeatInfos s = (SeatInfos) JsonUtil.readJson2Entity(JsonUtil.parseObject(tmp), SeatInfos.class);
                for (Object o: ctr.ticketinfos) {
                    TicketInfos t = (TicketInfos) JsonUtil.readJson2Entity(JsonUtil.parseObject(o), TicketInfos.class);
                    if(s.idnumber.equals(t.idnumber) && s.customername.equals(t.customername)){
                        t.oldnetticketid = s.netticketid;
                        EtmsInfo e = new EtmsInfo();
                        e.orderno = ctr.orderno;
                        e.netticketid = t.oldnetticketid;
                        e.etmsid = t.netticketid;
                        e.created = new Date();
                        e.status = 0;
                        e.statusrs = "0-0";
                        e.save();
                        break;
                    }
                }
            }
        } else {
            for(Object tmp : this.etmsCommonReq.seatinfos){
                SeatInfos s = (SeatInfos) JsonUtil.readJson2Entity(JsonUtil.parseObject(tmp), SeatInfos.class);
                EtmsInfo e = new EtmsInfo();
                e.orderno = this.etmsCommonReq.orderno;
                e.netticketid = s.netticketid;
                e.etmsid = null; //存空，后面补偿调用
                e.created = new Date();
                e.status = 0;
                e.statusrs = "0-0";
                e.save();
            }
        }
        return ctr;
    }
}
