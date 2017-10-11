package wulin.wubo.baseUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import wulin.wubo.baseDomain.Person;

public class ParseXmlUtil {
	
	public static <T> List<String> getClassProperty(T entity){
		List<String> stringList=new ArrayList<String>();
		SAXReader reader=new SAXReader();
		//String path=ParseXmlUtil.class.getClass().getResource("/my-base-mapping.xml").getPath();
		String path =Thread.currentThread().getContextClassLoader().getResource("my-base-mapping.xml").getPath();
		try{
			Document document=reader.read(new File(path));
			Element root = document.getRootElement();
			List<Element> classList=root.elements("class");
			for (Element clazz : classList) {
				if(entity.getClass().getName().equals(clazz.attributeValue("name"))){
					stringList.add(clazz.attributeValue("table"));
					List<Element> propertyList=clazz.elements();
					for (Element property : propertyList) {
						stringList.add(property.attributeValue("name"));
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return stringList;
	}
	
	public static void main(String[] args) {
		List<String> stringList=getClassProperty(new Person());
		for (String string : stringList) {
			System.out.println(string);
		}
	}

}
