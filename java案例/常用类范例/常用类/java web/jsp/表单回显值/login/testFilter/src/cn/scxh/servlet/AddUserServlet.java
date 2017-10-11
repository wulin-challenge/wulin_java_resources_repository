package cn.scxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.scxh.model.User;
import cn.scxh.service.impl.UserServiceImpl;
import cn.scxh.service.intf.UserService;
import cn.scxh.util.StringUtils;

public class AddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=gbk");
		//req.setCharacterEncoding("gbk");
		
		//第一步：获取页面输入的数据
		String username = req.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"),"gbk");
		
		String sex = req.getParameter("sex");
		String[] hobby = req.getParameterValues("hobby");
		String dept = req.getParameter("dept");
		String description = req.getParameter("description");
		String birthday = req.getParameter("birthday");
		System.out.println("username--->" + username);
		
		User user = new User();
		user.setName(username);
		user.setSex(sex);
		user.setHobby(Arrays.toString(hobby));
		user.setDescription(description);
		user.setDept(dept);
		Date d = null;
		if(!StringUtils.isEmpty(birthday)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				d = sdf.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			
		user.setBirthday(d);
		
		UserService userService = new UserServiceImpl();
		userService.register(user);
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>注册成功!</body></html>");
	}
}
