package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Description: 处遇等级评定（批量）
 * @author: 吴波
 */
@Entity
@Table(name="t_cydjpd")
public class Cydjpd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1428463654765656629L;

	@Id
	private String id;
	
	/**
	 * 批准日期
	 */
	private Date pzrq;
	
	/**
	 * 验收时间
	 */
	private Date yssj;
	
	/**
	 * 建议处遇等级
	 * 关联实体:Cydj
	 */
	@Column(name="jycydj")
	private Cydj jycydj;
	
	/**
	 * 变动原因
	 */
	@Column(length = 1000)
	private String bdyy;
	
	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;
	
	/**
	 * 所属监区
	 */
	private String ssjq;
	
	/**
	 * 所属监区Id
	 */
	private String ssjqId;
	
	/**
	 * 创建时间
	 */
	private Date cjsj;
	
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
	@Column(length = 100)
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
	
	/**
	 * 操作监区
	 * 关联实体:Dept
	 */
	@Column(name="czjq")
	private Dept czjq;
	
	/**
	 * 筛选条件
	 * 关联实体:Cydjpdsxtj
	 */
	@Column(name="sxtj")
	private String sxtj;
	
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

	public Cydj getJycydj() {
		return jycydj;
	}

	public void setJycydj(Cydj jycydj) {
		this.jycydj = jycydj;
	}

	public String getBdyy() {
		return bdyy;
	}

	public void setBdyy(String bdyy) {
		this.bdyy = bdyy;
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

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
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

	public Dept getCzjq() {
		return czjq;
	}

	public void setCzjq(Dept czjq) {
		this.czjq = czjq;
	}

	public String getSxtj() {
		return sxtj;
	}

	public void setSxtj(String sxtj) {
		this.sxtj = sxtj;
	}

}
