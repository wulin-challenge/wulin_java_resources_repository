package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 罪犯简历信息
 * @author wangbowen
 * @date 2015年12月08日 
 */
@Entity
@Table(name = "bs_zfjl")
public class Resume implements Serializable{
	private static final long serialVersionUID = -617125567463311136L;
	/**
	 * 罪犯简历ID
	 */
	@Id
	@Column(name="jlid")
	private String id;
	/**
	 * 起日
	 */
	private Date qr;
	/**
	 * 止日
	 */
	private Date zr;
	/**
	 * 单位地址
	 */
	@Column(length=2048)
	private String dwdz;
	/**
	 * 本人住址
	 */
	@Column(length=2048)
	private String brzz;
	/**
	 * 职业
	 */
	@Column(length=2048)
	private String zy;
	/**
	 * 职务
	 */
	@Column(length=2048)
	private String zw;
	/**
	 * 职称
	 */
	@Column(length=2048)
	private String zc;
	/**
	 * 捕前单位标识
	 */
	@Column(length=2048)
	private String bqbz;
	/**
	 * 罪犯基本信息
	 */
	@Column(length=1000)
	private String zfid;
	/**
	 * 创建时间
	 */
	private Long createDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getQr() {
		return qr;
	}
	public void setQr(Date qr) {
		this.qr = qr;
	}
	public Date getZr() {
		return zr;
	}
	public void setZr(Date zr) {
		this.zr = zr;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getBrzz() {
		return brzz;
	}
	public void setBrzz(String brzz) {
		this.brzz = brzz;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getBqbz() {
		return bqbz;
	}
	public void setBqbz(String bqbz) {
		this.bqbz = bqbz;
	}
	
	public String getZfid() {
		return zfid;
	}
	public void setZfid(String zfid) {
		this.zfid = zfid;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	
}
