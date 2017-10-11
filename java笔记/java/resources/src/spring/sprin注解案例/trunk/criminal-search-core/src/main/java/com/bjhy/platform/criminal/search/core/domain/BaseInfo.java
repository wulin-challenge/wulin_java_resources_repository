package com.bjhy.platform.criminal.search.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Description 罪犯基本信息
 * @author wangbowen
 * @date 2015年12月08日
 */
@Entity
@Table(name="bs_bsinfo")
public class BaseInfo implements Serializable{
	private static final long serialVersionUID = 479756124950792636L;
	public static final String _xm = "xm";
	public static final String _zfbh = "zfbh";
	public static final String _zfdah = "zfdah";
	public static final String _pinyin = "pinyin";
	public static final String _jianpin = "jianpin";
	/**
	 * 罪犯id
	 */
	@Id
	@Column(name="zfid")
	private String id;
	/**
	 * 罪犯编号
	 */
	private String zfbh;
	/**
	 * 挡卡导入罪犯编号
	 */
	private String drbh;
	/**
	 * 挡卡导入日期
	 */
	private Date drrq;
	/**
	 * 挡卡导入最后一次更新
	 */
	private Date drgxrq;
	/**
	 * 罪犯密码
	 */
	private String pwd;
	/**
	 * 罪犯档案号
	 */
	private String zfdah;
	/**
	 * 姓名
	 */
	@Column(length=1000)
	private String xm;
	/**
	 * 性别
	 */
	@Column(length=100)
	private String xb;
	/**
	 * 出生日期
	 */
	private Date csrq;
	/**
	 * 身份证号
	 */
	@Column(length=1000)
	private String sfzh;
	/**
	 * 入监时间
	 */
	private Date rjsj;
	/**
	 * 标准分
	 */
	private Integer bzf;
	/**
	 * 考核分
	 */
	private Integer khf;
	/**
	 * 文化程度
	 */
	@Column(length=1000)
	private String whcd;
	/**
	 * 民族
	 */
	@Column(length=1000)
	private String mz;
	/**
	 * 政治面貌
	 */
	@Column(length=1000)
	private String zzmm; 
	/**
	 * 分押类型
	 */
	@Column(length=1000)
	private String fylx;
	/**
	 * 户口类型
	 */
	@Column(length=1000)
	private String hklx;
	/**
	 * 共同犯罪参与类型
	 */
	@Column(length=1000)
	private String gtfzcylx;
	/**
	 * 共同犯罪人数
	 */
	private Integer gtfzrs;
	/**
	 * 流传作案类别
	 */
	private String lczalb;
	/**
	 * 原判刑种
	 */
	@Column(length=100)
	private String ypxz;
	/**
	 * 原始有效刑期
	 */
	@Column(length=200)
	private String ysyxxq;
	/**
	 * 前科次数
	 */
	private Integer qkcs;
	/**
	 * 原技术等级
	 */
	@Column(length=1000)
	private String yjsdj;
	/**
	 * 特长/捕前技能
	 */
	@Column(length=1000)
	private String bqjn;
	/**
	 * 宗教信仰
	 */
	@Column(length=1000)
	private String zjxy;
	/**
	 * 参加过何党派团体
	 */
	@Column(length=1000)
	private String dptt;
	/**
	 * 劳动能力状况
	 */
	@Column(length=1000)
	private String ldnlzk;
	/**
	 * 捕前婚姻状况
	 */
	@Column(length=1000)
	private String bqhyzk;
	/**
	 * 国家
	 */
	@Column(length=1000)
	private String gj;
	/**
	 * 籍贯所属省
	 */
	@Column(length=1000)
	private String jgsss;
	/**
	 * 籍贯所属市
	 */
	@Column(length=1000)
	private String jgssshi;
	/**
	 * 籍贯所属县
	 */
	@Column(length=1000)
	private String jgssx;
	/**
	 * 籍贯所属街道
	 */
	@Column(length=1000)
	private String jgssjd;
	/**
	 * 籍贯详细地址
	 */
	@Column(length=1000)
	private String jgxxdz;
	/**
	 * 出生地址
	 */
	@Column(length=1000)
	private String csdz;
	/**
	 * 家庭住址(行政区划)
	 */
	@Column(length=1000)
	private String jtdzxzqh;
	/**
	 * 家庭住址(详细地址)
	 */
	@Column(length=1000)
	private String jtdzxxdz;
	/**
	 * 居住址(行政区划)
	 */
	@Column(length=1000)
	private String jzdzxzqh;
	/**
	 * 居住地址(详细地址)
	 */
	@Column(length=1000)
	private String jzdzxxdz;
	/**
	 * 三无人员
	 */
	@Column(length=1000)
	private String swry;
	/**
	 * 军警经历
	 */
	@Column(length=1000)
	private String jjjl;
	/**
	 * 四涉犯
	 */
	@Column(length=1000)
	private String ssf;
	/**
	 * 是否为职务犯
	 */
	private Integer sfzwf;
	/**
	 * 是否为累犯
	 */
	private Integer sflf;
	/**
	 * 是否为惯犯
	 */
	private Integer sfgf;
	/**
	 * 是否为团伙犯
	 */
	private Integer sfthf;
	/**
	 * 是否孤儿
	 */
	private Integer sfge;
	/**
	 * 三类罪犯
	 */
	@Column(length=1000)
	private String slzf;
	/**
	 * 减刑尺度
	 */
	@Column(length=1000)
	private String jxcd;
	/**
	 * 四史
	 */
	@Column(length=1000)
	private String ss;
	/**
	 * 案犯类别
	 */
	@Column(length=1000)
	private String aflb;
	/**
	 * 代码拼音
	 */
	@Column(length=2048)
	private String pinyin;
	/**
	 * 代码简拼
	 */
	@Column(length=2048)
	private String jianpin;
	/**
	 * 罪犯照片（正面照）
	 */
	@Column(length=1000)
	private String photo;
	/**
	 * 照片资源
	 */
	@Transient
	private byte[] photoResource;
	
	/**
	 * 参加过战争
	 */
	@Column(length=1000)
	private String cjzz;
	
	/**
	 * 参加过维稳处突
	 */
	@Column(length=1000)
	private String cjwwct;
	
	/**
	 * 参加过重大强险救灾
	 */
	@Column(length=1000)
	private String cjzdjz;
	
	
	/**
	 * 丧偶有未成年或残疾子女
	 */
	@Column(length=1000)
	private String soorcj;
	
	
	/**
	 * 曾系人民解放军
	 */
	@Column(length=1000)
	private String jfj;
	
	
	/**
	 * 获得过全国五一劳动奖章
	 */
	@Column(length=1000)
	private String ndjz;
	
	/**
	 * 邪教案犯
	 */
	@Column(length=1000)
	private String xjaf;
	
	/**
	 * 是否1949年10月1日前参加工作的罪犯
	 */
	private Integer sfjfq;
	/**
	 * 是否破坏金融管理秩序和金融诈骗罪犯
	 */
	private Integer sfphjr;
	/**
	 * 是否知密犯
	 */
	private Integer sfzmf;
	/**
	 * 是否两乱犯
	 */
	private Integer sfllf;
	/**
	 * 是否两非犯
	 */
	private Integer sflff;
	/**
	 * 是否两案犯
	 */
	private Integer sflaf;
	/**
	 * 备注
	 */
	@Column(length=2048)
	private String bz;
	/**
	 * 刑法变动备注
	 */
	@Column(length=2048)
	private String xfbdbz;
	/**
	 * 曾受何种惩处
	 */
	@Column(length=2048)
	private String cshzcc;
	/**
	 * 学习培训情况
	 */
	@Column(length=2048)
	private String xxpxqk;
	/**
	 * 劳动岗位
	 */
	@Column(length=2048)
	private String ndgw;
	/**
	 * 干部等级
	 */
	@Column(length=2048)
	private String gbdj;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZfbh() {
		return zfbh;
	}
	public void setZfbh(String zfbh) {
		this.zfbh = zfbh;
	}
	public String getDrbh() {
		return drbh;
	}
	public void setDrbh(String drbh) {
		this.drbh = drbh;
	}
	public Date getDrrq() {
		return drrq;
	}
	public void setDrrq(Date drrq) {
		this.drrq = drrq;
	}
	public Date getDrgxrq() {
		return drgxrq;
	}
	public void setDrgxrq(Date drgxrq) {
		this.drgxrq = drgxrq;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getZfdah() {
		return zfdah;
	}
	public void setZfdah(String zfdah) {
		this.zfdah = zfdah;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public Date getRjsj() {
		return rjsj;
	}
	public void setRjsj(Date rjsj) {
		this.rjsj = rjsj;
	}
	public Integer getBzf() {
		return bzf;
	}
	public void setBzf(Integer bzf) {
		this.bzf = bzf;
	}
	public Integer getKhf() {
		return khf;
	}
	public void setKhf(Integer khf) {
		this.khf = khf;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getFylx() {
		return fylx;
	}
	public void setFylx(String fylx) {
		this.fylx = fylx;
	}
	public String getHklx() {
		return hklx;
	}
	public void setHklx(String hklx) {
		this.hklx = hklx;
	}
	public String getGtfzcylx() {
		return gtfzcylx;
	}
	public void setGtfzcylx(String gtfzcylx) {
		this.gtfzcylx = gtfzcylx;
	}
	public Integer getGtfzrs() {
		return gtfzrs;
	}
	public void setGtfzrs(Integer gtfzrs) {
		this.gtfzrs = gtfzrs;
	}
	public String getLczalb() {
		return lczalb;
	}
	public void setLczalb(String lczalb) {
		this.lczalb = lczalb;
	}
	public String getYpxz() {
		return ypxz;
	}
	public void setYpxz(String ypxz) {
		this.ypxz = ypxz;
	}
	public String getYsyxxq() {
		return ysyxxq;
	}
	public void setYsyxxq(String ysyxxq) {
		this.ysyxxq = ysyxxq;
	}
	public Integer getQkcs() {
		return qkcs;
	}
	public void setQkcs(Integer qkcs) {
		this.qkcs = qkcs;
	}
	public String getYjsdj() {
		return yjsdj;
	}
	public void setYjsdj(String yjsdj) {
		this.yjsdj = yjsdj;
	}
	public String getBqjn() {
		return bqjn;
	}
	public void setBqjn(String bqjn) {
		this.bqjn = bqjn;
	}
	public String getZjxy() {
		return zjxy;
	}
	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}
	public String getDptt() {
		return dptt;
	}
	public void setDptt(String dptt) {
		this.dptt = dptt;
	}
	public String getLdnlzk() {
		return ldnlzk;
	}
	public void setLdnlzk(String ldnlzk) {
		this.ldnlzk = ldnlzk;
	}
	public String getBqhyzk() {
		return bqhyzk;
	}
	public void setBqhyzk(String bqhyzk) {
		this.bqhyzk = bqhyzk;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getJgsss() {
		return jgsss;
	}
	public void setJgsss(String jgsss) {
		this.jgsss = jgsss;
	}
	public String getJgssshi() {
		return jgssshi;
	}
	public void setJgssshi(String jgssshi) {
		this.jgssshi = jgssshi;
	}
	public String getJgssx() {
		return jgssx;
	}
	public void setJgssx(String jgssx) {
		this.jgssx = jgssx;
	}
	public String getJgssjd() {
		return jgssjd;
	}
	public void setJgssjd(String jgssjd) {
		this.jgssjd = jgssjd;
	}
	public String getJgxxdz() {
		return jgxxdz;
	}
	public void setJgxxdz(String jgxxdz) {
		this.jgxxdz = jgxxdz;
	}
	public String getCsdz() {
		return csdz;
	}
	public void setCsdz(String csdz) {
		this.csdz = csdz;
	}
	public String getJtdzxzqh() {
		return jtdzxzqh;
	}
	public void setJtdzxzqh(String jtdzxzqh) {
		this.jtdzxzqh = jtdzxzqh;
	}
	public String getJtdzxxdz() {
		return jtdzxxdz;
	}
	public void setJtdzxxdz(String jtdzxxdz) {
		this.jtdzxxdz = jtdzxxdz;
	}
	public String getJzdzxzqh() {
		return jzdzxzqh;
	}
	public void setJzdzxzqh(String jzdzxzqh) {
		this.jzdzxzqh = jzdzxzqh;
	}
	public String getJzdzxxdz() {
		return jzdzxxdz;
	}
	public void setJzdzxxdz(String jzdzxxdz) {
		this.jzdzxxdz = jzdzxxdz;
	}
	public String getSwry() {
		return swry;
	}
	public void setSwry(String swry) {
		this.swry = swry;
	}
	public String getJjjl() {
		return jjjl;
	}
	public void setJjjl(String jjjl) {
		this.jjjl = jjjl;
	}
	public String getSsf() {
		return ssf;
	}
	public void setSsf(String ssf) {
		this.ssf = ssf;
	}
	public Integer getSfzwf() {
		return sfzwf;
	}
	public void setSfzwf(Integer sfzwf) {
		this.sfzwf = sfzwf;
	}
	public Integer getSflf() {
		return sflf;
	}
	public void setSflf(Integer sflf) {
		this.sflf = sflf;
	}
	public Integer getSfgf() {
		return sfgf;
	}
	public void setSfgf(Integer sfgf) {
		this.sfgf = sfgf;
	}
	public Integer getSfthf() {
		return sfthf;
	}
	public void setSfthf(Integer sfthf) {
		this.sfthf = sfthf;
	}
	public Integer getSfge() {
		return sfge;
	}
	public void setSfge(Integer sfge) {
		this.sfge = sfge;
	}
	public String getSlzf() {
		return slzf;
	}
	public void setSlzf(String slzf) {
		this.slzf = slzf;
	}
	public String getJxcd() {
		return jxcd;
	}
	public void setJxcd(String jxcd) {
		this.jxcd = jxcd;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getAflb() {
		return aflb;
	}
	public void setAflb(String aflb) {
		this.aflb = aflb;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getJianpin() {
		return jianpin;
	}
	public void setJianpin(String jianpin) {
		this.jianpin = jianpin;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public byte[] getPhotoResource() {
		return photoResource;
	}
	public void setPhotoResource(byte[] photoResource) {
		this.photoResource = photoResource;
	}
	public String getCjzz() {
		return cjzz;
	}
	public void setCjzz(String cjzz) {
		this.cjzz = cjzz;
	}
	public String getCjwwct() {
		return cjwwct;
	}
	public void setCjwwct(String cjwwct) {
		this.cjwwct = cjwwct;
	}
	public String getCjzdjz() {
		return cjzdjz;
	}
	public void setCjzdjz(String cjzdjz) {
		this.cjzdjz = cjzdjz;
	}
	public String getSoorcj() {
		return soorcj;
	}
	public void setSoorcj(String soorcj) {
		this.soorcj = soorcj;
	}
	public String getJfj() {
		return jfj;
	}
	public void setJfj(String jfj) {
		this.jfj = jfj;
	}
	public String getNdjz() {
		return ndjz;
	}
	public void setNdjz(String ndjz) {
		this.ndjz = ndjz;
	}
	public String getXjaf() {
		return xjaf;
	}
	public void setXjaf(String xjaf) {
		this.xjaf = xjaf;
	}
	public Integer getSfjfq() {
		return sfjfq;
	}
	public void setSfjfq(Integer sfjfq) {
		this.sfjfq = sfjfq;
	}
	public Integer getSfphjr() {
		return sfphjr;
	}
	public void setSfphjr(Integer sfphjr) {
		this.sfphjr = sfphjr;
	}
	public Integer getSfzmf() {
		return sfzmf;
	}
	public void setSfzmf(Integer sfzmf) {
		this.sfzmf = sfzmf;
	}
	public Integer getSfllf() {
		return sfllf;
	}
	public void setSfllf(Integer sfllf) {
		this.sfllf = sfllf;
	}
	public Integer getSflff() {
		return sflff;
	}
	public void setSflff(Integer sflff) {
		this.sflff = sflff;
	}
	public Integer getSflaf() {
		return sflaf;
	}
	public void setSflaf(Integer sflaf) {
		this.sflaf = sflaf;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXfbdbz() {
		return xfbdbz;
	}
	public void setXfbdbz(String xfbdbz) {
		this.xfbdbz = xfbdbz;
	}
	public String getCshzcc() {
		return cshzcc;
	}
	public void setCshzcc(String cshzcc) {
		this.cshzcc = cshzcc;
	}
	public String getXxpxqk() {
		return xxpxqk;
	}
	public void setXxpxqk(String xxpxqk) {
		this.xxpxqk = xxpxqk;
	}
	public String getNdgw() {
		return ndgw;
	}
	public void setNdgw(String ndgw) {
		this.ndgw = ndgw;
	}
	public String getGbdj() {
		return gbdj;
	}
	public void setGbdj(String gbdj) {
		this.gbdj = gbdj;
	}
	
}
