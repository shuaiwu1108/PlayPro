package job.ETMS;

import models.ETMS.*;
import org.apache.commons.lang.StringUtils;
import play.jobs.Job;
import utils.ETMS.HttpsUtils;
import utils.ETMS.JsonUtil;
import utils.ETMS.PropertyUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * /createqr
 * 出票接口，中心sell成功后调用
 */
public class EtmsSell  extends Job {
    public EtmsCommonReq etmsCommonReq;

    public EtmsSell(EtmsCommonReq etmsCommonReq){
        this.etmsCommonReq = etmsCommonReq;
    }

    public EtmsSell(OPSellRequest opSellRequest, OPSellResponse opSellResponse, String routecode){
        etmsCommonReq = new EtmsCommonReq<SeatInfos>();
        etmsCommonReq = new EtmsCommonReq<SeatInfos>();
        etmsCommonReq.orderno = opSellRequest.orderno;
        etmsCommonReq.schedulecode = opSellResponse.schedulecode;
        etmsCommonReq.departdate = StringUtils.join(opSellResponse.departdate.split("-"), "");
        etmsCommonReq.departtime = StringUtils.join(opSellResponse.departtime.split(":"), "")+"00";
        etmsCommonReq.bookingtype = "01";
        etmsCommonReq.sellorgan = "湖北道路客运联网中心官网";
        etmsCommonReq.paytype = "3";
        etmsCommonReq.startstationcode = opSellResponse.departstationcode;
        etmsCommonReq.startstationname = opSellResponse.departorgname;
        etmsCommonReq.reachstationcode = opSellResponse.reachstationcode;
        etmsCommonReq.reachstationname = opSellResponse.reachstationname;
        etmsCommonReq.scheduleproperty = "1";
        etmsCommonReq.scheduletype = "1";
        etmsCommonReq.planbuscode = "";
        etmsCommonReq.licenseplatecolor = "1";
        etmsCommonReq.vehicletype = "12";
        etmsCommonReq.vehiclelevel = "1";
        etmsCommonReq.linecode = routecode;

        List<SeatInfos> seatInfos = new ArrayList<SeatInfos>();
        for (int i = 0; i< opSellRequest.tickets.size(); i++) {
            OPSellTicketIn ticketInfo = opSellRequest.tickets.get(i);
            OPSellTicketOut info = opSellResponse.tickets.get(i);
            SeatInfos s = new SeatInfos();
            EtmsInfo etmsInfo = EtmsInfo.find("netticketid=?", info.netticketid).first();
            s.netticketid = etmsInfo.etmsid;
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
        play.Logger.info("ETMS.sell===>" + jsr);
        String res = HttpsUtils.getReturn(etms_url + "/createqr", jsr);
        play.Logger.info("ETMS.sell===>" + res);
        EtmsCommonRes<SellTicketInfos> ctr = (EtmsCommonRes) JsonUtil.readJson2Entity(res, EtmsCommonRes.class);

        if ("10000".equals(ctr.publicresponse.responseCode)) {
            for(Object o : ctr.ticketinfos){
                String tmp = JsonUtil.parseObject(o);
                SellTicketInfos s = (SellTicketInfos) JsonUtil.readJson2Entity(tmp, SellTicketInfos.class);
                EtmsInfo e = EtmsInfo.find("etmsid=?", s.netticketid).first();
                int status = e.status;
                e.status = 1;
                e.qrcode = s.qrcode;
                e.statusrs = status + "-1";
                e.save();
            }
        } else {
            for(Object tmp : this.etmsCommonReq.seatinfos){
                SeatInfos s = (SeatInfos) JsonUtil.readJson2Entity(JsonUtil.parseObject(tmp), SeatInfos.class);
                EtmsInfo e = EtmsInfo.find("netticketid=?", s.netticketid).first();
                int status = e.status;
                e.statusrs = status + "-1";
                e.save();
            }
        }
        return ctr;
    }
}
