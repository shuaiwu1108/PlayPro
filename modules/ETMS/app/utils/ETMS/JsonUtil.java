package utils.ETMS;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import play.Logger;

import java.io.IOException;
import java.util.Map;

public class JsonUtil {

	public static String parseObject(final Object object) {
		ObjectMapper om=new ObjectMapper();
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			Logger.log4j.error("对象转换json字符串失败", e);
		}
		return ret;
	}
	public static  Object readJson2Entity(String jsonstr,Class<?> oclass){
		try {
			ObjectMapper om = new ObjectMapper();
	        Object acc = om.readValue(jsonstr, oclass);
	        return acc;
	    } catch (Exception e) {
	    	Logger.log4j.error("json字符串转换对象失败", e);
	    }
		return null;
	}
	
	/**
	 * @author ldl
	 * 把json字符串转化为Map对象
	 * @param string
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Map paseJson2Map(String string) throws Exception{
		try {
			ObjectMapper mapper = new ObjectMapper(); 
			return mapper.readValue(string, Map.class);
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		}
	}
	   /**
     * 获取jsonnode
     * @param orgstr
     * @return
     * @throws IOException
     * @author liudelong
     */
    public static JsonNode getJsonNode(String orgstr) throws IOException{
		ObjectMapper om = new ObjectMapper();
        try {
        	JsonNode jn = om.readTree(orgstr);
        	return jn;
        } catch (IOException e) {
            throw e;
        }
	}
}
