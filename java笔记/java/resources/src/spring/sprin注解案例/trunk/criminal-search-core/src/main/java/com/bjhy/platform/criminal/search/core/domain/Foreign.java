package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 罪犯外籍信息
 * @author wangbowen
 * @date 2015年12月08日
 *
 */
@Entity
@Table(name = "bs_wjxx")
public class Foreign implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075130204310011140L;

	@Id
	@Column(name="wjxxid")
	private String id;
	
	/**
	 * 入境方式
	 */
	@Column(length = 1000)
	private String rjfs; 
	
	/**
	 * 是否华裔
	 */
	private Integer sfhy; 
	
	/**
	 * 国籍
	 */
	@Column(length = 100)
	private String gj; 
	
	/**
	 * 语种
	 */
	@Column(length = 1000)
	private String yz; 

	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz; 

	/**
	 * 罪犯基本信息
	 */
	@Column(length = 100)
	private String baseInfo;

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
	 * @return the 入境方式
	 */
	public String getRjfs() {
		return rjfs;
	}

	/**
	 * @param 入境方式 the rjfs to set
	 */
	public void setRjfs(String rjfs) {
		this.rjfs = rjfs;
	}

	/**
	 * @return the 是否华裔
	 */
	public Integer getSfhy() {
		return sfhy;
	}

	/**
	 * @param 是否华裔 the sfhy to set
	 */
	public void setSfhy(Integer sfhy) {
		this.sfhy = sfhy;
	}

	/**
	 * @return the 国籍
	 */
	public String getGj() {
		return gj;
	}

	/**
	 * @param 国籍 the gj to set
	 */
	public void setGj(String gj) {
		this.gj = gj;
	}

	/**
	 * @return the 语种
	 */
	public String getYz() {
		return yz;
	}

	/**
	 * @param 语种 the yz to set
	 */
	public void setYz(String yz) {
		this.yz = yz;
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
	public String getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param 罪犯基本信息 the baseInfo to set
	 */
	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
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
