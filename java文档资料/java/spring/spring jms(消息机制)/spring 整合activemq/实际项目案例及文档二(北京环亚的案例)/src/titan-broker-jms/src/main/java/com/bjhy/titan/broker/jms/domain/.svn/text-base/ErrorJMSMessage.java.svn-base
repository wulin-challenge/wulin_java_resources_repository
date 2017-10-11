package com.bjhy.titan.broker.jms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_error_message")
public class ErrorJMSMessage {

	@Id
	private String id;
	
	//消息产生时间
	private Date createDate;
	//最近处理时间
	private Date zjclsj;
	
	// 描述
	@Column(length=4000)
	private String  describe;
	// 业务类型
	private String  type;
	// 消息内容
	@Column(length=32760)
	private byte[]  message;
	
	//执行次数
	private int zxcs;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[]  getMessage() {
		return message;
	}
	public void setMessage(byte[] bytes) {
		this.message = bytes;
	}
	
	public int getZxcs() {
		return zxcs;
	}

	public void setZxcs(int zxcs) {
		this.zxcs = zxcs;
	}

	public Date getZjclsj() {
		return zjclsj;
	}

	public void setZjclsj(Date zjclsj) {
		this.zjclsj = zjclsj;
	}
	
}
