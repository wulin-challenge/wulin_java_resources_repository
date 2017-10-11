package cn.lh.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DataUtil {
	
	/**
	 * 将一个字符串拆分为一个小于或等于指定长度的List集合
	 * @param name 要拆分的字符串
	 * @param length 指定子字符串的字节长度
	 * @param rows 指定List的最大长度
	 * @return
	 */
	public static List<String> getRowsContext(String name,int length,int rows){
		List<String> nameList = new ArrayList<String>();
		try {
			byte[] nameByte = name.trim().getBytes("UTF-8");
			int row = 0;
			if(nameByte.length-length>=0){
				if(nameByte.length%length == 0){
					row = nameByte.length/length;
				}else if(nameByte.length%length >0){
					row = nameByte.length/length+1;
				}
			}else{
				row = 1;
			}
			if(row <= rows){
				for (int i = 0; i < row; i++) {
					byte[] subByte = null;
					if(i == row-1){
						subByte = Arrays.copyOfRange(nameByte, i*length,nameByte.length);
					}else{
						subByte = Arrays.copyOfRange(nameByte, i*length,(i+1)*length);
					}
					nameList.add(new String(subByte,"UTF-8"));
				}
			}else{
				for (int i = 0; i < rows; i++) {
					byte[] subByte = null;
					subByte = Arrays.copyOfRange(nameByte, i*length,(i+1)*length);
					nameList.add(new String(subByte,"UTF-8"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameList;
	}
	

	public static <T> Map<String,T> getData(T entity){
		Map<String,T> exportMap = new HashMap<String,T>();
		exportMap.put("export", entity);
		return exportMap;
	}
	
	public static String getImageStr(String filePath) {
        String imgFile = filePath;
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
	
	public static void exportDisk(HttpServletResponse response,String wordName,String filePath){
		try {
			response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(wordName,"UTF-8"));
			InputStream is = new FileInputStream(filePath);
			OutputStream os = response.getOutputStream(); 
			byte[]buf = new byte[1024];
			int len = 0;
			while((len=is.read(buf))>0){
				os.write(buf,0,len);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getRowsContextOfString(String name,int length,int rows){
		List<String> nameList = new ArrayList<String>();
		try {
			int row = 0;
			if(name.length()-length>=0){
				if(name.length()%length == 0){
					row = name.length()/length;
				}else if(name.length()%length >0){
					row = name.length()/length+1;
				}
			}else{
				row = 1;
			}
			String subString = null;
			if(row <= rows){
				for (int i = 0; i < row; i++) {
					if(i == row-1){
						subString = name.substring(i*length, name.length());
					}else{
						subString = name.substring(i*length, (i+1)*length);
					}
					nameList.add(subString);
				}
			}else{
				for (int i = 0; i < rows; i++) {
					subString = name.substring(i*length, (i+1)*length);
					nameList.add(subString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	public static List<String> getRowsContextOfString(String name,Integer[] array){
		int rows = array.length;
		List<String> nameList = new ArrayList<String>();
		for (Integer length : array) {
			try {
				int row = 0;
				if(name.length()-length>=0){
					if(name.length()%length == 0){
						row = name.length()/length;
					}else if(name.length()%length >0){
						row = name.length()/length+1;
					}
				}else{
					row = 1;
				}
				String subString = null;
				if(row <= rows){
					for (int i = 0; i < row; i++) {
						if(i == row-1){
							subString = name.substring(i*length, name.length());
						}else{
							subString = name.substring(i*length, (i+1)*length);
						}
						nameList.add(subString);
					}
				}else{
					for (int i = 0; i < rows; i++) {
						subString = name.substring(i*length, (i+1)*length);
						nameList.add(subString);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return nameList;
	}
	
	/**
	 * 排除elimilateHeaderChar字符
	 * @param name
	 * @param elimilateHeaderChar
	 * @param length
	 * @return
	 */
	public static List<String> getRowsContextOfString2(String name,Integer elimilateHeaderChar,Integer length){
		List<String> nameList = new ArrayList<String>();
		if(name.length() >=5){
			name = name.substring(elimilateHeaderChar);
			int row = 0;
			String subString = null;
			if(name.length()-length>=0){
				if(name.length()%length == 0){
					row = name.length()/length;
				}else if(name.length()%length >0){
					row = name.length()/length+1;
				}
			}else{
				row = 1;
			}
			for (int i = 0; i < row; i++) {
				if(i == row-1){
					subString = name.substring(i*length, name.length());
				}else{
					subString = name.substring(i*length, (i+1)*length);
				}
				nameList.add(subString);
			}
		}else{
			nameList.add(name);
		}
		return nameList;
	}
	
	/**
	 * 取前5个字符
	 * @param name
	 * @param fiveChar
	 * @return
	 */
	public static String getRowsContextOfString(String name,Integer fiveChar){
		if(name.length()>=5){
			name = name.substring(0,fiveChar);
		}
		return name;
	}
	
	/**
	 * 拆分已逗号分隔的字符串
	 * @param value
	 * @return
	 */
	public static List<String> getValueByKey(String value){
		String[] array= value.split(",");
		List<String> list = new ArrayList<String>();
		for (String string : array) {
			list.add(string);
		}
		return list;
	}
	
	/**
	 * -
	 * @param value
	 * @return
	 */
	public static List<String> getValueByKey1(String value){
		String[] array= value.split("-");
		List<String> list = new ArrayList<String>();
		for (String string : array) {
			list.add(string);
		}
		return list;
	}
	
	/**
	 * 将异地就医的医院级别与地址进行拆分
	 * @param hospitals
	 * @return
	 */
	public static List<String[]> getValueOfHospitals(String hospitals){
		List<String[]> list = new ArrayList<String[]>();
		String[] hs = hospitals.split(";");
		if("*".equals(hospitals)){
			String[] array = new String[]{"*","*"};
			list.add(array);
		}else{
			for (String h : hs) {
				String[] tow = h.split(",");
				list.add(tow);
			}
		}
		return list;
	}
	
	/**
	 * 将s字符串拆分为String[]
	 * @param s
	 * @return
	 */
	public static String[] getValueOfStringArray(String s){
		char[] ch = s.toCharArray();
		String[] array = new String[ch.length];
		for (int i=0;i<ch.length;i++) {
			array[i] = String.valueOf(ch[i]);
		}
		return array;
	}
}










