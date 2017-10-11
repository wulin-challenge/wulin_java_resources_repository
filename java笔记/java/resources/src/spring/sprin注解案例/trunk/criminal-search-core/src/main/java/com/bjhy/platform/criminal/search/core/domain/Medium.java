package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 罪犯媒体信息
 * @author wangbowen
 * @date 2015年12月08日 
 *
 */
@Entity
@Table(name = "bs_mtxx")
public class Medium implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6322526240955712599L;

	@Id
	@Column(name = "mtxxid")
	private String id;

	/**
	 * 媒体类别
	 */
	@Column(length = 100)
	private String mtlb; 

	/**
	 * 序号
	 */
	@Column(length = 100)
	private Integer xh; 

	/**
	 * 文件创建时间
	 */
	private Date cjsj; 

	/**
	 * 文件更新时间
	 */
	private Date gxsj; 

	/**
	 * 附件
	 */
	@Column(length = 500)
	private String fj; 

	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz; 

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
	 * @return the 媒体类别
	 */
	public String getMtlb() {
		return mtlb;
	}

	/**
	 * @param 媒体类别 the mtlb to set
	 */
	public void setMtlb(String mtlb) {
		this.mtlb = mtlb;
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
	 * @return the 文件创建时间
	 */
	public Date getCjsj() {
		return cjsj;
	}

	/**
	 * @param 文件创建时间 the cjsj to set
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	/**
	 * @return the 文件更新时间
	 */
	public Date getGxsj() {
		return gxsj;
	}

	/**
	 * @param 文件更新时间 the gxsj to set
	 */
	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}

	/**
	 * @return the 附件
	 */
	public String getFj() {
		return fj;
	}

	/**
	 * @param 附件 the fj to set
	 */
	public void setFj(String fj) {
		this.fj = fj;
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
