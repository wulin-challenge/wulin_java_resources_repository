package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 处遇等级
 * @author: 吴波
 */
@Entity
@Table(name = "t_cydj")
public class Cydj implements Serializable{
	
	//	顺序从严到宽 12021
	/**
	 * 处遇等级代码：二级严管
	 */
	public static final String CODE_EJYG = "2";
	/**
	 * 处遇等级代码：一级严管
	 */
	public static final String CODE_YJYG = "1";
	/**
	 * 处遇等级代码：一般管理
	 */
	public static final String CODE_YBGL = "3";
	/**
	 * 处遇等级代码：一级宽管
	 */
	public static final String CODE_YJKG = "5";
	/**
	 * 处遇等级代码：二级宽管
	 */
	public static final String CODE_EJKG = "4";

	/**
	 * 
	 */
	private static final long serialVersionUID = 7338090865168701953L;

	@Id
	private String id;

	/**
	 * 名称（该名称可能根据各个监狱叫法不一致）
	 */
	@Column(length = 100)
	private String mc;

	/**
	 * 标准名称
	 */
	@Column(length = 100)
	private String bzmc;
	
	/**
	 * 代码
	 */
	@Column(length = 100)
	private String dm;

	/**
	 * 序号
	 */
	@Column(length = 100)
	private String xh;

	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

}
