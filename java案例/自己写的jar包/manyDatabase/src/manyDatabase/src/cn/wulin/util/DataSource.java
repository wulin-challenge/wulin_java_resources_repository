package cn.wulin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.wulin.util.domain.DataConnection;

public class DataSource {
	private Map<String,DataConnection> manyConnection = new HashMap<String,DataConnection>();
	
	/**解析properties文件,得到Properties对象*/
	public Properties getProperties(){
		InputStream is = DataSource.class.getResourceAsStream("/myJdbc.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**得到所有的数据连接对象*/
	@SuppressWarnings("unchecked")
	public void getData(){
		Properties properties = this.getProperties();
		Enumeration<String> enumsKey=(Enumeration<String>) properties.propertyNames();
		while(enumsKey.hasMoreElements()){
			String key = enumsKey.nextElement();
			createDataSource(key,properties);
		}
	}
	
	/**判断一个数据对象是否存在,如果不出在就创建一个数据对像,否则就创建一个数据对象*/
	public void createDataSource(String key,Properties properties){
		int index = key.indexOf(".");
		String prefixName = key.substring(0,index);
		String postfixName = key.substring(index+1);
		if(!manyConnection.containsKey(prefixName)){
			DataConnection dataConnection = new DataConnection();
			manyConnection.put(prefixName, dataConnection);
		}
		setManyConnection(prefixName, postfixName, key, properties);
	}
	
	/**设置manyConnection*/
	public void setManyConnection(String prefixName,String postfixName,String key,Properties properties){
		DataConnection dataConnection = manyConnection.get(prefixName);
		if(postfixName.equals("user")){
			dataConnection.setUser(properties.getProperty(key));
		}else if(postfixName.equals("password")){
			dataConnection.setPassword(properties.getProperty(key));
		}else if(postfixName.equals("url")){
			dataConnection.setUrl(properties.getProperty(key));
		}else if(postfixName.equals("driver")){
			dataConnection.setDriver(properties.getProperty(key));
		}
	}
	
	/**判断集合是否为空*/
	public void isEmptyToMap(){
		if(manyConnection.isEmpty()||manyConnection.size()==0){
			getData();
		}
	}
	
	/**得到DataConnection对象*/
	public DataConnection getDataConnection(String databaseName){
		this.isEmptyToMap();
		return manyConnection.get(databaseName);
	}
	
	/**得到所有连接*/
	public Map<String, DataConnection> getManyConnection() {
		this.isEmptyToMap();
		return manyConnection;
	}


	public static void main(String[] args) {
		DataSource dataSource = new DataSource();
		DataConnection dataConnection=dataSource.getDataConnection("oracle1");
		System.out.println(dataConnection.getUser());
		System.out.println(dataConnection.getPassword());
		System.out.println(dataConnection.getUrl());
		System.out.println(dataConnection.getDriver());
	}
}





