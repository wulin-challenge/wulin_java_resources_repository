package cn.wulin.jni;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

public class TestNative {

	public native void sayHello();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
		
			JFileChooser c = new JFileChooser();
			c.setCurrentDirectory(new File("D:\\Program Files\\mysql\\mysql-5.5.22\\bin\\"));

			Process proc= Runtime.getRuntime().exec("cmd /c D:\\Program Files\\mysql\\mysql-5.5.22");
			//Runtime.getRuntime().exec("cmd.exe /c D:\\temp\\com.bjhy.platform.dao\\install.bat");
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));  
		    // BufferedInputStream bis = new  
		    // BufferedInputStream(proc.getInputStream());  
		    String text = null;  
		    while ((text = br.readLine()) != null) {  
			            System.out.println(text);  
		    }  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String path = System.getProperty("user.dir");
//		String osName = System.getProperty("os.name"); 
//		String startFolder = System.getProperty("user.home");
//		System.out.println(path);
//		System.out.println(osName);
//		System.out.println(startFolder);
//		try {
//			ServerSocket ss = new ServerSocket(6879);
//			String host = ss.getInetAddress().getHostAddress();
//			System.out.println(host);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			Socket client = new Socket("localhost", 8520);
//			System.out.println(client.getInetAddress().getHostAddress());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		
//		 try {
//			Runtime.getRuntime().exec("notepad");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
