package cn.scxh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	@Override
	public String execute() {
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/image");
		System.out.println("uploadPath-------->" + uploadPath);
		InputStream is = null;
		OutputStream os = null;
		
		File f = new File(uploadPath,this.uploadFileName);
		try {
			is = new FileInputStream(upload);
			os = new FileOutputStream(f);
			byte[] b = new byte[1024];
			int len = 0;
			while((len=is.read(b)) != -1){
				os.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				os.close();
				is.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(this.upload);
		System.out.println(this.uploadFileName);
		System.out.println(this.uploadContentType);
		return this.SUCCESS;
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
