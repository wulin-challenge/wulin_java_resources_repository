package cn.itcast.bbs.util;

import java.security.MessageDigest;

//基于MD5单向加密
public class Demo3 {
	private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	//将明文字符中以MD5方式加密后返回可读的十六进制数字符串
	public static String encodeByMd5(String password) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("md5");
		byte[] results = md5.digest(password.getBytes());
		return byteArrayToString(results);
	}
	//将byte[]转成String返回
	private static String byteArrayToString(byte[] results){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<results.length;i++){
			//将每一位byte转发String
			sb.append(byteToString(results[i]));
		}
		return sb.toString();
	}
	//将每一位byte转发String(核心算法)
	private static String byteToString(byte b){
		int n = b;
		if(n < 0 ){
			n = 256 + n ; 
		}
		//十六进制的第一位
		int d1 = n / 16;
		
		//十六进制的第二位
		int d2 = n % 16;
		
		//(十)  0-255 共256个
		//(十六)0-FF
		
		return hex[d1] + hex[d2];
	}
}
