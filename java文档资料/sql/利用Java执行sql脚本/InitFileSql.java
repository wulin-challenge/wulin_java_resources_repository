package org.apel.poseidon.core.init;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.ibatis.common.jdbc.ScriptRunner;

/**
 * 初始化文件sql
 * @author wubo
 *
 */
public class InitFileSql {
	
	private static String rootDirectory = "file:"+System.getProperty("user.dir")+"/data-init-directory/sql/init_*.sql";
	
	public static void main(String[] args) throws IOException, SQLException {
		DataSource datasource = getDatasource();
		Connection conn = datasource.getConnection();
		rootDirectory = replate(rootDirectory);
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources(rootDirectory);
		for (Resource resource : resources) {
			EncodedResource er = new EncodedResource(resource, "utf-8");
            ScriptUtils.executeSqlScript(conn, er); //要源码来解决 日期问题,源码很简单的
		}
		System.out.println();
	}
	
	private static DataSource getDatasource(){
		
		DruidDataSource dataSource = new DruidDataSource();
		String username = "platform_test";
		String password = "123456789";
		String url = "jdbc:oracle:thin:@192.168.0.49:1521:orcl";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
	
	private static String replate(String s){
		s = s.replace("\\", "/");
		s = s.replace("\\\\", "/");
		return s;
	}

}
