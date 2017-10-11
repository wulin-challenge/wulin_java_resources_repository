package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 罪犯当前信息
 * @author: wangbowen
 * @time: 2015年12月08日 
 */
@Entity
@Table(name="bs_dqxx")
public class CurrentInfo implements Serializable {
	private static final long serialVersionUID = 5418673105663581082L;
	/**
	 * 标记是病犯
	 */
	public static final int SFBF_YES = 1;
	/**
	 * 标记不是病犯
	 */
	public static final int SFBF_NO  = 0;
	/**
	 * 标记是残犯
	 */
	public static final int SFCF_YES = 1;
	/**
	 * 标记不是残犯
	 */
	public static final int SFCF_NO  = 0;
	/**
	 * 标记是老犯
	 */
	public static final int SFLF_YES = 1;
	/**
	 * 标记不是老犯
	 */
	public static final int SFLF_NO  = 0;
	/**
	 * 标记是危险犯
	 */
	public static final int SFWX_YES = 1;
	/**
	 * 标记不是危险犯
	 */
	public static final int SFWX_NO  = 0;
	/**
	 * 标记是使用戒具
	 */
	public static final int SYJJ_YES = 1;
	/**
	 * 标记不使用戒具
	 */
	public static final int SYJJ_NO = 0;
	@Id
	@Column(name="dqxxid")
	private String id;
	/**
	 * 处遇等级
	 */
	@Column(length=1000)
	private String cydj;
	/**
	 * 关押监区
	 */
	@Column(length=1000)
	private String gyjq;
	/**
	 * 关押监舍
	 */
	@Column(length=1000)
	private String gyjs;
	/**
	 * 分押类型
	 */
	@Column(length=1000)
	private String fylx;
	/**
	 * 现文化程度
	 */
	@Column(length=100)
	private String xwhcd;
	/**
	 * 现劳动能力
	 */
	@Column(length=1000)
	private String ldnl;
	/**
	 * 工种
	 */
	@Column(length=1000)
	private String gz;
	/**
	 * 剥夺政治权利期限
	 */
	@Column(length=1000)
	private String bdzzqlqx;
	/**
	 * 罚金累计交纳
	 */
	private BigDecimal fjljjn;
	/**
	 * 没收财产履行情况
	 */
	private String mscclxqk;
	/**
	 * 民事赔偿累计履行金额
	 */
	private BigDecimal mspcljlxje;
	/**
	 * 家庭状况
	 */
	private String jtzk;
	/**
	 * 当前刑种
	 */
	@Column(length=1000)
	private String dqxz;
	/**
	 * 当前刑期
	 */
	@Column(length=1000)
	private String dqxq;
	/**
	 * 入监时间
	 */
	private Date rjsj;
	/**
	 * 主罪名
	 */
	private String zzm;
	/**
	 * 罪名代码(格式：主罪名代码,从罪名代码)
	 */
	@Column(length=1000)
	private String zmdm;
	/**
	 * 刑期起日
	 */
	private Date xqqr;
	/**
	 * 当前刑期止日
	 */
	private Date dqxqzr;
	/**
	 * 已减刑期年
	 */
	private Integer yjxqn;
	/**
	 * 已减刑期月
	 */
	private Integer yjxqy;
	/**
	 * 已加刑期年
	 */
	private Integer yjiaxqn;
	/**
	 * 已加刑期月
	 */
	private Integer yjiaxqy;
	/**
	 * 是否老犯   1：是；0：否
	 */
	private Integer sflf;
	/**
	 * 是否病犯  1：是；0：否
	 */
	private Integer sfbf;
	/**
	 * 是否残犯   1：是；0：否
	 */
	private Integer sfcf;
	/**
	 * 是否危险犯   1：是；0：否
	 */
	private Integer sfwx = 0;
	/**
	 * 是否顽固犯   1：是；0：否
	 */
	private Integer sfwgf = 0;
	/**
	 * 是否使用戒具   1：是；0：否
	 */
	private Integer syjj;
	/**
	 * 关押监狱
	 */
	@Column(length=1000)
	private String gyjy;
	/**
	 * 当前标准分积分
	 */
	private String bzfjf;
	/**
	 * 罪犯状态
	 */
	@Column(length=100)
	private String zfzt;
	/**
	 * 主管民警
	 */
	private String zgmj;
	/**
	 * 创建时间
	 */
	private Long createDate;
	/**
	 * 罪犯基本信息
	 */
	@Column(length=100)
	private String zfid;
	/**
	 * 岗位集合
	 */
	@Column(length=1000)
	private String gw;
	
	@Column(length=1000)
	private String gwStr;
	/**
	 * 行政奖励次数
	 */
	private Integer xzjlcs;
	/**
	 * 行政处罚次数
	 */
	private Integer xzcfcs;
	/**
	 * 监区调动次数
	 */
	private Integer jqddcs;
	/**
	 * 余刑：剩余刑期
	 */
	@Column(length=1000)
	private String yx;
	
	/**
	 * 负分挂账及减免状态 ： 1：未报审  2：报审中 3.已报审
	 */
	private int pointState;
	/**
	 * 负分挂账及减免通过 时分数
	 */
	private double pointValue;
	/**
	 * 负分挂账及减免通过 使用分数
	 */
	private double negativeTotal;
	/**
	 * 上一次受处罚时间
	 */
	private Date cfsj;
	/**
	 * 考察期开始时间
	 */
	private Date kcqks;
	/**
	 * 考察期结束时间
	 */
	private Date kcqjs;
	//----------------------构造方法---------------------
	public CurrentInfo(){
	
	}
	public CurrentInfo(String id){
		this.id = id;
	}
	//----------------------构造方法---------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCydj() {
		return cydj;
	}
	public void setCydj(String cydj) {
		this.cydj = cydj;
	}
	public String getGyjq() {
		return gyjq;
	}
	public void setGyjq(String gyjq) {
		this.gyjq = gyjq;
	}
	public String getGyjs() {
		return gyjs;
	}
	public void setGyjs(String gyjs) {
		this.gyjs = gyjs;
	}
	public String getFylx() {
		return fylx;
	}
	public void setFylx(String fylx) {
		this.fylx = fylx;
	}
	public String getXwhcd() {
		return xwhcd;
	}
	public void setXwhcd(String xwhcd) {
		this.xwhcd = xwhcd;
	}
	public String getLdnl() {
		return ldnl;
	}
	public void setLdnl(String ldnl) {
		this.ldnl = ldnl;
	}
	public String getGz() {
		return gz;
	}
	public void setGz(String gz) {
		this.gz = gz;
	}
	public String getBdzzqlqx() {
		return bdzzqlqx;
	}
	public void setBdzzqlqx(String bdzzqlqx) {
		this.bdzzqlqx = bdzzqlqx;
	}
	public BigDecimal getFjljjn() {
		return fjljjn;
	}
	public void setFjljjn(BigDecimal fjljjn) {
		this.fjljjn = fjljjn;
	}
	public String getMscclxqk() {
		return mscclxqk;
	}
	public void setMscclxqk(String mscclxqk) {
		this.mscclxqk = mscclxqk;
	}
	public BigDecimal getMspcljlxje() {
		return mspcljlxje;
	}
	public void setMspcljlxje(BigDecimal mspcljlxje) {
		this.mspcljlxje = mspcljlxje;
	}
	public String getJtzk() {
		return jtzk;
	}
	public void setJtzk(String jtzk) {
		this.jtzk = jtzk;
	}
	public String getDqxz() {
		return dqxz;
	}
	public void setDqxz(String dqxz) {
		this.dqxz = dqxz;
	}
	public String getDqxq() {
		return dqxq;
	}
	public void setDqxq(String dqxq) {
		this.dqxq = dqxq;
	}
	public Date getRjsj() {
		return rjsj;
	}
	public void setRjsj(Date rjsj) {
		this.rjsj = rjsj;
	}
	public String getZzm() {
		return zzm;
	}
	public void setZzm(String zzm) {
		this.zzm = zzm;
	}
	public String getZmdm() {
		return zmdm;
	}
	public void setZmdm(String zmdm) {
		this.zmdm = zmdm;
	}
	public Date getXqqr() {
		return xqqr;
	}
	public void setXqqr(Date xqqr) {
		this.xqqr = xqqr;
	}
	public Date getDqxqzr() {
		return dqxqzr;
	}
	public void setDqxqzr(Date dqxqzr) {
		this.dqxqzr = dqxqzr;
	}
	public Integer getYjxqn() {
		return yjxqn;
	}
	public void setYjxqn(Integer yjxqn) {
		this.yjxqn = yjxqn;
	}
	public Integer getYjxqy() {
		return yjxqy;
	}
	public void setYjxqy(Integer yjxqy) {
		this.yjxqy = yjxqy;
	}
	public Integer getYjiaxqn() {
		return yjiaxqn;
	}
	public void setYjiaxqn(Integer yjiaxqn) {
		this.yjiaxqn = yjiaxqn;
	}
	public Integer getYjiaxqy() {
		return yjiaxqy;
	}
	public void setYjiaxqy(Integer yjiaxqy) {
		this.yjiaxqy = yjiaxqy;
	}
	public Integer getSflf() {
		return sflf;
	}
	public void setSflf(Integer sflf) {
		this.sflf = sflf;
	}
	public Integer getSfbf() {
		return sfbf;
	}
	public void setSfbf(Integer sfbf) {
		this.sfbf = sfbf;
	}
	public Integer getSfcf() {
		return sfcf;
	}
	public void setSfcf(Integer sfcf) {
		this.sfcf = sfcf;
	}
	public Integer getSfwx() {
		return sfwx;
	}
	public void setSfwx(Integer sfwx) {
		this.sfwx = sfwx;
	}
	public Integer getSfwgf() {
		return sfwgf;
	}
	public void setSfwgf(Integer sfwgf) {
		this.sfwgf = sfwgf;
	}
	public Integer getSyjj() {
		return syjj;
	}
	public void setSyjj(Integer syjj) {
		this.syjj = syjj;
	}
	public String getGyjy() {
		return gyjy;
	}
	public void setGyjy(String gyjy) {
		this.gyjy = gyjy;
	}
	public String getBzfjf() {
		return bzfjf;
	}
	public void setBzfjf(String bzfjf) {
		this.bzfjf = bzfjf;
	}
	public String getZfzt() {
		return zfzt;
	}
	public void setZfzt(String zfzt) {
		this.zfzt = zfzt;
	}
	public String getZgmj() {
		return zgmj;
	}
	public void setZgmj(String zgmj) {
		this.zgmj = zgmj;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public String getZfid() {
		return zfid;
	}
	public void setZfid(String zfid) {
		this.zfid = zfid;
	}
	public String getGw() {
		return gw;
	}
	public void setGw(String gw) {
		this.gw = gw;
	}
	public String getGwStr() {
		return gwStr;
	}
	public void setGwStr(String gwStr) {
		this.gwStr = gwStr;
	}
	public Integer getXzjlcs() {
		return xzjlcs;
	}
	public void setXzjlcs(Integer xzjlcs) {
		this.xzjlcs = xzjlcs;
	}
	public Integer getXzcfcs() {
		return xzcfcs;
	}
	public void setXzcfcs(Integer xzcfcs) {
		this.xzcfcs = xzcfcs;
	}
	public Integer getJqddcs() {
		return jqddcs;
	}
	public void setJqddcs(Integer jqddcs) {
		this.jqddcs = jqddcs;
	}
	public String getYx() {
		return yx;
	}
	public void setYx(String yx) {
		this.yx = yx;
	}
	public int getPointState() {
		return pointState;
	}
	public void setPointState(int pointState) {
		this.pointState = pointState;
	}
	public double getPointValue() {
		return pointValue;
	}
	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}
	public double getNegativeTotal() {
		return negativeTotal;
	}
	public void setNegativeTotal(double negativeTotal) {
		this.negativeTotal = negativeTotal;
	}
	public Date getCfsj() {
		return cfsj;
	}
	public void setCfsj(Date cfsj) {
		this.cfsj = cfsj;
	}
	public Date getKcqks() {
		return kcqks;
	}
	public void setKcqks(Date kcqks) {
		this.kcqks = kcqks;
	}
	public Date getKcqjs() {
		return kcqjs;
	}
	public void setKcqjs(Date kcqjs) {
		this.kcqjs = kcqjs;
	}

}
