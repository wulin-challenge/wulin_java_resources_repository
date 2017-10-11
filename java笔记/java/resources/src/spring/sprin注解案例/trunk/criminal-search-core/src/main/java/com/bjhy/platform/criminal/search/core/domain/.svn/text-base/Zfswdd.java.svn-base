package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 罪犯省内调动
 * @author:吴波
 */
@Entity
@Table(name="t_zfswdd")
public class Zfswdd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2155805156616411442L;

	@Id
	private String id;
	

	/**
	 * 调动前关押监狱的监狱编号
	 */
	@Column(unique = true)
	protected String ddqgyjyJybh;

	/**
	 * 调动前关押监狱的监狱单位名称
	 */
	protected String ddqgyjyJymc;
	
	/**
	 * 调动后关押监狱的监狱编号
	 */
	@Column(unique = true)
	protected String ddhgyjyJybh;

	/**
	 * 调动后关押监狱的监狱单位名称
	 */
	protected String ddhgyjyJymc;
	
	/**
	 * 调动原因
	 */
	@Column(length = 1000)
	private String ddyy;
	
	/**
	 * 调动时间
	 */
	private Date ddsj;
	
	/**
	 * 批准日期
	 */
	private Date pzrq;
	
	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;
	
	/**
	 * 字
	 */
	@Column(length = 100)
	private String zi;
	
	/**
	 * 号
	 */
	@Column(length = 100)
	private String hao;
	
	/**
	 * 创建警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name="cjjg")
	private String cjjg;
	
	/**
	 * 创建时间
	 */
	private Date cjsj;
	
	/**
	 * 罪犯当前信息
	 * 关联实体:CurrentInfo
	 */
	@Column(name="ccid")
	private String cdqxx;
	
	private Long createDate;
	
	/**
	 * 审批状态
	 */
	@Column(length = 100)
	private String spzt;

	/**
	 * 流程实例标识，true：回退；false：没回退
	 */
	@Column(name = "process_mark")
	private Boolean processMark;

	/**
	 * 流程实例id
	 */
	@Column(name = "process_id")
	private String processId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDdqgyjyJybh() {
		return ddqgyjyJybh;
	}

	public void setDdqgyjyJybh(String ddqgyjyJybh) {
		this.ddqgyjyJybh = ddqgyjyJybh;
	}

	public String getDdqgyjyJymc() {
		return ddqgyjyJymc;
	}

	public void setDdqgyjyJymc(String ddqgyjyJymc) {
		this.ddqgyjyJymc = ddqgyjyJymc;
	}

	public String getDdhgyjyJybh() {
		return ddhgyjyJybh;
	}

	public void setDdhgyjyJybh(String ddhgyjyJybh) {
		this.ddhgyjyJybh = ddhgyjyJybh;
	}

	public String getDdhgyjyJymc() {
		return ddhgyjyJymc;
	}

	public void setDdhgyjyJymc(String ddhgyjyJymc) {
		this.ddhgyjyJymc = ddhgyjyJymc;
	}

	public String getDdyy() {
		return ddyy;
	}

	public void setDdyy(String ddyy) {
		this.ddyy = ddyy;
	}

	public Date getDdsj() {
		return ddsj;
	}

	public void setDdsj(Date ddsj) {
		this.ddsj = ddsj;
	}

	public Date getPzrq() {
		return pzrq;
	}

	public void setPzrq(Date pzrq) {
		this.pzrq = pzrq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZi() {
		return zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	public String getHao() {
		return hao;
	}

	public void setHao(String hao) {
		this.hao = hao;
	}

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public String getCdqxx() {
		return cdqxx;
	}

	public void setCdqxx(String cdqxx) {
		this.cdqxx = cdqxx;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
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
