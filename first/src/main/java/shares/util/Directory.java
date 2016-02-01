package shares.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Directory {
	public static ArrayList<String> dirList = new ArrayList<String>();
	public static ArrayList<testFile> fileList = new ArrayList<testFile>();
	public static HttpServletRequest request;
	public static String source = "D:/workerbook/first/";
	
	public static void init(){
		new Directory();
	}
	
	public Directory(){
		subDirList(Directory.source);
		
		// 디렉토리 생성 
		for(int i = 0 ; i < dirList.size() ; i++){
			File temp = new File(dirList.get(i));
			if(!temp.exists()){
				temp.mkdirs(); 
			}
		}
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		try{
			for(int i = 0 ; i < Directory.fileList.size() ; i++){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fileList.get(i).ft)));
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileList.get(i).path)));
				
				while(true){
					String str = br.readLine(); 
					if(str == null) break; 
					bw.write(str); 
					bw.newLine(); 
				}
				br.close(); 
				bw.close(); 
			}
		}catch(IOException E){
			
		}
	}
	
	public void subDirList(String source){
		File dir = new File(source); 
		File[] fileList = dir.listFiles();
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
					String rep = Directory.source.replaceAll("\\\\", "/"); 
					String path = file.getPath().replaceAll("\\\\", "/").replaceAll(rep, ""); 
					
					testFile tf = new testFile(); 
					tf.path = path; 
					tf.ft = file; 
					//System.out.println(path);
					
					Directory.fileList.add(tf); 
					
				}else if(file.isDirectory()){
					String rep = Directory.source.replaceAll("\\\\", "/"); 
					String path = file.getPath().replaceAll("\\\\", "/").replaceAll(rep, ""); 
					Directory.dirList.add(path);
					subDirList(file.getCanonicalPath().toString());
				}
			}
		}catch(IOException e){
			
		}
	}

}


class testFile{
	File ft = null; 
	String path = ""; 
}