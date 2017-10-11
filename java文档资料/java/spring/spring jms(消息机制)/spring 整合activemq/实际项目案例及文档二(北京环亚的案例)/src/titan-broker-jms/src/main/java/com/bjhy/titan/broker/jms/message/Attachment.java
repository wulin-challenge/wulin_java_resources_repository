package com.bjhy.titan.broker.jms.message;

import java.io.Serializable;

/**
 * 附件类
 * @author Administrator
 *
 */
public class Attachment implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 附加格式
	 */
	private String fileType;
	
	/**
	 * 附件的byte数据（统一使用utf-8 编码）
	 */
	private byte[] bytes;
	
	/**
	 * 附件的大小（单位bit）
	 */
	private long size;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	
}
