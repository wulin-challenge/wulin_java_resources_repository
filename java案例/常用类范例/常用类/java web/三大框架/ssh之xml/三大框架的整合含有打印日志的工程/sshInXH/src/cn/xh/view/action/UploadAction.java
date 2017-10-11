package cn.xh.view.action;


import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xh.domain.Upload;
import cn.xh.domain.User;
import cn.xh.service.intf.UploadService;
import cn.xh.service.intf.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UploadAction extends ActionSupport implements ModelDriven<Upload>{
	
	private static final long serialVersionUID = 9127778948368648816L;
	
	private Long userId;
	private InputStream inputDownload;
	private String filename;
	private UploadService uploadService;
	private UserService userService;
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;
	private Upload model=new Upload();
	
	public String addUI() throws Exception {
		return "addUI";
	}
	
	public String add() throws Exception {
		System.out.println(userId);
		User user=userService.getById(userId);
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		File file=new File(path,uploadFileFileName);
		uploadFile.renameTo(file);
		model.setUser(user);
		model.setFilePath("/upload/"+uploadFileFileName);
		uploadService.addUpload(model);
		return "toList";
	}
	public String editUI() throws Exception {
		return "editUI";
	}
	public String edit() throws Exception {
		return "toList";
	}
	public String delete() throws Exception {
		uploadService.remove(model.getId());
		return "toList";
	}
	
	public String list() throws Exception {
		User user=userService.getById(userId);
		List<Upload> uploadList=(List<Upload>) uploadService.findByUserUpload(user);
		ActionContext.getContext().put("uploadList",uploadList);
		return "list";
	}
	
	/*public InputStream getDownloadFile() throws Exception {
		Upload upload=uploadService.getById(model.getId());
		String filePath=upload.getFilePath();
		int index=filePath.lastIndexOf("/");
		filename=filePath.substring(index+1);
		System.out.println(filename);
		System.out.println(upload.getFilePath());
		return ServletActionContext.getServletContext()
		.getResourceAsStream(upload.getFilePath());
	}*/
	
	public String getDownloadFile() throws Exception {
		Upload upload=uploadService.getById(model.getId());
		String filePath=upload.getFilePath();
		int index=filePath.lastIndexOf("/");
		filename=filePath.substring(index+1);
		System.out.println(filename);
		System.out.println(upload.getFilePath());
		inputDownload=ServletActionContext.getServletContext()
		.getResourceAsStream(upload.getFilePath());
		return SUCCESS;
	}
	//-------------
	
	public Upload getModel() {
		return model;
	}

	public UploadService getUploadService() {
		return uploadService;
	}

	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public void setModel(Upload model) {
		this.model = model;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getInputDownload() {
		return inputDownload;
	}

	public void setInputDownload(InputStream inputDownload) {
		this.inputDownload = inputDownload;
	}
	
	
}
