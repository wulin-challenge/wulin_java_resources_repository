package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Description: 罪犯审判信息
 * @author: wangbowen
 * @time: 2015年12月08日 
 */
@Entity
@Table(name = "bs_zfspqk")
public class Trial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1760794038696908918L;
	public static final String DW_FJ = "（人民币）元";
	/**
	 * 标记是驱逐出境
	 */
	public static final int SFQZCJ_YES = 1;
	/**
	 * 标记不是驱逐出境
	 */
	public static final int SFQZCJ_NO  = 0;

	@Id
	private String id;
	
	/**
	 * 上诉类型
	 */
	@Column(length = 100)
	private String sslx;
	
	/**
	 * 上诉结果
	 */
	@Column(length = 100)
	private String ssjg;
	
	/**
	 * 判决类别
	 */
	@Column(length = 100)
	private String pjlb;
	
	/**
	 * 判决法院所在地区
	 */
	@Column(length = 100)
	private String pjfyszdq;
	
	/**
	 * 判决法院
	 */
	@Column(length = 100)
	private String pjfy;
	
	/**
	 * 判决案号(年度)
	 */
	@Column(length = 100)
	private String pjahnd;
	
	/**
	 * 判决案号(法院简称及字号)
	 */
	@Column(length = 100)
	private String pjahzh;

	/**
	 * 判决案号（序号）
	 */
	@Column(length = 100)
	private String pjahxh;
	
	/**
	 * 判决日期
	 */
	private Date pjrq;
	
	/**
	 * 判决罪名名称s（存放主罪名，从罪名。使用“,”分割）
	 */
	@Lob
	private String pjzmStr;
	
	/**
	 * 判决罪名ids(格式：主罪名id,从罪名id)
	 */
	@Lob
	private String pjzm;
	
	/**
	 * 刑种
	 */
	@Column(length = 100)
	private String xz;
	
	/**
	 * 刑期
	 */
	@Column(length = 100)
	private String xq;
	
	/**
	 * 刑期起日
	 */
	private Date xqqr;
	
	/**
	 * 刑期止日
	 */
	private Date xqzr;
	
	/**
	 * 附加刑，指刑法规定，补充主刑适用的刑罚方法。其特点是既能独立适用，也能附加适用。附加刑包括：
	 *	（一）罚金；
	 *	（二）剥夺政治权利；
	 *	（三）没收财产。
	 *	（四）驱逐出境。
	 */
	/**
	 * 剥夺政治权利期限
	 */
	@Column(length = 100)
	private String bdzzqlqx;
	
	/**
	 * 罚金金额
	 */
	private BigDecimal fjje;
	
	/**
	 * 是否驱逐出境
	 */
	private Integer qzcj;  

	/**
	 * 没收财产情况
	 */
	@Column(length = 1000)
	private String msccqk;  
	
	/**
	 * 附带民事判决
	 */
	@Column(length = 1000)
	private String fdmspj;
	
	/**
	 * 民事赔偿金额
	 */
	private BigDecimal mspcje;
	
	/**
	 * 是否减刑限制
	 */
	private Integer jxxz;
	
	/**
	 * 是否允许假释
	 */
	private Integer yxjs;
	
	/**
	 * 案犯类别
	 */
	@Column(length = 100)
	private String aflb;
	
	/**
	 * 执行通知书下达日期
	 */
	private Date zxtzsxdrq;
	
	/**
	 * 是否认罪服法
	 */
	private Integer rzff;
	
	/**
	 * 判决结果
	 */
	@Column(length = 1000)
	private String pjjg;
	
	/**
	 * 判决情况
	 */
	@Column(length = 1000)
	private String pjqk;  

	/**
	 * 判决缓刑年
	 */
	private Integer pjhxn; 

	/**
	 * 判决缓刑月
	 */
	private Integer pjhxy;  

	/**
	 * 判决缓刑日
	 */
	private Integer pjhxr;  

	/**
	 * 罪犯基本信息
	 */
	@Column(length = 100)
	private String zfid;
	
	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;

	/**
	 * 创建时间
	 */
	private Long createDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the 上诉类型
	 */
	public String getSslx() {
		return sslx;
	}

	/**
	 * @param 上诉类型 the sslx to set
	 */
	public void setSslx(String sslx) {
		this.sslx = sslx;
	}

	/**
	 * @return the 上诉结果
	 */
	public String getSsjg() {
		return ssjg;
	}

	/**
	 * @param 上诉结果 the ssjg to set
	 */
	public void setSsjg(String ssjg) {
		this.ssjg = ssjg;
	}

	/**
	 * @return the 判决类别
	 */
	public String getPjlb() {
		return pjlb;
	}

	/**
	 * @param 判决类别 the pjlb to set
	 */
	public void setPjlb(String pjlb) {
		this.pjlb = pjlb;
	}

	/**
	 * @return the 判决法院所在地区
	 */
	public String getPjfyszdq() {
		return pjfyszdq;
	}

	/**
	 * @param 判决法院所在地区 the pjfyszdq to set
	 */
	public void setPjfyszdq(String pjfyszdq) {
		this.pjfyszdq = pjfyszdq;
	}

	/**
	 * @return the 判决法院
	 */
	public String getPjfy() {
		return pjfy;
	}

	/**
	 * @param 判决法院 the pjfy to set
	 */
	public void setPjfy(String pjfy) {
		this.pjfy = pjfy;
	}

	/**
	 * @return the 判决案号(年度)
	 */
	public String getPjahnd() {
		return pjahnd;
	}

	/**
	 * @param 判决案号(年度) the pjahnd to set
	 */
	public void setPjahnd(String pjahnd) {
		this.pjahnd = pjahnd;
	}

	/**
	 * @return the 判决案号(法院简称及字号)
	 */
	public String getPjahzh() {
		return pjahzh;
	}

	/**
	 * @param 判决案号(法院简称及字号) the pjahzh to set
	 */
	public void setPjahzh(String pjahzh) {
		this.pjahzh = pjahzh;
	}

	/**
	 * @return the 判决案号（序号）
	 */
	public String getPjahxh() {
		return pjahxh;
	}

	/**
	 * @param 判决案号（序号） the pjahxh to set
	 */
	public void setPjahxh(String pjahxh) {
		this.pjahxh = pjahxh;
	}

	/**
	 * @return the 判决日期
	 */
	public Date getPjrq() {
		return pjrq;
	}

	/**
	 * @param 判决日期 the pjrq to set
	 */
	public void setPjrq(Date pjrq) {
		this.pjrq = pjrq;
	}

	/**
	 * @return the 判决罪名名称s（存放主罪名，从罪名。使用“”分割）
	 */
	public String getPjzmStr() {
		return pjzmStr;
	}

	/**
	 * @param 判决罪名名称s（存放主罪名，从罪名。使用“”分割） the pjzmStr to set
	 */
	public void setPjzmStr(String pjzmStr) {
		this.pjzmStr = pjzmStr;
	}

	/**
	 * @return the 判决罪名ids(格式：主罪名id从罪名id)
	 */
	public String getPjzm() {
		return pjzm;
	}

	/**
	 * @param 判决罪名ids(格式：主罪名id从罪名id) the pjzm to set
	 */
	public void setPjzm(String pjzm) {
		this.pjzm = pjzm;
	}

	/**
	 * @return the 刑种
	 */
	public String getXz() {
		return xz;
	}

	/**
	 * @param 刑种 the xz to set
	 */
	public void setXz(String xz) {
		this.xz = xz;
	}

	/**
	 * @return the 刑期
	 */
	public String getXq() {
		return xq;
	}

	/**
	 * @param 刑期 the xq to set
	 */
	public void setXq(String xq) {
		this.xq = xq;
	}

	/**
	 * @return the 刑期起日
	 */
	public Date getXqqr() {
		return xqqr;
	}

	/**
	 * @param 刑期起日 the xqqr to set
	 */
	public void setXqqr(Date xqqr) {
		this.xqqr = xqqr;
	}

	/**
	 * @return the 刑期止日
	 */
	public Date getXqzr() {
		return xqzr;
	}

	/**
	 * @param 刑期止日 the xqzr to set
	 */
	public void setXqzr(Date xqzr) {
		this.xqzr = xqzr;
	}

	/**
	 * @return the 附加刑，指刑法规定，补充主刑
	 */
	public String getBdzzqlqx() {
		return bdzzqlqx;
	}

	/**
	 * @param 附加刑，指刑法规定，补充主刑 the bdzzqlqx to set
	 */
	public void setBdzzqlqx(String bdzzqlqx) {
		this.bdzzqlqx = bdzzqlqx;
	}

	/**
	 * @return the 罚金金额
	 */
	public BigDecimal getFjje() {
		return fjje;
	}

	/**
	 * @param 罚金金额 the fjje to set
	 */
	public void setFjje(BigDecimal fjje) {
		this.fjje = fjje;
	}

	/**
	 * @return the 是否驱逐出境
	 */
	public Integer getQzcj() {
		return qzcj;
	}

	/**
	 * @param 是否驱逐出境 the qzcj to set
	 */
	public void setQzcj(Integer qzcj) {
		this.qzcj = qzcj;
	}

	/**
	 * @return the 没收财产情况
	 */
	public String getMsccqk() {
		return msccqk;
	}

	/**
	 * @param 没收财产情况 the msccqk to set
	 */
	public void setMsccqk(String msccqk) {
		this.msccqk = msccqk;
	}

	/**
	 * @return the 附带民事判决
	 */
	public String getFdmspj() {
		return fdmspj;
	}

	/**
	 * @param 附带民事判决 the fdmspj to set
	 */
	public void setFdmspj(String fdmspj) {
		this.fdmspj = fdmspj;
	}

	/**
	 * @return the 民事赔偿金额
	 */
	public BigDecimal getMspcje() {
		return mspcje;
	}

	/**
	 * @param 民事赔偿金额 the mspcje to set
	 */
	public void setMspcje(BigDecimal mspcje) {
		this.mspcje = mspcje;
	}

	/**
	 * @return the 是否减刑限制
	 */
	public Integer getJxxz() {
		return jxxz;
	}

	/**
	 * @param 是否减刑限制 the jxxz to set
	 */
	public void setJxxz(Integer jxxz) {
		this.jxxz = jxxz;
	}

	/**
	 * @return the 是否允许假释
	 */
	public Integer getYxjs() {
		return yxjs;
	}

	/**
	 * @param 是否允许假释 the yxjs to set
	 */
	public void setYxjs(Integer yxjs) {
		this.yxjs = yxjs;
	}

	/**
	 * @return the 案犯类别
	 */
	public String getAflb() {
		return aflb;
	}

	/**
	 * @param 案犯类别 the aflb to set
	 */
	public void setAflb(String aflb) {
		this.aflb = aflb;
	}

	/**
	 * @return the 执行通知书下达日期
	 */
	public Date getZxtzsxdrq() {
		return zxtzsxdrq;
	}

	/**
	 * @param 执行通知书下达日期 the zxtzsxdrq to set
	 */
	public void setZxtzsxdrq(Date zxtzsxdrq) {
		this.zxtzsxdrq = zxtzsxdrq;
	}

	/**
	 * @return the 是否认罪服法
	 */
	public Integer getRzff() {
		return rzff;
	}

	/**
	 * @param 是否认罪服法 the rzff to set
	 */
	public void setRzff(Integer rzff) {
		this.rzff = rzff;
	}

	/**
	 * @return the 判决结果
	 */
	public String getPjjg() {
		return pjjg;
	}

	/**
	 * @param 判决结果 the pjjg to set
	 */
	public void setPjjg(String pjjg) {
		this.pjjg = pjjg;
	}

	/**
	 * @return the 判决情况
	 */
	public String getPjqk() {
		return pjqk;
	}

	/**
	 * @param 判决情况 the pjqk to set
	 */
	public void setPjqk(String pjqk) {
		this.pjqk = pjqk;
	}

	/**
	 * @return the 判决缓刑年
	 */
	public Integer getPjhxn() {
		return pjhxn;
	}

	/**
	 * @param 判决缓刑年 the pjhxn to set
	 */
	public void setPjhxn(Integer pjhxn) {
		this.pjhxn = pjhxn;
	}

	/**
	 * @return the 判决缓刑月
	 */
	public Integer getPjhxy() {
		return pjhxy;
	}

	/**
	 * @param 判决缓刑月 the pjhxy to set
	 */
	public void setPjhxy(Integer pjhxy) {
		this.pjhxy = pjhxy;
	}

	/**
	 * @return the 判决缓刑日
	 */
	public Integer getPjhxr() {
		return pjhxr;
	}

	/**
	 * @param 判决缓刑日 the pjhxr to set
	 */
	public void setPjhxr(Integer pjhxr) {
		this.pjhxr = pjhxr;
	}

	/**
	 * @return the 罪犯基本信息
	 */
	public String getZfid() {
		return zfid;
	}

	/**
	 * @param 罪犯基本信息 the zfid to set
	 */
	public void setZfid(String zfid) {
		this.zfid = zfid;
	}

	/**
	 * @return the 备注
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * @param 备注 the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * @return the 创建时间
	 */
	public Long getCreateDate() {
		return createDate;
	}

	/**
	 * @param 创建时间 the createDate to set
	 */
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

}
