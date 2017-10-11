package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 罪犯收押逮捕情况
 * @author 赵少泉
 * @date 2014年4月11日 上午9:59:30
 */
@Entity
@Table(name="bs_zfsyqk")
public class ArrestInfo implements Serializable{
	private static final long serialVersionUID = -4160885993667834557L;
	/**
	 * 收押逮捕情况ID
	 */
	@Id
	@Column(name="dbsyid")
	private String id;
	/**
	 * 犯罪事实
	 */
	@Column(length=8000)
	private String fzss;
	/**
	 * 犯罪日期
	 */
	private Date fzrq;
	/**
	 * 犯罪时是否未成年
	 */
	private Integer wcnfz;
	/**
	 * 羁押日期
	 */
	private Date jyrq;
	/**
	 * 逮捕机关（行政区划名称）
	 */
	@Column(length=2048)
	private String dbjgqh;
	/**
	 * 逮捕机关（机关称谓）
	 */
	@Column(length=2048)
	private String dbjgcw;
	/**
	 * 逮捕日期
	 */
	private Date dbrq;
	/**
	 * 起诉机关（行政区划名称）
	 */
	@Column(length=2048)
	private String qsjgqh;
	/**
	 * 起诉机关（机关称谓）
	 */
	@Column(length=2048)
	private String qsjgcw;
	/**
	 * 起诉案号（年度）
	 */
	@Column(length=2048)
	private String qsnd;
	/**
	 * 起诉案号（检察院简称及字号）
	 */
	@Column(length=2048)
	private String qszh;
	/**
	 * 起案号（序号）
	 */
	@Column(length=2048)
	private String qsxh;
	/**
	 * 入监日期
	 */
	private Date rjrq;
	/**
	 * 捕前职业
	 */
	@Column(length=100)
	private String bqzy;
	/**
	 * 捕前职业分类
	 */
	@Column(length=100)
	private String bqzyfl;
	/**
	 * 捕前职级
	 */
	@Column(length=100)
	private String bqzj;
	/**
	 * 捕前职称
	 */
	@Column(length=100)
	private String bqzc;
	/**
	 * 捕前所学专业
	 */
	@Column(length=100)
	private String bqsxzy;
	/**
	 * 捕前身份
	 */
	@Column(length=100)
	private String bqsf;
	/**
	 * 送押机关所属省
	 */
	@Column(length=100)
	private String syjqsss;
	/**
	 * 送押机关
	 */
	@Column(length=100)
	private String syjg;
	/**
	 * 收押类别
	 */
	@Column(length=100)
	private String sylb;
	/**
	 * 收押日期
	 */
	private Date syrq;
	/**
	 * 备注
	 */
	@Column(length=2048)
	private String bz;
	/**
	 * 罪犯基本信息
	 */
	@Column(length=100)
	private String zfid;
	/**
	 * 创建时间
	 */
	private Long createDate;
	/**
	 * @return the 收押逮捕情况ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param 收押逮捕情况ID the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the 犯罪事实
	 */
	public String getFzss() {
		return fzss;
	}
	/**
	 * @param 犯罪事实 the fzss to set
	 */
	public void setFzss(String fzss) {
		this.fzss = fzss;
	}
	/**
	 * @return the 犯罪日期
	 */
	public Date getFzrq() {
		return fzrq;
	}
	/**
	 * @param 犯罪日期 the fzrq to set
	 */
	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
	}
	/**
	 * @return the 犯罪时是否未成年
	 */
	public Integer getWcnfz() {
		return wcnfz;
	}
	/**
	 * @param 犯罪时是否未成年 the wcnfz to set
	 */
	public void setWcnfz(Integer wcnfz) {
		this.wcnfz = wcnfz;
	}
	/**
	 * @return the 羁押日期
	 */
	public Date getJyrq() {
		return jyrq;
	}
	/**
	 * @param 羁押日期 the jyrq to set
	 */
	public void setJyrq(Date jyrq) {
		this.jyrq = jyrq;
	}
	/**
	 * @return the 逮捕机关（行政区划名称）
	 */
	public String getDbjgqh() {
		return dbjgqh;
	}
	/**
	 * @param 逮捕机关（行政区划名称） the dbjgqh to set
	 */
	public void setDbjgqh(String dbjgqh) {
		this.dbjgqh = dbjgqh;
	}
	/**
	 * @return the 逮捕机关（机关称谓）
	 */
	public String getDbjgcw() {
		return dbjgcw;
	}
	/**
	 * @param 逮捕机关（机关称谓） the dbjgcw to set
	 */
	public void setDbjgcw(String dbjgcw) {
		this.dbjgcw = dbjgcw;
	}
	/**
	 * @return the 逮捕日期
	 */
	public Date getDbrq() {
		return dbrq;
	}
	/**
	 * @param 逮捕日期 the dbrq to set
	 */
	public void setDbrq(Date dbrq) {
		this.dbrq = dbrq;
	}
	/**
	 * @return the 起诉机关（行政区划名称）
	 */
	public String getQsjgqh() {
		return qsjgqh;
	}
	/**
	 * @param 起诉机关（行政区划名称） the qsjgqh to set
	 */
	public void setQsjgqh(String qsjgqh) {
		this.qsjgqh = qsjgqh;
	}
	/**
	 * @return the 起诉机关（机关称谓）
	 */
	public String getQsjgcw() {
		return qsjgcw;
	}
	/**
	 * @param 起诉机关（机关称谓） the qsjgcw to set
	 */
	public void setQsjgcw(String qsjgcw) {
		this.qsjgcw = qsjgcw;
	}
	/**
	 * @return the 起诉案号（年度）
	 */
	public String getQsnd() {
		return qsnd;
	}
	/**
	 * @param 起诉案号（年度） the qsnd to set
	 */
	public void setQsnd(String qsnd) {
		this.qsnd = qsnd;
	}
	/**
	 * @return the 起诉案号（检察院简称及字号）
	 */
	public String getQszh() {
		return qszh;
	}
	/**
	 * @param 起诉案号（检察院简称及字号） the qszh to set
	 */
	public void setQszh(String qszh) {
		this.qszh = qszh;
	}
	/**
	 * @return the 起案号（序号）
	 */
	public String getQsxh() {
		return qsxh;
	}
	/**
	 * @param 起案号（序号） the qsxh to set
	 */
	public void setQsxh(String qsxh) {
		this.qsxh = qsxh;
	}
	/**
	 * @return the 入监日期
	 */
	public Date getRjrq() {
		return rjrq;
	}
	/**
	 * @param 入监日期 the rjrq to set
	 */
	public void setRjrq(Date rjrq) {
		this.rjrq = rjrq;
	}
	/**
	 * @return the 捕前职业
	 */
	public String getBqzy() {
		return bqzy;
	}
	/**
	 * @param 捕前职业 the bqzy to set
	 */
	public void setBqzy(String bqzy) {
		this.bqzy = bqzy;
	}
	/**
	 * @return the 捕前职业分类
	 */
	public String getBqzyfl() {
		return bqzyfl;
	}
	/**
	 * @param 捕前职业分类 the bqzyfl to set
	 */
	public void setBqzyfl(String bqzyfl) {
		this.bqzyfl = bqzyfl;
	}
	/**
	 * @return the 捕前职级
	 */
	public String getBqzj() {
		return bqzj;
	}
	/**
	 * @param 捕前职级 the bqzj to set
	 */
	public void setBqzj(String bqzj) {
		this.bqzj = bqzj;
	}
	/**
	 * @return the 捕前职称
	 */
	public String getBqzc() {
		return bqzc;
	}
	/**
	 * @param 捕前职称 the bqzc to set
	 */
	public void setBqzc(String bqzc) {
		this.bqzc = bqzc;
	}
	/**
	 * @return the 捕前所学专业
	 */
	public String getBqsxzy() {
		return bqsxzy;
	}
	/**
	 * @param 捕前所学专业 the bqsxzy to set
	 */
	public void setBqsxzy(String bqsxzy) {
		this.bqsxzy = bqsxzy;
	}
	/**
	 * @return the 捕前身份
	 */
	public String getBqsf() {
		return bqsf;
	}
	/**
	 * @param 捕前身份 the bqsf to set
	 */
	public void setBqsf(String bqsf) {
		this.bqsf = bqsf;
	}
	/**
	 * @return the 送押机关所属省
	 */
	public String getSyjqsss() {
		return syjqsss;
	}
	/**
	 * @param 送押机关所属省 the syjqsss to set
	 */
	public void setSyjqsss(String syjqsss) {
		this.syjqsss = syjqsss;
	}
	/**
	 * @return the 送押机关
	 */
	public String getSyjg() {
		return syjg;
	}
	/**
	 * @param 送押机关 the syjg to set
	 */
	public void setSyjg(String syjg) {
		this.syjg = syjg;
	}
	/**
	 * @return the 收押类别
	 */
	public String getSylb() {
		return sylb;
	}
	/**
	 * @param 收押类别 the sylb to set
	 */
	public void setSylb(String sylb) {
		this.sylb = sylb;
	}
	/**
	 * @return the 收押日期
	 */
	public Date getSyrq() {
		return syrq;
	}
	/**
	 * @param 收押日期 the syrq to set
	 */
	public void setSyrq(Date syrq) {
		this.syrq = syrq;
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
