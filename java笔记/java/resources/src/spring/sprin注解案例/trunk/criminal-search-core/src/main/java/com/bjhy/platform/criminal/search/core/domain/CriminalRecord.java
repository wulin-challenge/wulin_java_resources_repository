package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 罪犯前科信息
 * @author: wangbowen
 * @time: 2015年12月08日 
 */
@Entity
@Table(name = "bs_zfqk")
public class CriminalRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6662067114443261258L;
	
	@Id
	private String id;
	
	/**
	 * 前科类别
	 */
	@Column(length = 100)
	private String qklb; 
	
	/**
	 * 起日
	 */
	private Date qr;
	
	/**
	 * 止日
	 */
	private Date zr;
	
	/**
	 * 罪名id
	 */
	@Column(length = 100)
	private String zm;
	
	/**
	 * 罪名
	 */
	@Column(length = 100)
	private String zmStr;
	
	/**
	 * 案由
	 */
	@Column(length=2048)
	private String ay;
	
	/**
	 * 判决日期
	 */
	private Date pjrq;
	
	/**
	 * 关押地点
	 */
	@Column(length = 1000)
	private String gydd;
	
	/**
	 * 备注
	 */
	@Column(length=2048)
	private String bz;

	/**
	 * 罪犯基本信息
	 */
	@Column(length = 100)
	private  String zfid;
	/**
	 * 创建信息
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
	 * @return the 前科类别
	 */
	public String getQklb() {
		return qklb;
	}
	/**
	 * @param 前科类别 the qklb to set
	 */
	public void setQklb(String qklb) {
		this.qklb = qklb;
	}
	/**
	 * @return the 起日
	 */
	public Date getQr() {
		return qr;
	}
	/**
	 * @param 起日 the qr to set
	 */
	public void setQr(Date qr) {
		this.qr = qr;
	}
	/**
	 * @return the 止日
	 */
	public Date getZr() {
		return zr;
	}
	/**
	 * @param 止日 the zr to set
	 */
	public void setZr(Date zr) {
		this.zr = zr;
	}
	/**
	 * @return the 罪名id
	 */
	public String getZm() {
		return zm;
	}
	/**
	 * @param 罪名id the zm to set
	 */
	public void setZm(String zm) {
		this.zm = zm;
	}
	/**
	 * @return the 罪名
	 */
	public String getZmStr() {
		return zmStr;
	}
	/**
	 * @param 罪名 the zmStr to set
	 */
	public void setZmStr(String zmStr) {
		this.zmStr = zmStr;
	}
	/**
	 * @return the 案由
	 */
	public String getAy() {
		return ay;
	}
	/**
	 * @param 案由 the ay to set
	 */
	public void setAy(String ay) {
		this.ay = ay;
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
	 * @return the 关押地点
	 */
	public String getGydd() {
		return gydd;
	}
	/**
	 * @param 关押地点 the gydd to set
	 */
	public void setGydd(String gydd) {
		this.gydd = gydd;
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
	 * @return the 创建信息
	 */
	public Long getCreateDate() {
		return createDate;
	}
	/**
	 * @param 创建信息 the createDate to set
	 */
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	
	
}
