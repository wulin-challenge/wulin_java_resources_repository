package com.bjhy.criminal.search.timer.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringUtils;

import com.bjhy.criminal.search.timer.domain.ConnectConfig;
import com.bjhy.criminal.search.timer.domain.JcsjJdbcTemplate;

/**
 * 连接数据库的工具类
 * @author 吴波
 *
 */
public class DBUtil {
	
	/**
	 * 加载配置文件
	 * @return Properties
	 */
	public Properties loadProperties(){
		Properties props = null;
		try {
			File rootDir = new File(System.getProperty("user.dir"));
			File dbFile = new File(rootDir, "config" + File.separator
					+ "db.properties");
			InputStream inStream = new FileInputStream(dbFile);
			props = new Properties();
			props.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * 得到所选择的连接数据库类型的连接信息集合
	 * @param prefix properties 文件的key的前缀 
	 * @param systemType 软件系统类型
	 * @param databaseType 数据库类型
	 * @return 得到配置的信息集合
	 */
	@SuppressWarnings("unchecked")
	public List<ConnectConfig> getConnectConfigList(String prefix,String systemTypeValue,String databaseTypeValue){
		List<ConnectConfig> connectList = new ArrayList<ConnectConfig>();
		Properties props = this.loadProperties();
		String systemTypeValue0 = props.getProperty(prefix+".SYSTEM.TYPE0");
		String databaseTypeValue0 = props.getProperty(prefix+".DATABASE.TYPE0");
		if(StringUtils.isEmpty(systemTypeValue0)||StringUtils.isEmpty(databaseTypeValue0)){
			return Collections.EMPTY_LIST;
		}
		if(systemTypeValue0.equals(systemTypeValue) && databaseTypeValue0.equals(databaseTypeValue)){
			int i = 0;
			int j = 0;
			do{
				j = i;
				String systemTypeKey = prefix+".THE.FIRST.FEW"+i;
				String systemTypeValue2 = props.getProperty(systemTypeKey);
				if(systemTypeValue2 != null){
					connectList.add(this.setConnectConfig(prefix, props, i));
					i++;
				}
			}while(i>j);
		}
		return connectList;
	}
	
	private ConnectConfig setConnectConfig(String prefix,Properties props,int i){
		String theFirstFew = prefix+".THE.FIRST.FEW"+i;
		String isEnable = prefix+".IS.ENABLE"+i;
		String systemType = prefix+".SYSTEM.TYPE"+i;
		String databaseType = prefix+".DATABASE.TYPE"+i;
		String prisonName = prefix+".PRISON.NAME"+i;
		String prisonNumber = prefix+".PRISON.NUMBER"+i;
		String httpUrl = prefix+".HTTP.URL"+i;
		String connectDriver = prefix+".CONNECT.DRIVER"+i;
		String connectUrl = prefix+".CONNECT.URL"+i;
		String connectUsername = prefix+".CONNECT.USERNAME"+i;
		String connectPassword = prefix+".CONNECT.PASSWORD"+i;
		String connectDialect = prefix+".CONNECT.DIALECT"+i;
		
		ConnectConfig connect = new ConnectConfig();
		
		if(!StringUtils.isEmpty(props.getProperty(theFirstFew))){
			connect.setTheFirstFew(Integer.parseInt(props.getProperty(theFirstFew).trim()));
		}
		if(!StringUtils.isEmpty(props.getProperty(isEnable).trim())){
			if("true".equals(props.getProperty(isEnable).trim())){
				connect.setIsEnable(true);
			}else if("false".equals(props.getProperty(isEnable).trim())){
				connect.setIsEnable(false);
			}else{
				connect.setIsEnable(true);
			}
		}else{
			connect.setIsEnable(true);
		}
		if(!StringUtils.isEmpty(props.getProperty(systemType))){
			connect.setSystemType(props.getProperty(systemType).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(databaseType))){
			connect.setDatabaseType(props.getProperty(databaseType).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(prisonName))){
			connect.setPrisonName(props.getProperty(prisonName).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(prisonNumber))){
			connect.setPrisonNumber(props.getProperty(prisonNumber).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(httpUrl))){
			connect.setHttpUrl(props.getProperty(httpUrl).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(connectDriver))){
			connect.setConnectDriver(props.getProperty(connectDriver).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(connectUrl))){
			connect.setConnectUrl(props.getProperty(connectUrl).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(connectUsername))){
			connect.setConnectUsername(props.getProperty(connectUsername).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(connectPassword))){
			connect.setConnectPassword(props.getProperty(connectPassword).trim());
		}
		if(!StringUtils.isEmpty(props.getProperty(connectDialect))){
			connect.setConnectDialect(props.getProperty(connectDialect).trim());
		}
		return connect;
	}
	
	/**
	 * 设置数据源
	 * @param connect
	 * @return
	 */
	public DataSource setDataSource(ConnectConfig connect) throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(connect.getConnectDriver());
		dataSource.setUrl(connect.getConnectUrl());
		dataSource.setUsername(connect.getConnectUsername());
		dataSource.setPassword(connect.getConnectPassword());
		return dataSource;
	}
	
	/**
	 * 设置JdbcTemplate
	 * @param dataSource
	 * @return
	 */
	public JcsjJdbcTemplate setJdbcTemplate(DataSource dataSource){
		return new JcsjJdbcTemplate(dataSource);
	}
	
	/**
	 * 返回JdbcTemplate的集合
	 * @param prefix 软件系统的前缀
	 * @param systemTypeValue 软件系统的类型
	 * @param databaseTypeValue 数据库类型
	 * @return
	 */
	public List<JcsjJdbcTemplate> getJdbcTemplateList(String prefix,String systemTypeValue,String databaseTypeValue){
	List<JcsjJdbcTemplate> templateList = new ArrayList<JcsjJdbcTemplate>();
		List<ConnectConfig> connectList = this.getConnectConfigList(prefix, systemTypeValue, databaseTypeValue);
		int i = 0;
		for (ConnectConfig connect : connectList) {
			if(connect.getIsEnable()){
				try {
					DataSource dataSource = this.setDataSource(connect);
					JcsjJdbcTemplate jdbdTemplate = this.setJdbcTemplate(dataSource);
					jdbdTemplate.setConnectConfig(connect);
					jdbdTemplate.setDataSource(dataSource);
					templateList.add(jdbdTemplate);
					i++;
				} catch (Exception e) {
					System.err.println("第"+(i+1)+"个数据源有错!!");
					e.printStackTrace();
				}
			}else{
				System.err.println("第"+(i+1)+"个数据源已经被停用!!");
				i++;
			}
		}
		return templateList;
	}
	
	/**
	 * 测试数据源是否连接成功!!
	 * @param prefix 软件系统的前缀
	 * @param systemTypeValue 软件系统的类型
	 * @param databaseTypeValue 数据库类型
	 * @param i 第 (i+1)个数据源
	 * @return
	 */
	public Boolean isConnectSuccess(String prefix,String systemTypeValue,String databaseTypeValue ,int i){
		Boolean flag = false;
		Properties props = this.loadProperties();
		ConnectConfig connect = this.setConnectConfig(prefix, props, i);
		if(!connect.getIsEnable()){
			return flag;
		}
		if(!StringUtils.isEmpty(systemTypeValue) && !StringUtils.isEmpty(databaseTypeValue)){
			if(systemTypeValue.equals(connect.getSystemType()) && databaseTypeValue.equals(connect.getDatabaseType())){
				if(connect.getTheFirstFew() != null){
					try {
						DataSource dataSource = this.setDataSource(connect);
						dataSource.getConnection();
						flag = true;
						System.out.println("连接成功!!");
					} catch (Exception e) {
						System.err.println("连接失败!!");
						e.printStackTrace();
					}
				}else{
					System.err.println("该 [第"+(i+1)+"个] 数据源没有找到!!");
				}
			}else{
				System.err.println("输入的 软件系统类型 或 数据库类型 没有找到!!");
			}
		}else{
			System.err.println("软件系统类型 或 数据库类型 不能为空!!");
		}
		return flag;
	}

}
