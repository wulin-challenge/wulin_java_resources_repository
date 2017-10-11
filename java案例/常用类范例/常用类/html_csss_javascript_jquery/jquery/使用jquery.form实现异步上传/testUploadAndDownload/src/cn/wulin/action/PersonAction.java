package cn.wulin.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.wulin.domain.Person;
import cn.wulin.service.impl.PersonServiceImpl;

public class PersonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String tempPath = "/WEB-INF/temp";
	public static final String uploadPath = "/WEB-INF/upload";


	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		List<Person> personList = new PersonServiceImpl().findAllPerson();
		request.setAttribute("personList", personList);
		request.getRequestDispatcher("/jsp/home/home.jsp").forward(request, response);
	}


	@SuppressWarnings({ "static-access", "unchecked" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100*1024);;
		String tempPath = request.getSession().getServletContext().getRealPath(PersonAction.tempPath);
		factory.setRepository(new File(tempPath));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		boolean flag = upload.isMultipartContent(request);
		if(!flag){
			throw new ServletException();
		}else{
			List<FileItem> fileItemList = null;
			try {
				fileItemList = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			for(FileItem fileItem : fileItemList){
				if(fileItem.isFormField()){
					//必定是普通字段
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString("UTF-8");
				}else {
					//必定是上传字段
					
					String realFileName = fileItem.getName();
					System.out.println(realFileName);
					
					//封装到JavaBean
					
				}
			}
		}

	}

}
