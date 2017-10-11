package cn.scxh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.scxh.model.User;
import cn.scxh.service.impl.UserServiceImpl;
import cn.scxh.service.intf.UserService;

public class PreUpdateUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		UserService userService = new UserServiceImpl();
		User user = userService.getUser(id);
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
}
