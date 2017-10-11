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
 * @Description: 处遇等级评定（单个）
 * @author: 吴波
 */
@Entity
@Table(name="t_cydjpd_single")
public class CydjpdSingle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5031837732973321574L;
	
	@Id
	private String id;
	
	/**
	 * 批准日期
	 */
	@Temporal(TemporalType.DATE)
	private Date pzrq;
	
	/**
	 * 验收时间
	 */
	@Temporal(TemporalType.DATE)
	private Date yssj;
	
	/**
	 * 建议处遇等级
	 * 关联实体 : Cydj
	 */
	@Column(name="jycydj")
	private String jycydj;
	
	/**
	 * 变动原因
	 */
	@Column(length = 1000)
	private String bdyy;
	
	/**
	 * 原处遇等级
	 */
	private String ycydj;
	
	/**
	 * 是否符合老，弱，病条件
	 */
	private Integer lrbc;
	
	/**
	 * 定期考核期
	 */
	private Integer dqkhq;
	
	/**
	 * 标准考核分积分情况
	 */
	private Integer bzkhf;
	
	/**
	 * 原始考核分积分情况
	 */
	private Integer yskhf;
	
	/**
	 * 罪犯当前信息
	 * 关联实体:CurrentInfo
	 */
	@Column(name="ccid")
	private String cdqxx;
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
	 * 所属监区
	 */
	@Column(length = 1000)
	private String ssjq;
	
	/**
	 * 所属监区Id
	 */
	private String ssjqId;
	
	/**
	 * 创建日期
	 */
	private Long createDate;
	
	/**
	 * 创建警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name="cjjg")
	private String cjjg;
	
	/**
	 * 审批状态
	 */
	private String spzt;
	
	/**
	 * 流程实例标识
	 * true：回退；false：没回退
	 */
	@Column(name="process_mark")
	private Boolean processMark;
	
	/**
	 * 流程实例id
	 */
	@Column(name="process_id")
	private String processId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPzrq() {
		return pzrq;
	}

	public void setPzrq(Date pzrq) {
		this.pzrq = pzrq;
	}

	public Date getYssj() {
		return yssj;
	}

	public void setYssj(Date yssj) {
		this.yssj = yssj;
	}

	public String getJycydj() {
		return jycydj;
	}

	public void setJycydj(String jycydj) {
		this.jycydj = jycydj;
	}

	public String getBdyy() {
		return bdyy;
	}

	public void setBdyy(String bdyy) {
		this.bdyy = bdyy;
	}

	public String getYcydj() {
		return ycydj;
	}

	public void setYcydj(String ycydj) {
		this.ycydj = ycydj;
	}

	public Integer getLrbc() {
		return lrbc;
	}

	public void setLrbc(Integer lrbc) {
		this.lrbc = lrbc;
	}

	public Integer getDqkhq() {
		return dqkhq;
	}

	public void setDqkhq(Integer dqkhq) {
		this.dqkhq = dqkhq;
	}

	public Integer getBzkhf() {
		return bzkhf;
	}

	public void setBzkhf(Integer bzkhf) {
		this.bzkhf = bzkhf;
	}

	public Integer getYskhf() {
		return yskhf;
	}

	public void setYskhf(Integer yskhf) {
		this.yskhf = yskhf;
	}

	public String getCdqxx() {
		return cdqxx;
	}

	public void setCdqxx(String cdqxx) {
		this.cdqxx = cdqxx;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSsjq() {
		return ssjq;
	}

	public void setSsjq(String ssjq) {
		this.ssjq = ssjq;
	}

	public String getSsjqId() {
		return ssjqId;
	}

	public void setSsjqId(String ssjqId) {
		this.ssjqId = ssjqId;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public Boolean getProcessMark() {
		return processMark;
	}

	public void setProcessMark(Boolean processMark) {
		this.processMark = processMark;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

}
