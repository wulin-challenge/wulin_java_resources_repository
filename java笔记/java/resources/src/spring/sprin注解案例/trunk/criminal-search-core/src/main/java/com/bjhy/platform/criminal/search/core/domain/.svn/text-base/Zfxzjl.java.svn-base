package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 罪犯行政奖励
 *  @author:吴波
 */
@Entity
@Table(name="t_zfxzjl")
public class Zfxzjl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4056739708156219624L;
	
	public static final String SPZT_YGD = "已归档";

	@Id
	private String id;

	/**
	 * 奖励类别
	 */
	@Column(name = "jllb")
	private Xzlb jllb;

	/**
	 * 呈报日期
	 */
	private Date cbrq;

	/**
	 * 批准日期
	 */
	private Date pzrq;

	/**
	 * 呈报监区
	 */
	private String cbjq;
	
	/**
	 * 呈报监区Id
	 */
	private String cbjqId;

	/**
	 * 奖励原因
	 */
	@Column(length = 1000)
	private String jlyy;

	/**
	 * 奖励分数
	 */
	private Integer jlfs;
	
	/**
	 * 其他奖励
	 */
	@Column(length = 1000)
	private String qtjl;

	/**
	 * 附件
	 */
	@Column(length = 500)
	private String fj;

	/**
	 * 纪检部门意见
	 */
	@Column(length = 1000)
	private String jjbmyj;

	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;

	/**
	 * 划分年份
	 */
	private Integer hfnf;

	/**
	 * 划分月份
	 */
	private Integer hfyf;

	private Long createDate;

	/**
	 * 创建警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name = "cjjg")
	private String cjjg;
	
	/**
	 * 创建时间
	 */
	private Date cjsj;

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

	/**
	 * 罪犯当前信息
	 * 关联实体:CurrentInfo
	 */
	@Column(name = "ccid")
	private String cdqxx;
	
	/**
	 * 年
	 */
	@Column(length = 100)
	private String jyjc;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Xzlb getJllb() {
		return jllb;
	}

	public void setJllb(Xzlb jllb) {
		this.jllb = jllb;
	}

	public Date getCbrq() {
		return cbrq;
	}

	public void setCbrq(Date cbrq) {
		this.cbrq = cbrq;
	}

	public Date getPzrq() {
		return pzrq;
	}

	public void setPzrq(Date pzrq) {
		this.pzrq = pzrq;
	}

	public String getCbjq() {
		return cbjq;
	}

	public void setCbjq(String cbjq) {
		this.cbjq = cbjq;
	}

	public String getCbjqId() {
		return cbjqId;
	}

	public void setCbjqId(String cbjqId) {
		this.cbjqId = cbjqId;
	}

	public String getJlyy() {
		return jlyy;
	}

	public void setJlyy(String jlyy) {
		this.jlyy = jlyy;
	}

	public Integer getJlfs() {
		return jlfs;
	}

	public void setJlfs(Integer jlfs) {
		this.jlfs = jlfs;
	}

	public String getQtjl() {
		return qtjl;
	}

	public void setQtjl(String qtjl) {
		this.qtjl = qtjl;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public String getJjbmyj() {
		return jjbmyj;
	}

	public void setJjbmyj(String jjbmyj) {
		this.jjbmyj = jjbmyj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getHfnf() {
		return hfnf;
	}

	public void setHfnf(Integer hfnf) {
		this.hfnf = hfnf;
	}

	public Integer getHfyf() {
		return hfyf;
	}

	public void setHfyf(Integer hfyf) {
		this.hfyf = hfyf;
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

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
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

	public String getCdqxx() {
		return cdqxx;
	}

	public void setCdqxx(String cdqxx) {
		this.cdqxx = cdqxx;
	}

	public String getJyjc() {
		return jyjc;
	}

	public void setJyjc(String jyjc) {
		this.jyjc = jyjc;
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

}
