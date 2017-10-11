package com.bjhy.titan.broker.jms;

import java.io.Serializable;
import java.util.Date;

/**
 * JMS 消息封装类
 * @author Administrator
 *
 */
public class JmsMessage implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5230551149846442005L;

	/**
	 * 消息ID
	 */
	private String id;
	
	/**
	 * 发送者
	 */
	private String from;
	
	/**
	 * 接受者
	 */
	private String to;
	
	/**
	 * 发送时间
	 */
	private Date time;
	
	/**
	 * 类型
	 * 
	 */
	private String type;
	
	/**
	 * 消息内容
	 */
	private String messageContext;
	
	/**
	 * 消息传输对象
	 */
	private Serializable obj;
	
	/**
	 * 消息附件
	 */
	private byte[] bytes;
	
	
	/**
	 * 备注信息
	 */
	private String note;
 

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getMessageContext() {
		return messageContext;
	}


	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}


	public Serializable getObj() {
		return obj;
	}


	public void setObj(Serializable obj) {
		this.obj = obj;
	}


	public byte[] getBytes() {
		return bytes;
	}


	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "JmsMessage [id=" + id + ", from=" + from + ", to=" + to + ", time=" + time + ", type=" + type
				+ ", messageContext=" + messageContext + ", note=" + note + "]";
	}

	
}
