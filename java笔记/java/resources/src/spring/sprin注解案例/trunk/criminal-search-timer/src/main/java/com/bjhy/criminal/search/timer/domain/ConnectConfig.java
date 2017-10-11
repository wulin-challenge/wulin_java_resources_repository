package com.bjhy.criminal.search.timer.domain;

/**
 * ####################################################################################
#<----------------------------------数据源连接必读-------------------------------------->
#YZ.THE.FIRST.FEW0 = 0 
#YZ.IS.ENABLE0 = true
#YZ.SYSTEM.TYPE0 = JLYZ
#YZ.DATABASE.TYPE0 = ORACLE
#YZ.PRISON.NAME0 = 第二监狱
#YZ.PRISON.NUMBER0 = 1102
#YZ.HTTP.URL0 = http://192.168.0.222:96/platform
#YZ.CONNECT.DRIVER0 = oracle.jdbc.driver.OracleDriver
#YZ.CONNECT.URL0 = jdbc:oracle:thin:@localhost:1521:orcl
#YZ.CONNECT.USERNAME0 = wulin
#YZ.CONNECT.PASSWORD0 = wulin
#YZ.CONNECT.DIALECT0 = org.hibernate.dialect.OracleDialect
#以上是数据源配置的完整格式,以后配置数据源请参考以上的配置
#解析:
# [YZ] 这里的YZ表示前缀,该前缀一般有 YZ 和 JCSJ 这两个.
#YZ.THE.FIRST.FEW后缀是一个数字,该数字必须从0开始,依次加 1 递增,YZ.THE.FIRST.FEW 的值必须与后缀相同
#	并且该组的其他key的后缀必须与YZ.THE.FIRST.FEW的值相同.
#YZ.IS.ENABLE : 表示该数据源是否启用,true表示启用,false表示停用
#YZ.SYSTEM.TYPE : 表示 表示软件系统类型
#YZ.DATABASE.TYP : 表示数据库类型
#YZ.PRISON.NAME : 表示所配置的监狱的名称
#YZ.PRISON.NUMBER : 表示所配置的监狱编号
#YZ.HTTP.URL : 表示对应狱政系统的连接URL
#YZ.CONNECT.DRIVER : 表示 数据源的驱动
#YZ.CONNECT.URL : 表示数据源连接
#YZ.CONNECT.USERNAME : 表示登陆数据源的用户名
#YZ.CONNECT.PASSWORD : 表示登陆数据源的密码
#YZ.CONNECT.DIALEC : 这是hibernate的对应的数据源方言

####################################################################################
 * @author 吴波
 *
 */
public class ConnectConfig {
	
	/**
	 * 这是第几个
	 */
	private Integer theFirstFew;
	
	/**
	 * 软件系统类型
	 */
	private String systemType;
	
	/**
	 * 是否启用
	 */
	private Boolean isEnable;
	
	/**
	 * 所用数据库类型
	 */
	private String databaseType;
	
	/**
	 * 监狱名称
	 */
	private String prisonName;
	
	/**
	 * 监狱编号
	 */
	private String prisonNumber;
	
	/**
	 * 对应的狱政系统的http请求地址
	 */
	private String httpUrl;
	
	/**
	 * 连接驱动
	 */
	private String connectDriver;
	
	/**
	 * 连接url
	 */
	private String connectUrl;
	
	/**
	 * 连接用户名
	 */
	private String connectUsername;
	
	/**
	 * 连接密码
	 */
	private String connectPassword;
	
	/**
	 * 连接方言
	 */
	private String connectDialect;

	public Integer getTheFirstFew() {
		return theFirstFew;
	}

	public void setTheFirstFew(Integer theFirstFew) {
		this.theFirstFew = theFirstFew;
	}
	
	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getPrisonName() {
		return prisonName;
	}

	public void setPrisonName(String prisonName) {
		this.prisonName = prisonName;
	}

	public String getPrisonNumber() {
		return prisonNumber;
	}

	public void setPrisonNumber(String prisonNumber) {
		this.prisonNumber = prisonNumber;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	public String getConnectDriver() {
		return connectDriver;
	}

	public void setConnectDriver(String connectDriver) {
		this.connectDriver = connectDriver;
	}

	public String getConnectUrl() {
		return connectUrl;
	}

	public void setConnectUrl(String connectUrl) {
		this.connectUrl = connectUrl;
	}

	public String getConnectUsername() {
		return connectUsername;
	}

	public void setConnectUsername(String connectUsername) {
		this.connectUsername = connectUsername;
	}

	public String getConnectPassword() {
		return connectPassword;
	}

	public void setConnectPassword(String connectPassword) {
		this.connectPassword = connectPassword;
	}

	public String getConnectDialect() {
		return connectDialect;
	}

	public void setConnectDialect(String connectDialect) {
		this.connectDialect = connectDialect;
	}
	
}
