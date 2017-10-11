
package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Description: 奖励情况
 * @author wangbowen于 2015年12月08日 
 */

@Entity
@Table(name="t_zfxzjl")
public class Reward implements Serializable{

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
    @Column(length = 100)
    private String jllb;

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
    @Column(length = 100)
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
     */
    @Column(length = 100)
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
     */
    private String ccid;
    
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the 奖励类别
	 */
	public String getJllb() {
		return jllb;
	}

	/**
	 * @param 奖励类别 the jllb to set
	 */
	public void setJllb(String jllb) {
		this.jllb = jllb;
	}

	/**
	 * @return the 呈报日期
	 */
	public Date getCbrq() {
		return cbrq;
	}

	/**
	 * @param 呈报日期 the cbrq to set
	 */
	public void setCbrq(Date cbrq) {
		this.cbrq = cbrq;
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
	 * @return the 呈报监区
	 */
	public String getCbjq() {
		return cbjq;
	}

	/**
	 * @param 呈报监区 the cbjq to set
	 */
	public void setCbjq(String cbjq) {
		this.cbjq = cbjq;
	}

	/**
	 * @return the 呈报监区Id
	 */
	public String getCbjqId() {
		return cbjqId;
	}

	/**
	 * @param 呈报监区Id the cbjqId to set
	 */
	public void setCbjqId(String cbjqId) {
		this.cbjqId = cbjqId;
	}

	/**
	 * @return the 奖励原因
	 */
	public String getJlyy() {
		return jlyy;
	}

	/**
	 * @param 奖励原因 the jlyy to set
	 */
	public void setJlyy(String jlyy) {
		this.jlyy = jlyy;
	}

	/**
	 * @return the 奖励分数
	 */
	public Integer getJlfs() {
		return jlfs;
	}

	/**
	 * @param 奖励分数 the jlfs to set
	 */
	public void setJlfs(Integer jlfs) {
		this.jlfs = jlfs;
	}

	/**
	 * @return the 其他奖励
	 */
	public String getQtjl() {
		return qtjl;
	}

	/**
	 * @param 其他奖励 the qtjl to set
	 */
	public void setQtjl(String qtjl) {
		this.qtjl = qtjl;
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
	 * @return the 纪检部门意见
	 */
	public String getJjbmyj() {
		return jjbmyj;
	}

	/**
	 * @param 纪检部门意见 the jjbmyj to set
	 */
	public void setJjbmyj(String jjbmyj) {
		this.jjbmyj = jjbmyj;
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
	 * @return the 划分年份
	 */
	public Integer getHfnf() {
		return hfnf;
	}

	/**
	 * @param 划分年份 the hfnf to set
	 */
	public void setHfnf(Integer hfnf) {
		this.hfnf = hfnf;
	}

	/**
	 * @return the 划分月份
	 */
	public Integer getHfyf() {
		return hfyf;
	}

	/**
	 * @param 划分月份 the hfyf to set
	 */
	public void setHfyf(Integer hfyf) {
		this.hfyf = hfyf;
	}

	/**
	 * @return the createDate
	 */
	public Long getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
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
	 * @return the 创建时间
	 */
	public Date getCjsj() {
		return cjsj;
	}

	/**
	 * @param 创建时间 the cjsj to set
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
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
	public String getCcid() {
		return ccid;
	}

	/**
	 * @param 罪犯当前信息 the ccid to set
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * @return the 年
	 */
	public String getJyjc() {
		return jyjc;
	}

	/**
	 * @param 年 the jyjc to set
	 */
	public void setJyjc(String jyjc) {
		this.jyjc = jyjc;
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

  

}

