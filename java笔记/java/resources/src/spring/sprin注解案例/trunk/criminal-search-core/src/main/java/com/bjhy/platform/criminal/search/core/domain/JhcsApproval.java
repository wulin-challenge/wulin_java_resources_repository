package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 罪犯解回重审管理
 * @author wangbowen
 * @date 2014年5月9日 上午11:51:35
 */
@Entity
@Table(name="t_jhcs_approval")
public class JhcsApproval implements Serializable{
	private static final long serialVersionUID = 6624825876794939297L;
	/**
	 * 主键ID
	 */
	@Id
	@Column(name="id",length=32)
	private String id;
	/**
	 * 批准机关
	 */
	@Column(length=50)
	private String pzjg;
	/**
	 * 批准日期
	 */
	private Date pzrq;
	/**
	 * 提解日期
	 */
	private Date tjrq;
	/**
	 * 解回再审期限
	 */
	@Column(length=50)
	private String jhzsqx;
	/**
	 * 解回再审期限起日
	 */
	private Date jhzsqxqr;
	/**
	 * 解回再审期限止日
	 */
	private Date jhzsqxzr;
	/**
	 * 解回再审原因
	 */
	@Column(length=500)
	private String jhzsyy;
	/**
	 * 提解机关(省)
	 */
	@Column(length=50)
	private String tjjgsheng;
	/**
	 * 提解机关(市)
	 */
	@Column(length=50)
	private String tjjgshi;
	/**
	 * 提解机关(县)
	 */
	@Column(length=50)
	private String tjjgxian;
	/**
	 * 提解机关（机关称谓）
	 */
	@Column(length=50)
	private String tjjgcw;
	/**
	 * 公函字号
	 */
	@Column(length=30)
	private String ghzh;
	/**
	 * 提解人姓名
	 */
	@Column(length=30)
	private String tjrxm;
	/**
	 * 提解人证件类型
	 */
	@Column(length=30)
	private String tjrzjlx;
	/**
	 * 提解人证件号码
	 */
	@Column(length=50)
	private String tjrzjhm;
	/**
	 * 提解人联系电话
	 */
	@Column(length=50)
	private String tjrtel;
	/**
	 * 监狱经办民警
	 */
	@Column(length=30)
	private String jyjbmj;
	/**
	 * 罪犯提解时所在监狱代码
	 */
	@Column(length=30)
	private String tjszjydm;
	/**
	 * 罪犯提解时所在监狱名称
	 */
	@Column(length=30)
	private String tjszjymc;
	/**
	 * 终止类别
	 */
	@Column(length=30)
	private String zzlb;
	/**
	 * 终止日期
	 */
	private Date zzrq;
	/**
	 * 送回公函字号
	 */
	@Column(length=30)
	private String shghzh;
	/**
	 * 送押机关（省）
	 */
	@Column(length=50)
	private String syjgsheng;
	/**
	 * 送押机关（市）
	 */
	@Column(length=50)
	private String syjgshi;
	/**
	 * 送押机关（县）
	 */
	@Column(length=50)
	private String syjgxian;
	/**
	 * 送押机关(机关称谓)
	 */
	@Column(length=50)
	private String syjgcw;
	/**
	 * 送押人姓名
	 */
	@Column(length=50)
	private String syrxm;
	/**
	 * 送押人证件类型
	 */
	@Column(length=50)
	private String syrzjlx;
	/**
	 * 送押人证件号码
	 */
	@Column(length=50)
	private String syrzjhm;
	/**
	 * 送押人联系电话
	 */
	@Column(length=50)
	private String syrtel;
	/**
	 * 解回再审结果
	 */
	@Column(length=1000)
	private String jhzsjg;
	/**
	 * 备注
	 */
	@Column(length=2048)
	private String bz;
	/**
	 * 创建时间
	 */
	private Long createDate;
	/**
	 * 创建警官
	 */
	@Column(length=50)
	private String cjjg;
	/**
	 * 罪犯当前信息
	 */
	@Column(name="ccid",length =50)
	private String cdqxx;
	/**
	 * 审批状态
	 */
	private String spzt;
	/**
	 * 流程实例标识，true：回退；false：没回退
	 */
	@Column(name="process_mark")
	private Boolean processMark;
	/**
	 * 流程实例id
	 */
	@Column(name="process_id",length=32)
	private String processId;
	/**
	 * @return the 主键ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param 主键ID the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the 批准机关
	 */
	public String getPzjg() {
		return pzjg;
	}
	/**
	 * @param 批准机关 the pzjg to set
	 */
	public void setPzjg(String pzjg) {
		this.pzjg = pzjg;
	}
	/**
	 * @return the 批准日期
	 */
	public Date getPzrq() {
		return pzrq;
	}
	/**
	 * @param 批准日期 the pzrq to set
	 */
	public void setPzrq(Date pzrq) {
		this.pzrq = pzrq;
	}
	/**
	 * @return the 提解日期
	 */
	public Date getTjrq() {
		return tjrq;
	}
	/**
	 * @param 提解日期 the tjrq to set
	 */
	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}
	/**
	 * @return the 解回再审期限
	 */
	public String getJhzsqx() {
		return jhzsqx;
	}
	/**
	 * @param 解回再审期限 the jhzsqx to set
	 */
	public void setJhzsqx(String jhzsqx) {
		this.jhzsqx = jhzsqx;
	}
	/**
	 * @return the 解回再审期限起日
	 */
	public Date getJhzsqxqr() {
		return jhzsqxqr;
	}
	/**
	 * @param 解回再审期限起日 the jhzsqxqr to set
	 */
	public void setJhzsqxqr(Date jhzsqxqr) {
		this.jhzsqxqr = jhzsqxqr;
	}
	/**
	 * @return the 解回再审期限止日
	 */
	public Date getJhzsqxzr() {
		return jhzsqxzr;
	}
	/**
	 * @param 解回再审期限止日 the jhzsqxzr to set
	 */
	public void setJhzsqxzr(Date jhzsqxzr) {
		this.jhzsqxzr = jhzsqxzr;
	}
	/**
	 * @return the 解回再审原因
	 */
	public String getJhzsyy() {
		return jhzsyy;
	}
	/**
	 * @param 解回再审原因 the jhzsyy to set
	 */
	public void setJhzsyy(String jhzsyy) {
		this.jhzsyy = jhzsyy;
	}
	/**
	 * @return the 提解机关(省)
	 */
	public String getTjjgsheng() {
		return tjjgsheng;
	}
	/**
	 * @param 提解机关(省) the tjjgsheng to set
	 */
	public void setTjjgsheng(String tjjgsheng) {
		this.tjjgsheng = tjjgsheng;
	}
	/**
	 * @return the 提解机关(市)
	 */
	public String getTjjgshi() {
		return tjjgshi;
	}
	/**
	 * @param 提解机关(市) the tjjgshi to set
	 */
	public void setTjjgshi(String tjjgshi) {
		this.tjjgshi = tjjgshi;
	}
	/**
	 * @return the 提解机关(县)
	 */
	public String getTjjgxian() {
		return tjjgxian;
	}
	/**
	 * @param 提解机关(县) the tjjgxian to set
	 */
	public void setTjjgxian(String tjjgxian) {
		this.tjjgxian = tjjgxian;
	}
	/**
	 * @return the 提解机关（机关称谓）
	 */
	public String getTjjgcw() {
		return tjjgcw;
	}
	/**
	 * @param 提解机关（机关称谓） the tjjgcw to set
	 */
	public void setTjjgcw(String tjjgcw) {
		this.tjjgcw = tjjgcw;
	}
	/**
	 * @return the 公函字号
	 */
	public String getGhzh() {
		return ghzh;
	}
	/**
	 * @param 公函字号 the ghzh to set
	 */
	public void setGhzh(String ghzh) {
		this.ghzh = ghzh;
	}
	/**
	 * @return the 提解人姓名
	 */
	public String getTjrxm() {
		return tjrxm;
	}
	/**
	 * @param 提解人姓名 the tjrxm to set
	 */
	public void setTjrxm(String tjrxm) {
		this.tjrxm = tjrxm;
	}
	/**
	 * @return the 提解人证件类型
	 */
	public String getTjrzjlx() {
		return tjrzjlx;
	}
	/**
	 * @param 提解人证件类型 the tjrzjlx to set
	 */
	public void setTjrzjlx(String tjrzjlx) {
		this.tjrzjlx = tjrzjlx;
	}
	/**
	 * @return the 提解人证件号码
	 */
	public String getTjrzjhm() {
		return tjrzjhm;
	}
	/**
	 * @param 提解人证件号码 the tjrzjhm to set
	 */
	public void setTjrzjhm(String tjrzjhm) {
		this.tjrzjhm = tjrzjhm;
	}
	/**
	 * @return the 提解人联系电话
	 */
	public String getTjrtel() {
		return tjrtel;
	}
	/**
	 * @param 提解人联系电话 the tjrtel to set
	 */
	public void setTjrtel(String tjrtel) {
		this.tjrtel = tjrtel;
	}
	/**
	 * @return the 监狱经办民警
	 */
	public String getJyjbmj() {
		return jyjbmj;
	}
	/**
	 * @param 监狱经办民警 the jyjbmj to set
	 */
	public void setJyjbmj(String jyjbmj) {
		this.jyjbmj = jyjbmj;
	}
	/**
	 * @return the 罪犯提解时所在监狱代码
	 */
	public String getTjszjydm() {
		return tjszjydm;
	}
	/**
	 * @param 罪犯提解时所在监狱代码 the tjszjydm to set
	 */
	public void setTjszjydm(String tjszjydm) {
		this.tjszjydm = tjszjydm;
	}
	/**
	 * @return the 罪犯提解时所在监狱名称
	 */
	public String getTjszjymc() {
		return tjszjymc;
	}
	/**
	 * @param 罪犯提解时所在监狱名称 the tjszjymc to set
	 */
	public void setTjszjymc(String tjszjymc) {
		this.tjszjymc = tjszjymc;
	}
	/**
	 * @return the 终止类别
	 */
	public String getZzlb() {
		return zzlb;
	}
	/**
	 * @param 终止类别 the zzlb to set
	 */
	public void setZzlb(String zzlb) {
		this.zzlb = zzlb;
	}
	/**
	 * @return the 终止日期
	 */
	public Date getZzrq() {
		return zzrq;
	}
	/**
	 * @param 终止日期 the zzrq to set
	 */
	public void setZzrq(Date zzrq) {
		this.zzrq = zzrq;
	}
	/**
	 * @return the 送回公函字号
	 */
	public String getShghzh() {
		return shghzh;
	}
	/**
	 * @param 送回公函字号 the shghzh to set
	 */
	public void setShghzh(String shghzh) {
		this.shghzh = shghzh;
	}
	/**
	 * @return the 送押机关（省）
	 */
	public String getSyjgsheng() {
		return syjgsheng;
	}
	/**
	 * @param 送押机关（省） the syjgsheng to set
	 */
	public void setSyjgsheng(String syjgsheng) {
		this.syjgsheng = syjgsheng;
	}
	/**
	 * @return the 送押机关（市）
	 */
	public String getSyjgshi() {
		return syjgshi;
	}
	/**
	 * @param 送押机关（市） the syjgshi to set
	 */
	public void setSyjgshi(String syjgshi) {
		this.syjgshi = syjgshi;
	}
	/**
	 * @return the 送押机关（县）
	 */
	public String getSyjgxian() {
		return syjgxian;
	}
	/**
	 * @param 送押机关（县） the syjgxian to set
	 */
	public void setSyjgxian(String syjgxian) {
		this.syjgxian = syjgxian;
	}
	/**
	 * @return the 送押机关(机关称谓)
	 */
	public String getSyjgcw() {
		return syjgcw;
	}
	/**
	 * @param 送押机关(机关称谓) the syjgcw to set
	 */
	public void setSyjgcw(String syjgcw) {
		this.syjgcw = syjgcw;
	}
	/**
	 * @return the 送押人姓名
	 */
	public String getSyrxm() {
		return syrxm;
	}
	/**
	 * @param 送押人姓名 the syrxm to set
	 */
	public void setSyrxm(String syrxm) {
		this.syrxm = syrxm;
	}
	/**
	 * @return the 送押人证件类型
	 */
	public String getSyrzjlx() {
		return syrzjlx;
	}
	/**
	 * @param 送押人证件类型 the syrzjlx to set
	 */
	public void setSyrzjlx(String syrzjlx) {
		this.syrzjlx = syrzjlx;
	}
	/**
	 * @return the 送押人证件号码
	 */
	public String getSyrzjhm() {
		return syrzjhm;
	}
	/**
	 * @param 送押人证件号码 the syrzjhm to set
	 */
	public void setSyrzjhm(String syrzjhm) {
		this.syrzjhm = syrzjhm;
	}
	/**
	 * @return the 送押人联系电话
	 */
	public String getSyrtel() {
		return syrtel;
	}
	/**
	 * @param 送押人联系电话 the syrtel to set
	 */
	public void setSyrtel(String syrtel) {
		this.syrtel = syrtel;
	}
	/**
	 * @return the 解回再审结果
	 */
	public String getJhzsjg() {
		return jhzsjg;
	}
	/**
	 * @param 解回再审结果 the jhzsjg to set
	 */
	public void setJhzsjg(String jhzsjg) {
		this.jhzsjg = jhzsjg;
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
	/**
	 * @return the 创建警官
	 */
	public String getCjjg() {
		return cjjg;
	}
	/**
	 * @param 创建警官 the cjjg to set
	 */
	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}
	/**
	 * @return the 罪犯当前信息
	 */
	public String getCdqxx() {
		return cdqxx;
	}
	/**
	 * @param 罪犯当前信息 the cdqxx to set
	 */
	public void setCdqxx(String cdqxx) {
		this.cdqxx = cdqxx;
	}
	/**
	 * @return the 审批状态
	 */
	public String getSpzt() {
		return spzt;
	}
	/**
	 * @param 审批状态 the spzt to set
	 */
	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	/**
	 * @return the 流程实例标识，true：回退；false：没回退
	 */
	public Boolean getProcessMark() {
		return processMark;
	}
	/**
	 * @param 流程实例标识，true：回退；false：没回退 the processMark to set
	 */
	public void setProcessMark(Boolean processMark) {
		this.processMark = processMark;
	}
	/**
	 * @return the 流程实例id
	 */
	public String getProcessId() {
		return processId;
	}
	/**
	 * @param 流程实例id the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	
}
