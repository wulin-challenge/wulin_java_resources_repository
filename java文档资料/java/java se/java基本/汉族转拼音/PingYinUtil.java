package com.bjhy.province.search.core.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class PingYinUtil {
    /**
     * 将字符串中的中文转化为拼音,其他字符不变
     * 
     * @param inputString
     * @return
     */
    public static String getPingYin(String inputString) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
 
        char[] input = inputString.trim().toCharArray();
        String output = "";
 
        try {
            for (int i = 0; i < input.length; i++) {
            	
            
            	
                if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                    output += temp[0];
                } else
                    output += java.lang.Character.toString(input[i]);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public static String toSemiangle(String src) {
	        char[] c = src.toCharArray();
	        for (int index = 0; index < c.length; index++) {
	            if (c[index] == 12288) {// 全角空格
	                c[index] = (char) 32;
	            } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
	                c[index] = (char) (c[index] - 65248);
	            }
	        }
	        return String.valueOf(c);
	    }
    /**  
     * 获取汉字串拼音首字母，英文字符不变  
     * @param chinese 汉字串  
     * @return 汉语拼音首字母  
     */  
    public static String getFirstSpell(String chinese) {   
            StringBuffer pybf = new StringBuffer();  
            chinese = toSemiangle(chinese);
            
            char[] arr = chinese.toCharArray();   
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
            for (int i = 0; i < arr.length; i++) {   
                    if (arr[i] > 128) {   
                            try {   
                                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);   
                                    if (temp != null) {   
                                            pybf.append(temp[0].charAt(0));   
                                    }   
                            } catch (Exception e) { 
                            	System.out.println("该字在系统库里面没有："+arr[i]);
                            }   
                    } else {   
                            pybf.append(arr[i]);   
                    }   
            }   
            return pybf.toString().replaceAll("\\W", "").trim();   
    }   
    /**  
     * 获取汉字串拼音，英文字符不变  
     * @param chinese 汉字串  
     * @return 汉语拼音  
     */  
    public static String getFullSpell(String chinese) {   
            StringBuffer pybf = new StringBuffer();   
            chinese = toSemiangle(chinese);
            char[] arr = chinese.toCharArray();   
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
            for (int i = 0; i < arr.length; i++) {   
                    if (arr[i] > 128) {   
                            try {   
                            	String spell = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0];
                            	if(spell != null){
                            		 pybf.append(spell);   
                            	}
                                   
                            } catch (Exception e) {   
                            	System.out.println("该字在系统库里面没有："+arr[i]);
                            }   
                    } else {   
                            pybf.append(arr[i]);   
                    }   
            }   
            return pybf.toString();   
    }  
}  