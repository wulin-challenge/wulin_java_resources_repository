package cn.wulin.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {
	private static final long serialVersionUID = -5893590963257061465L;
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public String upload() throws Exception {
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		File file=new File(path,uploadFileName);
		upload.renameTo(file);
		return "success";
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	
}
