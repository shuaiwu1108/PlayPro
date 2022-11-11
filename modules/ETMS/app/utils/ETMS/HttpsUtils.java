package utils.ETMS;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpsUtils {
    /**
     * http非阻塞连接超时时间，单位毫秒 4000。
     */
    public static Integer contimeout = Integer.valueOf(PropertyUtil.getProperty("http.contimeout"));
    /**
     * http非阻塞读取超时时间，单位毫秒 4000。
     */
    public static Integer readtimeout = Integer.valueOf(PropertyUtil.getProperty("http.readtimeout"));

    /*请求url获取返回的内容*/
    public static String getReturn(HttpURLConnection connection){
        StringBuffer buffer = new StringBuffer();
        //将返回的输入流转换成字符串
        try{
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            String result = buffer.toString();
            return result;
        }catch (Exception e){
            play.Logger.error("postUrlConnection出错",e);
        }
        return null;
    }

    //post请求的方法重载
    public static String getReturn(HttpURLConnection connection,String jsr){
        try{
            StringBuffer buffer = new StringBuffer();
            byte[] bytes = jsr.getBytes();
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            String result = buffer.toString();
            return result;
        }catch (Exception e){
            play.Logger.error("postUrlConnection出错",e);
        }
        return null;
    }

    public static String getReturn(String url, String jsr){
        try {
            URL fullurl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) fullurl.openConnection();
            conn.setRequestMethod("POST");// 提交模式
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(HttpsUtils.contimeout);
            conn.setReadTimeout(HttpsUtils.readtimeout);
            return getReturn(conn, jsr);
        } catch (Exception e) {
            play.Logger.info("http请求异常", e);
        }
        return null;
    }
}
