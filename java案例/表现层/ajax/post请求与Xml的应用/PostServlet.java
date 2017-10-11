package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("PostServlet::doPost()");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println("ÓÃ»§Ãû£º" + username);
		String msg = null;
		if(username.equals("ÕÔ¾ý")){
			msg = "images/MsgError.gif";
		}else{
			msg = "images/MsgSent.gif";
		}
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write("<root>");
			pw.write("<res>");
				pw.write(msg);
			pw.write("</res>");
		pw.write("</root>");
	}
}
