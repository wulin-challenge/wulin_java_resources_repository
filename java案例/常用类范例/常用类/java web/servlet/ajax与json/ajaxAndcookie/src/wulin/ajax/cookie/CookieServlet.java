package wulin.ajax.cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import wulin.ajax.cookie.domain.Student;

public class CookieServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Random r=new Random();
		List<Student> studentList=new ArrayList<Student>();
		for(int i=0;i<10;i++){
			Student student=new Student();
			student.setId(Long.valueOf(r.nextInt(50)+""));
			student.setName(r.nextInt(100)+"ÕÅÈý");
			student.setAge(r.nextInt(100));
			studentList.add(student);
		}
		JSONArray js=JSONArray.fromObject(studentList);
		String judge=request.getParameter("judge");
		if("login".equals(judge)){
			response.getWriter().write(js.toString());
		}
	}
}
