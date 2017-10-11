package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Description 罪犯证件信息
 * @author 赵少泉
 * @date 2014年4月15日 下午2:01:44
 */
@Entity
@Table(name = "bs_paperwork")
public class Paperwork implements Serializable{
	private static final long serialVersionUID = -6198525161942707314L;
	/**
	 * 罪犯证件ID
	 */
	@Id
	@Column(name="id")
	private String id;
	/**
	 * 证件类型
	 */
	@Column(length = 100)
	private String zjlx;
	/**
	 * 证件号码
	 */
	@Column(length = 100)
	private String zjhm;
	/**
	 * 证件有效期止日
	 */
	private Date zjzr;
	/**
	 * 罪犯基本信息
	 */
	@Column(length = 100)
	private String zfid;
	/**
	 * 创建时间
	 */
	private Long createDate;
	/**
	 * @return the 罪犯证件ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param 罪犯证件ID the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the 证件类型
	 */
	public String getZjlx() {
		return zjlx;
	}
	/**
	 * @param 证件类型 the zjlx to set
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	/**
	 * @return the 证件号码
	 */
	public String getZjhm() {
		return zjhm;
	}
	/**
	 * @param 证件号码 the zjhm to set
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	/**
	 * @return the 证件有效期止日
	 */
	public Date getZjzr() {
		return zjzr;
	}
	/**
	 * @param 证件有效期止日 the zjzr to set
	 */
	public void setZjzr(Date zjzr) {
		this.zjzr = zjzr;
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
