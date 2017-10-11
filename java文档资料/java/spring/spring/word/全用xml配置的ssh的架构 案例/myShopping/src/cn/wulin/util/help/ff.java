package cn.wulin.util.help;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ff {
	public static void main(String [] args) {
		String str = "abcdef";
		
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		transform(in, out);
		
		byte[] result = out.toByteArray();
		
		System.out.println(out);
		System.out.println(new String(result));
		
		transform(System.in, System.out); // 从键盘读，输出到显示器
	}
	
	public static void transform(InputStream in, OutputStream out) {
		int ch = 0;
		String s = "";
		try {
			while ((ch = in.read()) != -1) {
				//int upperChar = Character.toUpperCase((char)ch);
				//out.write(upperChar);
				//out.write(ch);
				char c = (char)ch;
				s =s+String.valueOf(c);
			} // close while
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
