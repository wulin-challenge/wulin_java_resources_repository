package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;



public class MyXml {
	
	public void createXml(){
		Document document=DocumentHelper.createDocument();
		Element root=document.addElement("students");
		Element student=root.addElement("student");
		Element name=student.addElement("name");
		Element age=student.addElement("age");
		name.addText("Íõ¶þ");
		age.addText("25");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		try {
			XMLWriter writer=new XMLWriter(new FileOutputStream("my.xml"),format);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new MyXml().createXml();
	}

}
