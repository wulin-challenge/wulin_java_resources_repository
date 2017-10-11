package cn.lh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lh.domain.Export1;
import cn.lh.domain.Export2;
import cn.lh.domain.Export3;
import cn.lh.domain.Export4;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordUtil {
	
	/**
	 * 资阳市医疗保险特殊疾病申报审批表
	 * @param request
	 * @param response
	 */
	public static void  startExport1(HttpServletRequest request, HttpServletResponse response,Export1 export1){
		String filePath = CommonUtil.getRealPath(request,CommonUtil.EXPORT_PATH,CommonUtil.EXPORT1);
		Template t = WordUtil.commonWord(CommonUtil.APPROVE1);
		Writer out =WordUtil.getWriter(filePath);
		try {
			t.process(DataUtil.getData(export1), out);
			DataUtil.exportDisk(response, CommonUtil.WORD_NAME1, filePath);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 3个医院异地登记审批表
	 * @param request
	 * @param response
	 * @param export2
	 */
	public static void  startExport2(HttpServletRequest request, HttpServletResponse response,Export2 export2){
		String filePath = CommonUtil.getRealPath(request,CommonUtil.EXPORT_PATH,CommonUtil.EXPORT2);
		Template t = WordUtil.commonWord(CommonUtil.APPROVE2);
		Writer out =WordUtil.getWriter(filePath);
		try {
			t.process(DataUtil.getData(export2), out);
			DataUtil.exportDisk(response, CommonUtil.WORD_NAME2, filePath);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 单病申报审批表欧
	 * @param request
	 * @param response
	 * @param export3
	 */
	public static void  startExport3(HttpServletRequest request, HttpServletResponse response,Export3 export3){
		String filePath = CommonUtil.getRealPath(request,CommonUtil.EXPORT_PATH,CommonUtil.EXPORT3);
		Template t = WordUtil.commonWord(CommonUtil.APPROVE3);
		Writer out =WordUtil.getWriter(filePath);
		try {
			t.process(DataUtil.getData(export3), out);
			DataUtil.exportDisk(response, CommonUtil.WORD_NAME3, filePath);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 社会保障卡申领登记表(新版20140716)
	 * @param request
	 * @param response
	 * @param export4
	 */
	public static void  startExport4(HttpServletRequest request, HttpServletResponse response,Export4 export4){
		String filePath = CommonUtil.getRealPath(request,CommonUtil.EXPORT_PATH,CommonUtil.EXPORT4);
		Template t = WordUtil.commonWord(CommonUtil.APPROVE4);
		Writer out =WordUtil.getWriter(filePath);
		try {
			t.process(DataUtil.getData(export4), out);
			DataUtil.exportDisk(response, CommonUtil.WORD_NAME4, filePath);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Writer getWriter(String filePath){
		File outFile = new File(filePath);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile),"utf-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return out;
	}
	
	public static Template commonWord(String templateName){
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		configuration.setClassForTemplateLoading(WordUtil.class,
				CommonUtil.TEMPLATE_PATH);
		Template t = null;
		try {
			t = configuration.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
}
