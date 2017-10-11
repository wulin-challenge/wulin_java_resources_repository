

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class TheFreemarker {
	private Configuration configuration = null;

	public TheFreemarker() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public void createDoc() {
		// 要填入模本的数据文件
		Map dataMap = new HashMap();
		getData(dataMap);
		// 设置模本装置方法和路径
		// 这里我们的模板是放在src.model包下面
		configuration.setClassForTemplateLoading(this.getClass(),
				"model");
		Template t = null;
		try {
			t = configuration.getTemplate("test2.xml");	// 装载test2.xml模板
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File("D:/导出沟通函.doc");
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile),"utf-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * @param dataMap
	 */
	private void getData(Map dataMap) {
		dataMap.put("name", "小新与小白");//姓名 xml里的标记为${name}
		dataMap.put("Tdate", "2011-12-02");//时间 xml里的标记为${Tdate}
	dataMap.put("address", "北京海淀区");//时间 xml里的标记为${address}
	dataMap.put("picture", getImageStr());
		List table2 = new ArrayList();
		for (int i = 0; i < 5; i++) {
			Table2 t = new Table2();
			t.setApplyno("BBBBBBBB-BB");
			t.setCustname("小新");
			t.setLoandate("2012-12-12");
			t.setRegion("999-999");
			table2.add(t);
		}
		dataMap.put("table2", table2);
	}
	
	private String getImageStr() {
        String imgFile = "d:/dress8.png";
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
}
