package cn.lh.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
	public static final String EXPORT_PATH = "/export/download/";
	public static final String IMAGE_PATH = "/export/image/";
	public static final String TEMPLATE_PATH ="/cn/lh/template";
	public static final String EXPORT1="export1.doc";
	public static final String EXPORT2="export2.doc";
	public static final String EXPORT3="export3.doc";
	public static final String EXPORT4="export4.doc";
	public static final String APPROVE1 ="approve1.xml";
	public static final String APPROVE2 ="approve2.xml";
	public static final String APPROVE3 ="approve3.xml";
	public static final String APPROVE4 ="approve4.xml";
	public static final String WORD_NAME1 ="资阳市医疗保险特殊疾病申报审批表.doc";
	public static final String WORD_NAME2 ="3个医院异地登记审批表.doc";
	public static final String WORD_NAME3 ="单病申报审批表欧.doc";
	public static final String WORD_NAME4 ="社会保障卡申领登记表(新版20140716).doc";
	
	public static final String BANK_VALUE ="  √";
	
	
	public static String getRealPath(HttpServletRequest request,String filePath,String fileName){
		isExistOfFilePath(request,filePath);
		return request.getSession().getServletContext().getRealPath(filePath+fileName);
	}
	
	public static void isExistOfFilePath(HttpServletRequest request,String filePath){
		filePath = request.getSession().getServletContext().getRealPath(filePath);
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
	}

}
