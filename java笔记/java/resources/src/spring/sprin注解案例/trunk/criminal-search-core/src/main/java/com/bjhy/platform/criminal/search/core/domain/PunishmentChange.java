package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Description 罪犯刑罚变动信息
 * @author:吴波
 */
@Entity
@Table(name="t_punishment")
public class PunishmentChange implements Serializable{
	/**
	 * 已确认
	 */
	public static String SFQR_YES="已确认";
	/**
	 * 未确认
	 */
	public static String SFQR_NO="未确认";
	private static final long serialVersionUID = 6731144323828710674L;
	/**
	 * ID
	 */
	@Id
	private String id;
	/**
	 * 裁决字号
	 */
	private String cjzh;
	/**
	 * 裁决机关
	 */
	private String cjjg;
	/**
	 * 裁决日期
	 */
	@Temporal(TemporalType.DATE)
	private Date cjrq;
	/**
	 * 加减刑幅度（精确到月）
	 */
	private String jxfd;
	/**
	 * 刑期起日(加减刑后的)
	 */
	private Date xqks;
	/**
	 * 刑期止日（加减刑后的）
	 */
	private Date xqjs;
	/**
	 * 剥政年限
	 */
	private String bznx;
	/**
	 * 罚金金额
	 */
	private String fjje;
	/**
	 * 没收财产情况
	 */
	private String msccqk;
	/**
	 * 类型（加刑，减刑）
	 */
	private String lx;
	/**
	 * 备注
	 */
	private String bz;
	/**
	 * 改变后的刑种
	 */
	private String xz;
	/**
	 * 改变前的刑种
	 */
	private String yqxz;
	/**
	 * 改变前的刑期
	 */
	private String yqxq;
	/**
	 * 改变前的刑期止日
	 */
	private Date yqxqzr;
	/**
	 * 是否确认
	 */
	private String sfqr;
	/**
	 * 余刑
	 */
	private String yx;
	/**
	 * X刑执字第
	 */
	private String cx;
	/**
	 * 登记日期
	 */
	private Date djrq;
	/**
	 * 假释起日
	 */
	private Date jsqr;
	/**
	 * 假释止日
	 */
	private Date jszr;
	/**
	 * 登记警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name = "djjg")
	private String djjg; 
	/**
	 * 罪犯当前信息
	 * 关联实体 : CurrentInfo
	 */
	@Column(name = "dqxxid")
	private String currentInfo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCjzh() {
		return cjzh;
	}
	public void setCjzh(String cjzh) {
		this.cjzh = cjzh;
	}
	public String getCjjg() {
		return cjjg;
	}
	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}
	public Date getCjrq() {
		return cjrq;
	}
	public void setCjrq(Date cjrq) {
		this.cjrq = cjrq;
	}
	public String getJxfd() {
		return jxfd;
	}
	public void setJxfd(String jxfd) {
		this.jxfd = jxfd;
	}
	public Date getXqks() {
		return xqks;
	}
	public void setXqks(Date xqks) {
		this.xqks = xqks;
	}
	public Date getXqjs() {
		return xqjs;
	}
	public void setXqjs(Date xqjs) {
		this.xqjs = xqjs;
	}
	public String getBznx() {
		return bznx;
	}
	public void setBznx(String bznx) {
		this.bznx = bznx;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXz() {
		return xz;
	}
	public void setXz(String xz) {
		this.xz = xz;
	}
	public String getYqxz() {
		return yqxz;
	}
	public void setYqxz(String yqxz) {
		this.yqxz = yqxz;
	}
	public String getYqxq() {
		return yqxq;
	}
	public void setYqxq(String yqxq) {
		this.yqxq = yqxq;
	}
	public Date getYqxqzr() {
		return yqxqzr;
	}
	public void setYqxqzr(Date yqxqzr) {
		this.yqxqzr = yqxqzr;
	}
	public Date getDjrq() {
		return djrq;
	}
	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}
	public String getDjjg() {
		return djjg;
	}
	public void setDjjg(String djjg) {
		this.djjg = djjg;
	}
	public String getCurrentInfo() {
		return currentInfo;
	}
	public void setCurrentInfo(String currentInfo) {
		this.currentInfo = currentInfo;
	}
	public String getFjje() {
		return fjje;
	}
	public void setFjje(String fjje) {
		this.fjje = fjje;
	}
	public String getMsccqk() {
		return msccqk;
	}
	public void setMsccqk(String msccqk) {
		this.msccqk = msccqk;
	}
	public String getSfqr() {
		return sfqr;
	}
	public void setSfqr(String sfqr) {
		this.sfqr = sfqr;
	}
	public Date getJsqr() {
		return jsqr;
	}
	public void setJsqr(Date jsqr) {
		this.jsqr = jsqr;
	}
	public Date getJszr() {
		return jszr;
	}
	public void setJszr(Date jszr) {
		this.jszr = jszr;
	}
	public String getYx() {
		return yx;
	}
	public void setYx(String yx) {
		this.yx = yx;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	
}
