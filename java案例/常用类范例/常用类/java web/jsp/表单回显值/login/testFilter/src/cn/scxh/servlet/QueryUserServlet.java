package cn.scxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.scxh.model.User;
import cn.scxh.service.impl.UserServiceImpl;
import cn.scxh.service.intf.UserService;
import cn.scxh.util.ConstantConver;

public class QueryUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		User user = new User();
		if(id == null || "".equals(id)){
			user.setId(0);
		}else{
			user.setId(Integer.parseInt(id));
		}
		user.setName(name);
		
		UserService userService = new UserServiceImpl();
		List<User> users = userService.getUsers(user);
		req.setAttribute("users", users);
		req.setAttribute("user", user);
		
		
		//resp.sendRedirect("query.jsp");
		
		req.getRequestDispatcher("query.jsp").forward(req, resp);
		
	}
}
