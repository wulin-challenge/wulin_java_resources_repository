package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * @Description 罪犯死亡审批管理
 * @author wangbowen
 * @date 2015年12月8日 
 */
@Entity
@Table(name="t_death_approval")
public class DeathApproval implements Serializable{
	private static final long serialVersionUID = 4019371272544069300L;
	/**
	 * 主键ID
	 */
	@Id
	@Column(name="id",length=32)
	private String id;
	/**
	 * 字
	 */
	private String zi;
	/**
	 * 号
	 */
	private String hao;
	/**
	 * 年份
	 */
	private String jyjc;
	/**
	 * 死亡原因及经过
	 */
	@Column(length=1000)
	private String swyyjg;
	/**
	 * 死亡时间
	 */
	private Date swsj;
	/**
	 * 是否正常死亡	1：是；0：否
	 */
	private Integer sfzcsw;
	/**
	 * 监狱经办人
	 */
	@Column(length=50)
	private String jyjbr;
	/**
	 * 监狱经办人签字日期
	 */
	private Date jbrqzrq;
	/**
	 * 医院鉴定意见
	 */
	@Column(length=1000)
	private String yyjdyj;
	/**
	 * 医院名称
	 */
	@Column(length=50)
	private String yymc;
	/**
	 * 医院鉴定医生
	 */
	@Column(length=50)
	private String yyjdys;
	/**
	 * 医院鉴定日期
	 */
	private Date yyjdrq;
	/**
	 * 检察院(省)
	 */
	@Column(length=50)
	private String jcysheng;
	/**
	 * 检察院(市)
	 */
	@Column(length=50)
	private String jcyshi;
	/**
	 * 检察院(县)
	 */
	@Column(length=50)
	private String jcyxian;
	/**
	 * 检察院称谓
	 */
	@Column(length=50)
	private String jcycw;
	/**
	 * 法院名称
	 */
	@Column(length=100)
	private String fymc;
	/**
	 * 检察院鉴定书字号(年度)
	 */
	@Column(length=30)
	private String jcyzhi;
	/**
	 * 检察院鉴定书字号(序号)
	 */
	@Column(length=30)
	private String jcyhao;
	/**
	 * 检察院鉴定意见
	 */
	@Column(length=1000)
	private String jcyyy;
	/**
	 * 法医姓名
	 */
	@Column(length=30)
	private String fyxm;
	/**
	 * 检察院鉴定日期
	 */
	private Date jcyrq;
	/**
	 * 尸体处理日期
	 */
	private Date stclrq;
	/**
	 * 尸体处理方式
	 */
	@Column(length=500)
	private String stclfs;
	/**
	 * 尸体处理情况
	 */
	@Column(length=1000)
	private String stclqk;
	/**
	 * 死亡地点
	 */
	@Column(length=1000)
	private String swdd;
	/**
	 * 亲属代表姓名
	 */
	@Column(length=50)
	private String qsdbxm;
	/**
	 * 亲属与代表关系
	 */
	@Column(length=50)
	private String ydbgx;
	/**
	 * 通知发出日期
	 */
	private Date tzfcsj;
	/**
	 * 补偿金额
	 */
	private Float bcj;
	/**
	 * 附件
	 */
	@Lob
	private String fj;
	/**
	 * 备注
	 */
	@Column(length=2048)
	private String bz;
	/**
	 * 创建日期
	 */
	private Date cjrq;
	/**
	 * 创建时间
	 */
	private Long createDate;
	/**
	 * 创建警官
	 */
	@Column(length=1000)
	private String cjjg;
	/**
	 * 审批状态
	 */
	@Column(length=20)
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
	 * 罪犯当前信息
	 */
	@Column(name="ccid")
	private String cdqxx;
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
	 * @return the 字
	 */
	public String getZi() {
		return zi;
	}
	/**
	 * @param 字 the zi to set
	 */
	public void setZi(String zi) {
		this.zi = zi;
	}
	/**
	 * @return the 号
	 */
	public String getHao() {
		return hao;
	}
	/**
	 * @param 号 the hao to set
	 */
	public void setHao(String hao) {
		this.hao = hao;
	}
	/**
	 * @return the 年份
	 */
	public String getJyjc() {
		return jyjc;
	}
	/**
	 * @param 年份 the jyjc to set
	 */
	public void setJyjc(String jyjc) {
		this.jyjc = jyjc;
	}
	/**
	 * @return the 死亡原因及经过
	 */
	public String getSwyyjg() {
		return swyyjg;
	}
	/**
	 * @param 死亡原因及经过 the swyyjg to set
	 */
	public void setSwyyjg(String swyyjg) {
		this.swyyjg = swyyjg;
	}
	/**
	 * @return the 死亡时间
	 */
	public Date getSwsj() {
		return swsj;
	}
	/**
	 * @param 死亡时间 the swsj to set
	 */
	public void setSwsj(Date swsj) {
		this.swsj = swsj;
	}
	/**
	 * @return the 是否正常死亡1：是；0：否
	 */
	public Integer getSfzcsw() {
		return sfzcsw;
	}
	/**
	 * @param 是否正常死亡1：是；0：否 the sfzcsw to set
	 */
	public void setSfzcsw(Integer sfzcsw) {
		this.sfzcsw = sfzcsw;
	}
	/**
	 * @return the 监狱经办人
	 */
	public String getJyjbr() {
		return jyjbr;
	}
	/**
	 * @param 监狱经办人 the jyjbr to set
	 */
	public void setJyjbr(String jyjbr) {
		this.jyjbr = jyjbr;
	}
	/**
	 * @return the 监狱经办人签字日期
	 */
	public Date getJbrqzrq() {
		return jbrqzrq;
	}
	/**
	 * @param 监狱经办人签字日期 the jbrqzrq to set
	 */
	public void setJbrqzrq(Date jbrqzrq) {
		this.jbrqzrq = jbrqzrq;
	}
	/**
	 * @return the 医院鉴定意见
	 */
	public String getYyjdyj() {
		return yyjdyj;
	}
	/**
	 * @param 医院鉴定意见 the yyjdyj to set
	 */
	public void setYyjdyj(String yyjdyj) {
		this.yyjdyj = yyjdyj;
	}
	/**
	 * @return the 医院名称
	 */
	public String getYymc() {
		return yymc;
	}
	/**
	 * @param 医院名称 the yymc to set
	 */
	public void setYymc(String yymc) {
		this.yymc = yymc;
	}
	/**
	 * @return the 医院鉴定医生
	 */
	public String getYyjdys() {
		return yyjdys;
	}
	/**
	 * @param 医院鉴定医生 the yyjdys to set
	 */
	public void setYyjdys(String yyjdys) {
		this.yyjdys = yyjdys;
	}
	/**
	 * @return the 医院鉴定日期
	 */
	public Date getYyjdrq() {
		return yyjdrq;
	}
	/**
	 * @param 医院鉴定日期 the yyjdrq to set
	 */
	public void setYyjdrq(Date yyjdrq) {
		this.yyjdrq = yyjdrq;
	}
	/**
	 * @return the 检察院(省)
	 */
	public String getJcysheng() {
		return jcysheng;
	}
	/**
	 * @param 检察院(省) the jcysheng to set
	 */
	public void setJcysheng(String jcysheng) {
		this.jcysheng = jcysheng;
	}
	/**
	 * @return the 检察院(市)
	 */
	public String getJcyshi() {
		return jcyshi;
	}
	/**
	 * @param 检察院(市) the jcyshi to set
	 */
	public void setJcyshi(String jcyshi) {
		this.jcyshi = jcyshi;
	}
	/**
	 * @return the 检察院(县)
	 */
	public String getJcyxian() {
		return jcyxian;
	}
	/**
	 * @param 检察院(县) the jcyxian to set
	 */
	public void setJcyxian(String jcyxian) {
		this.jcyxian = jcyxian;
	}
	/**
	 * @return the 检察院称谓
	 */
	public String getJcycw() {
		return jcycw;
	}
	/**
	 * @param 检察院称谓 the jcycw to set
	 */
	public void setJcycw(String jcycw) {
		this.jcycw = jcycw;
	}
	/**
	 * @return the 法院名称
	 */
	public String getFymc() {
		return fymc;
	}
	/**
	 * @param 法院名称 the fymc to set
	 */
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	/**
	 * @return the 检察院鉴定书字号(年度)
	 */
	public String getJcyzhi() {
		return jcyzhi;
	}
	/**
	 * @param 检察院鉴定书字号(年度) the jcyzhi to set
	 */
	public void setJcyzhi(String jcyzhi) {
		this.jcyzhi = jcyzhi;
	}
	/**
	 * @return the 检察院鉴定书字号(序号)
	 */
	public String getJcyhao() {
		return jcyhao;
	}
	/**
	 * @param 检察院鉴定书字号(序号) the jcyhao to set
	 */
	public void setJcyhao(String jcyhao) {
		this.jcyhao = jcyhao;
	}
	/**
	 * @return the 检察院鉴定意见
	 */
	public String getJcyyy() {
		return jcyyy;
	}
	/**
	 * @param 检察院鉴定意见 the jcyyy to set
	 */
	public void setJcyyy(String jcyyy) {
		this.jcyyy = jcyyy;
	}
	/**
	 * @return the 法医姓名
	 */
	public String getFyxm() {
		return fyxm;
	}
	/**
	 * @param 法医姓名 the fyxm to set
	 */
	public void setFyxm(String fyxm) {
		this.fyxm = fyxm;
	}
	/**
	 * @return the 检察院鉴定日期
	 */
	public Date getJcyrq() {
		return jcyrq;
	}
	/**
	 * @param 检察院鉴定日期 the jcyrq to set
	 */
	public void setJcyrq(Date jcyrq) {
		this.jcyrq = jcyrq;
	}
	/**
	 * @return the 尸体处理日期
	 */
	public Date getStclrq() {
		return stclrq;
	}
	/**
	 * @param 尸体处理日期 the stclrq to set
	 */
	public void setStclrq(Date stclrq) {
		this.stclrq = stclrq;
	}
	/**
	 * @return the 尸体处理方式
	 */
	public String getStclfs() {
		return stclfs;
	}
	/**
	 * @param 尸体处理方式 the stclfs to set
	 */
	public void setStclfs(String stclfs) {
		this.stclfs = stclfs;
	}
	/**
	 * @return the 尸体处理情况
	 */
	public String getStclqk() {
		return stclqk;
	}
	/**
	 * @param 尸体处理情况 the stclqk to set
	 */
	public void setStclqk(String stclqk) {
		this.stclqk = stclqk;
	}
	/**
	 * @return the 死亡地点
	 */
	public String getSwdd() {
		return swdd;
	}
	/**
	 * @param 死亡地点 the swdd to set
	 */
	public void setSwdd(String swdd) {
		this.swdd = swdd;
	}
	/**
	 * @return the 亲属代表姓名
	 */
	public String getQsdbxm() {
		return qsdbxm;
	}
	/**
	 * @param 亲属代表姓名 the qsdbxm to set
	 */
	public void setQsdbxm(String qsdbxm) {
		this.qsdbxm = qsdbxm;
	}
	/**
	 * @return the 亲属与代表关系
	 */
	public String getYdbgx() {
		return ydbgx;
	}
	/**
	 * @param 亲属与代表关系 the ydbgx to set
	 */
	public void setYdbgx(String ydbgx) {
		this.ydbgx = ydbgx;
	}
	/**
	 * @return the 通知发出日期
	 */
	public Date getTzfcsj() {
		return tzfcsj;
	}
	/**
	 * @param 通知发出日期 the tzfcsj to set
	 */
	public void setTzfcsj(Date tzfcsj) {
		this.tzfcsj = tzfcsj;
	}
	/**
	 * @return the 补偿金额
	 */
	public Float getBcj() {
		return bcj;
	}
	/**
	 * @param 补偿金额 the bcj to set
	 */
	public void setBcj(Float bcj) {
		this.bcj = bcj;
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
	 * @return the 创建日期
	 */
	public Date getCjrq() {
		return cjrq;
	}
	/**
	 * @param 创建日期 the cjrq to set
	 */
	public void setCjrq(Date cjrq) {
		this.cjrq = cjrq;
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
}
