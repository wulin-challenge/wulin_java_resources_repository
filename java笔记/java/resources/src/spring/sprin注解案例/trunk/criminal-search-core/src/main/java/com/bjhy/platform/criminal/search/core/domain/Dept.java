package com.bjhy.platform.criminal.search.core.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 组织机构
 * @author 吴波
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "bs_jgxx")
public class Dept implements Serializable {
	private static final long serialVersionUID = -2199817668517235698L;
	public static final String _id = "id";
	public static final String _parentId = "parentId";
	public static final String _deptOrder = "deptOrder";

	/**
	 * 监区
	 */ 
	public static final String JGLX_JQ = "";

	/**
	 * 普通监区
	 */
	public static final String JGLX_PTJQ = "";

	/**
	 * 新犯监区
	 */
	public static final String JGLX_XFJQ = "";

	public Dept() {
	}

	public Dept(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "bmid")
	private String id;

	/**
	 * 机构名称
	 */
	@Column(length = 100)
	private String jgmc;

	/**
	 * 机构代码
	 */
	@Column(length = 100)
	private String jgdm;

	/**
	 * 机构类型
	 * 关联实体:SystemDic中codeName
	 */
	@Column(name = "jglx")
	private String jglx;
	
	/**
	 * 机构深度
	 */
	@Column(name = "jgsd")
	private Integer jgsd;

	/**
	 * 父级机构
	 */
	@Column(name = "fid")
	private String parentId;

	/**
	 * 同级机构排序
	 */
	private Integer deptOrder;

	private Long createDate;

	/**
	 * 更新时间
	 */
	private Date gxsj;
	/**
	 * 监区类别
	 * 关联实体:SystemDic中codeName
	 */
	@Column(name = "jqlb")
	private String jqlb;

	/**
	 * 备注
	 */
	@Column(length = 1000)
	private String bz;

	/**
	 * 是否是叶子节点
	 */
	protected Boolean leaf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public Integer getJgsd() {
		return jgsd;
	}

	public void setJgsd(Integer jgsd) {
		this.jgsd = jgsd;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getDeptOrder() {
		return deptOrder;
	}

	public void setDeptOrder(Integer deptOrder) {
		this.deptOrder = deptOrder;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Date getGxsj() {
		return gxsj;
	}

	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}

	public String getJqlb() {
		return jqlb;
	}

	public void setJqlb(String jqlb) {
		this.jqlb = jqlb;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
}
