package xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class parseXml {
	public void parseMyXml(){
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("./my.xml"));
			Element root=document.getRootElement();
			List<Element> elements=root.elements();
			for (Element element : elements) {
				//System.out.println(element.getName());
				List<Element> elementList=element.elements();
				for (Element element2 : elementList) {
					System.out.println(element2.getText());
					
				}
				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new parseXml().parseMyXml();
	}

}
