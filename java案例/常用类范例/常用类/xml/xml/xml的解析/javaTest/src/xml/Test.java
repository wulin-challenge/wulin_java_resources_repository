package xml;


import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class Test {
	public static void createXml() throws Exception{
		Document document = DocumentHelper.createDocument();
		//添加根节点
		Element root = document.addElement("students");
		
		Element student1 = root.addElement("student");
		Element name1 = student1.addElement("name");
		name1.addText("王五");
		Element age1 = student1.addElement("age");
		age1.addText("20");
		
		Element student2 = root.addElement("student");
		Element name2 = student2.addElement("name");
		name2.addText("王五");
		Element age2 = student2.addElement("age");
		age2.addText("20");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("student.xml"),format);
		writer.write(document);
		writer.close();
		
	}
	
	public static void main(String[] args) throws Exception{
		createXml();
		
	}

}
