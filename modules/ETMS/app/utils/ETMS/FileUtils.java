package utils.ETMS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static String getFileContent(String pathname) throws Exception{
		
		InputStream inputStream=null;
		StringBuffer sBuffer=new StringBuffer();
		try {
			
			File file=new File(pathname);
			inputStream=new FileInputStream(file);
			byte[] byt=new byte[1024];
			int len=0;
			if(inputStream!=null){
				
				while((len=inputStream.read(byt))!=-1){
					String str=new String(byt,0,len);
					sBuffer.append(str);
				}
				inputStream.close();
			}
			return sBuffer.toString();
		} catch (Exception e) {
			throw e;
		} 
	}
	public static File getFile(String filename) throws Exception{
		File file=new File(filename);
		return file;
	}
	//遍历文件
	public static List<File> getFileList(String path) throws Exception{
		
		List<File> list=new ArrayList<File>();
		File file=getFile(path);
		if(file.exists()){
			File[] files=file.listFiles();
			for(File f:files){
				if(!f.isDirectory()){
					list.add(f);
				}
				
				
			}
		}
		return list;
		
	}
	//把文件的路径中的反斜杆去掉
	public static String getPath(String path){
		path= path.replace("\\","/");
		char c=path.charAt(path.length()-1);
		if(c!='/'){
			path=path+"/";
		}
		return path;
	}
	public static InputStream getInputStream(String filepath) throws Exception{
		File file=FileUtils.getFile(filepath);
		InputStream inputStream=new FileInputStream(file);
		return inputStream;
	}
	public static void main(String[] args) {
		
		/*String filename="C:\\glassfish-3.1-ml\\glassfish3\\glassfish\\domains\\domain1\\logs";
		String path=FileUtils.getPath(filename);
		System.out.println(path);*/
		/*try {
			List<File> list=getFileList(filename);
			for(File f:list){
				System.out.println("filename="+f.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		StringBuffer sb=new StringBuffer();
		try {
			String filename="D:/temp/server.log";
			List<String> lines=getContent(filename);
			
			int count=0;
			for(String line:lines){
				count++;
				if(count==100){
					break;
				}
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}
	//把一个文件的内容一行一行地封装到list对象里去
	public static  List<String> getContent(String filename) throws IOException{
		
		List<String> lines=new ArrayList<String>();
		File file=new File(filename);
		FileReader fileReader=new FileReader(file);
		BufferedReader br=new BufferedReader(fileReader);
		String line=null;
		while((line=br.readLine())!=null){
			lines.add(line);
		}
		
		br.close();
		fileReader.close();
		return lines;
	}
}
