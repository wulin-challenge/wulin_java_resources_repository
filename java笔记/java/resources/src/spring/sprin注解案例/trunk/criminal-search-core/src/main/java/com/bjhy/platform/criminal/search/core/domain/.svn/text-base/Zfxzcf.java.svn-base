package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Description: 罪犯行政处罚
 * @author:吴波
 */
@Entity
@Table(name="t_zfxzcf")
public class Zfxzcf implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8780079310211614118L;

	public static final String _spzt = "spzt";
	
	public static final String SPZT_YGD = "已归档";

	@Id
	private String id;

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
	 * 处罚类别
	 * 
	 *关联实体 : Xzlb
	 */
	@Column(name = "cflb")
	private String cflb;

	/**
	 * 处罚原因
	 */
	@Column(length = 1000)
	private String cfyy;

	/**
	 * 扣除分数
	 */
	private Integer kcfs;

	/**
	 * 处罚原因详述
	 */
	@Column(length = 1000)
	private String cfyyxs;

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
	 * 划分年份
	 */
	private Integer hfnf;

	/**
	 * 划分月份
	 */
	private Integer hfyf;
	
	/**
	 * 禁闭天数
	 */
	private Double jbts;
	
	/**
	 * 开始时间
	 */
	private Date kssj;
	
	/**
	 * 结束时间
	 */
	private Date jssj;
	
	/**
	 * 考察时间（月）
	 */
	private Integer kcsj;
	
	/**
	 * 禁闭室
	 */
	@Column(length = 100)
	private String jbs;
	
	/**
	 * 是否使用戒具
	 */
	private Integer syjj;

	/**
	 * 解除时间
	 */
	private Date jcsj;

	/**
	 * 解除原因
	 */
	@Column(length = 1000)
	private String jcyy;
	
	/**
	 * 罪犯表现
	 */
	@Column(length = 1000)
	private String zfbx;
	
	/**
	 * 解除申请警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name="jcsqjg")
	private String jcsqjg;
	
	/**
	 * 解除申请时间
	 */
	private Date jcsqsj;
	
	/**
	 * 解除批准人
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name = "jcpzr")
	private String jcpzr;
	
	/**
	 * 解除批准时间
	 */
	private Date jcpzsj;
	
	/**
	 * 解除警官
	 * 关联实体:Police,这里没Police,所有是实体类 : SystemUser
	 */
	@Column(name = "jcjg")
	private String jcjg;

	/**
	 * 解除操作时间
	 */
	private Date jcczsj;

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
	
	 //////set and get  /////

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCflb() {
		return cflb;
	}

	public void setCflb(String cflb) {
		this.cflb = cflb;
	}

	public String getCfyy() {
		return cfyy;
	}

	public void setCfyy(String cfyy) {
		this.cfyy = cfyy;
	}

	public Integer getKcfs() {
		return kcfs;
	}

	public void setKcfs(Integer kcfs) {
		this.kcfs = kcfs;
	}

	public String getCfyyxs() {
		return cfyyxs;
	}

	public void setCfyyxs(String cfyyxs) {
		this.cfyyxs = cfyyxs;
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

	public Double getJbts() {
		return jbts;
	}

	public void setJbts(Double jbts) {
		this.jbts = jbts;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public Integer getKcsj() {
		return kcsj;
	}

	public void setKcsj(Integer kcsj) {
		this.kcsj = kcsj;
	}

	public String getJbs() {
		return jbs;
	}

	public void setJbs(String jbs) {
		this.jbs = jbs;
	}

	public Integer getSyjj() {
		return syjj;
	}

	public void setSyjj(Integer syjj) {
		this.syjj = syjj;
	}

	public Date getJcsj() {
		return jcsj;
	}

	public void setJcsj(Date jcsj) {
		this.jcsj = jcsj;
	}

	public String getJcyy() {
		return jcyy;
	}

	public void setJcyy(String jcyy) {
		this.jcyy = jcyy;
	}

	public String getZfbx() {
		return zfbx;
	}

	public void setZfbx(String zfbx) {
		this.zfbx = zfbx;
	}

	public String getJcsqjg() {
		return jcsqjg;
	}

	public void setJcsqjg(String jcsqjg) {
		this.jcsqjg = jcsqjg;
	}

	public Date getJcsqsj() {
		return jcsqsj;
	}

	public void setJcsqsj(Date jcsqsj) {
		this.jcsqsj = jcsqsj;
	}

	public String getJcpzr() {
		return jcpzr;
	}

	public void setJcpzr(String jcpzr) {
		this.jcpzr = jcpzr;
	}

	public Date getJcpzsj() {
		return jcpzsj;
	}

	public void setJcpzsj(Date jcpzsj) {
		this.jcpzsj = jcpzsj;
	}

	public String getJcjg() {
		return jcjg;
	}

	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}

	public Date getJcczsj() {
		return jcczsj;
	}

	public void setJcczsj(Date jcczsj) {
		this.jcczsj = jcczsj;
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
