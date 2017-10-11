package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Description: 处遇等级评定筛选条件
 * @author: 吴波
 */
@Entity
@Table(name = "t_cydjpdsxtj")
public class Cydjpdsxtj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4546617082045844985L;

	@Id
	private String id;
	
	/**
	 * 代码：教育期满
	 */
	public static final String CODE_JYQM = "1";

	/**
	 * 名称
	 */
	private String mc;

	/**
	 * 目标等级
	 * 关联实体:Cydj
	 */
	@Column(name="mbdj")
	private String mbdj;
	
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

	public String getMbdj() {
		return mbdj;
	}

	public void setMbdj(String mbdj) {
		this.mbdj = mbdj;
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

}
