package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 罪犯体貌特征
 * @author chenshuai
 */
@Entity
@Table(name="bs_tmtz")
public class PhysicalCharacter implements Serializable{
	private static final long serialVersionUID = -301153049063224830L;
	
	public static final String DW_SG = "CM";
	public static final String DW_TZ = "KG";
	public static final String DW_ZC = "CM";
	
	/**
	 * 貌特征ID
	 */
	@Id
	@Column(name="tmtzid")
	private String id;
	/**
	 * 身高
	 */
	private Integer sg;
	/**
	 * 体型
	 */
	private String tx;
	/**
	 * 体重
	 */
	private Integer tz;
	/**
	 * 脸型
	 */
	private String lx;
	/**
	 * 足长
	 */
	private Integer zc;
	/**
	 * 口音
	 */
	private String ky;
	/**
	 * 血型
	 */
	private String xx;
	/**
	 * 其它特征
	 */
	@Column(length=2048)
	private String qttz;
	/**
	 * 罪犯基本信息
	 */
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
	public Integer getSg() {
		return sg;
	}
	public void setSg(Integer sg) {
		this.sg = sg;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public Integer getTz() {
		return tz;
	}
	public void setTz(Integer tz) {
		this.tz = tz;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public Integer getZc() {
		return zc;
	}
	public void setZc(Integer zc) {
		this.zc = zc;
	}
	public String getKy() {
		return ky;
	}
	public void setKy(String ky) {
		this.ky = ky;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	public String getQttz() {
		return qttz;
	}
	public void setQttz(String qttz) {
		this.qttz = qttz;
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
