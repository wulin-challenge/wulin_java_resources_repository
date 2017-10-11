package cn.wulin.util;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.wulin.util.domain.DataConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPools {
	private DataSource data=null;
	private Map<String ,ComboPooledDataSource> pools = new HashMap<String,ComboPooledDataSource>(); 
	
	/**通过c3p0得到数据源*/
	public ComboPooledDataSource getDataSource(String databaseName){
		this.isEmptyToMap();
		return pools.get(databaseName);
	}
	
	/**创建数据源*/
	public void createCombopooled(){
		if(this.data==null){
			this.data = new DataSource();
		}
		Map<String,DataConnection> manyConnection = data.getManyConnection();
		Set<String> keyName=manyConnection.keySet();
		for (String key : keyName) {
			pools.put(key,setDataSource(key));
		}
	}
	
	/**为数据源设置值*/
	public ComboPooledDataSource setDataSource(String key){
		ComboPooledDataSource source = new ComboPooledDataSource();
		DataConnection dataConnection = data.getDataConnection(key);
		try {
			source.setUser(dataConnection.getUser());
			source.setPassword(dataConnection.getPassword());
			source.setJdbcUrl(dataConnection.getUrl());
			source.setDriverClass(dataConnection.getDriver());
			source.setInitialPoolSize(3);
			source.setMinPoolSize(1);
			source.setMaxPoolSize(10);
			source.setMaxStatements(50);
			source.setMaxIdleTime(60);
			source.setAcquireIncrement(5);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return source;
	}
	
	/**判断集合是否为空*/
	public void isEmptyToMap(){
		if(pools.isEmpty()||pools.size()==0){
			this.createCombopooled();
		}
	}
}
