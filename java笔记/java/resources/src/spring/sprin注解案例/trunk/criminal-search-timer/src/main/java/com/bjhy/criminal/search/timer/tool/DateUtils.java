package com.bjhy.criminal.search.timer.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author wangbowen
 *
 */
public class DateUtils {
	
	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date StrToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = null;
	   try {
		if(str!=null){
	    date = format.parse(str);
		}
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}


}
