package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 罪犯其他称呼信息
 * @author wangbowe
 * @date 2015年12月08日 
 *
 */
@Entity
@Table(name = "bs_bmxx")
public class NiName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5153898999650327910L;

	@Id
	@Column(name="bmid")
	private String id;

	/**
	 * 称呼类别
	 */
	
	private String chlb; 

	/**
	 * 序号
	 */
	@Column(length = 100)
	private Integer xh; 

	/**
	 * 称呼内容
	 */
	@Column(length = 100)
	private String chnr; 
	
	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;

	/**
	 * 罪犯基本信息
	 */
	private String zfid; 

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
	 * @return the 称呼类别
	 */
	public String getChlb() {
		return chlb;
	}

	/**
	 * @param 称呼类别 the chlb to set
	 */
	public void setChlb(String chlb) {
		this.chlb = chlb;
	}

	/**
	 * @return the 序号
	 */
	public Integer getXh() {
		return xh;
	}

	/**
	 * @param 序号 the xh to set
	 */
	public void setXh(Integer xh) {
		this.xh = xh;
	}

	/**
	 * @return the 称呼内容
	 */
	public String getChnr() {
		return chnr;
	}

	/**
	 * @param 称呼内容 the chnr to set
	 */
	public void setChnr(String chnr) {
		this.chnr = chnr;
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
