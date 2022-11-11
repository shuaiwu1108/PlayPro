package utils.ETMS;

import play.Play;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static String getProperty(String key){
		return Play.configuration.getProperty(key);
	}
	public static Object getObject(String classPath) throws InstantiationException, IllegalAccessException{
		return Play.classloader.getClassIgnoreCase(classPath).newInstance();
	}
	public static String getCzydm(){
		return getProperty("station.czydm");
	}
	public static Properties getProperties(String filepath) throws Exception{
		
		
		InputStream inputStream=FileUtils.getInputStream(filepath);
		Properties properties=new Properties();
		properties.load(inputStream);
		return properties;
	}
}
