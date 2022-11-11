package controllers.ETMS;

import job.ETMS.*;
import models.ETMS.*;
import play.libs.F;
import play.mvc.Controller;
import utils.ETMS.JsonUtil;

import java.util.concurrent.TimeUnit;

public class EtmsApiController extends Controller {
    public static void createticket(String uid, String data, String md5){
        EtmsCommonReq<SeatInfos> etmsCommonReq = (EtmsCommonReq<SeatInfos>) JsonUtil.readJson2Entity(data, EtmsCommonReq.class);
        EtmsLock etmsLock = new EtmsLock(etmsCommonReq);
        F.Promise promise = etmsLock.now();
        EtmsCommonRes etmsCommonRes = null;
        try {
            etmsCommonRes = (EtmsCommonRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms lock error", e);
        }
        renderText(JsonUtil.parseObject(etmsCommonRes));
    }

    public static void createqr(String uid, String data, String md5){
        EtmsCommonReq<SeatInfos> etmsCommonReq = (EtmsCommonReq) JsonUtil.readJson2Entity(data, EtmsCommonReq.class);
        EtmsSell etmsSell = new EtmsSell(etmsCommonReq);
        F.Promise promise = etmsSell.now();
        EtmsCommonRes etmsCommonRes = null;
        try {
            etmsCommonRes = (EtmsCommonRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms sell error", e);
        }
        renderText(JsonUtil.parseObject(etmsCommonRes));
    }

    public static void checkinticket(String uid, String data, String md5){
        EtmsCheckReq etmsCheckReq = (EtmsCheckReq) JsonUtil.readJson2Entity(data, EtmsCheckReq.class);
        EtmsCheck etmsSell = new EtmsCheck(etmsCheckReq);
        F.Promise promise = etmsSell.now();
        EtmsCheckRes etmsCheckRes = null;
        try {
            etmsCheckRes = (EtmsCheckRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms check error", e);
        }
        renderText(JsonUtil.parseObject(etmsCheckRes));
    }

    public static void returnticket(String uid, String data, String md5){
        EtmsReturnReq etmsReturnReq = (EtmsReturnReq) JsonUtil.readJson2Entity(data, EtmsReturnReq.class);
        EtmsReturn etmsReturn = new EtmsReturn(etmsReturnReq);
        F.Promise promise = etmsReturn.now();
        EtmsReturnRes etmsReturnRes = null;
        try {
            etmsReturnRes = (EtmsReturnRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms return error", e);
        }
        renderText(JsonUtil.parseObject(etmsReturnRes));
    }

    public static void alterticket(String uid, String data, String md5){
        EtmsChangeReq etmsChangeRes = (EtmsChangeReq) JsonUtil.readJson2Entity(data, EtmsChangeReq.class);
        EtmsChange etmsChange = new EtmsChange(etmsChangeRes);
        F.Promise promise = etmsChange.now();
        EtmsChangeRes etmsCancelRes = null;
        try {
            etmsCancelRes = (EtmsChangeRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms change error", e);
        }
        renderText(JsonUtil.parseObject(etmsCancelRes));
    }

    public static void cancelticket(String uid, String data, String md5){
        EtmsCancelReq etmsCancelReq = (EtmsCancelReq) JsonUtil.readJson2Entity(data, EtmsCancelReq.class);
        EtmsCancel etmsCancel = new EtmsCancel(etmsCancelReq);
        F.Promise promise = etmsCancel.now();
        EtmsCancelRes etmsCancelRes  = null;
        try {
            etmsCancelRes = (EtmsCancelRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms change error", e);
        }
        renderText(JsonUtil.parseObject(etmsCancelRes));
    }

    public static void taketicket(String uid, String data, String md5){
        EtmsTakeReq etmsTakeReq = (EtmsTakeReq) JsonUtil.readJson2Entity(data, EtmsTakeReq.class);
        EtmsTake etmsTake = new EtmsTake(etmsTakeReq);
        F.Promise promise = etmsTake.now();
        EtmsTakeRes etmsTakeRes = null;
        try {
            etmsTakeRes = (EtmsTakeRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms take error", e);
        }
        renderText(JsonUtil.parseObject(etmsTakeRes));
    }

    public static void uploadpapertktinfo(String uid, String data, String md5){
        EtmsUploadsReq etmsUploadsReq = (EtmsUploadsReq) JsonUtil.readJson2Entity(data, EtmsUploadsReq.class);
        EtmsUpload etmsUpload = new EtmsUpload(etmsUploadsReq);
        F.Promise promise = etmsUpload.now();
        PublicResponseModule publicResponseModule = null;
        try {
            publicResponseModule = (PublicResponseModule) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms upload error", e);
        }
        renderText(JsonUtil.parseObject(publicResponseModule));
    }

    public static void recovercheckinticket(String uid, String data, String md5){
        EtmsUnCheckReq etmsUnCheckReq = (EtmsUnCheckReq) JsonUtil.readJson2Entity(data, EtmsUnCheckReq.class);
        EtmsUnCheck etmsUnCheck = new EtmsUnCheck(etmsUnCheckReq);
        F.Promise promise = etmsUnCheck.now();
        EtmsUnCheckRes etmsUnCheckRes = null;
        try {
            etmsUnCheckRes = (EtmsUnCheckRes) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms uncheck error", e);
        }
        renderText(JsonUtil.parseObject(etmsUnCheckRes));
    }

    public static void uploadLashUpTkts(String uid, String data, String md5){
        EtmsLashUpReq etmsLashUpReq = (EtmsLashUpReq) JsonUtil.readJson2Entity(data, EtmsLashUpReq.class);
        EtmsLashUp etmsLashUp = new EtmsLashUp(etmsLashUpReq);
        F.Promise promise = etmsLashUp.now();
        PublicResponseModule publicResponseModule = null;
        try {
            publicResponseModule = (PublicResponseModule) promise.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            play.Logger.error("api etms lashup error", e);
        }
        renderText(JsonUtil.parseObject(publicResponseModule));
    }
}
