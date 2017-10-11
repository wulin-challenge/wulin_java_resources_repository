package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 行政类别
 * @author:吴波
 */
@Entity
@Table(name="t_xzlb")
public class Xzlb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3378806484873445012L;

	/**
	 * 行政类别：奖励
	 */
	public static final String XZLB_JL = "1";
	
	/**
	 * 行政类别：处罚
	 */
	public static final String XZLB_CF = "2";
	/**
	 * 行政类别：类别三
	 */
	public static final String XZLB_3 = "3";
	/**
	 * 表扬代码
	 */
	public static final String CODE_BY = "4";
	/**
	 * 奖励代码
	 */
	public static final String CODE_JL = "5";
	
	
	
	/**
	 * 表扬代码
	 */
	public static final String CODE_BIAOYANG = "1";
	/**
	 * 记功代码
	 */
	public static final String CODE_JIGONG = "2";
	/**
	 * 物质奖励代码
	 */
	public static final String CODE_WUZHIJIANGLI = "3";
	/**
	 * 警告代码
	 */
	public static final String CODE_JINGGAO = "11";
	/**
	 * 记过代码
	 */
	public static final String CODE_JIGUO = "12";
	/**
	 * 禁闭代码
	 */
	public static final String CODE_JINBI = "13";
	
	/**
	 * 严管代码
	 */
	public static final String CODE_YANGUAN = "14";
	
	@Id
	private String id;
	
	/**
	 * 行政类别：奖励、处罚
	 */
	@Column(length = 100)
	private String xzlb;
	
	/**
	 * 行政名称
	 */
	@Column(length = 100)
	private String xzmc;
	
	/**
	 * 代码标识
	 */
	@Column(length = 100)
	private String code;
	
	/**
	 * 分数
	 */
	@Column(length = 100)
	private String fs;
	
	/**
	 * 序号
	 */
	private Integer xh;
	
	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;
	
	/**
	 * 是否可编辑
	 */
	private Boolean isEdit;
	
	private Long createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXzlb() {
		return xzlb;
	}

	public void setXzlb(String xzlb) {
		this.xzlb = xzlb;
	}

	public String getXzmc() {
		return xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

}
