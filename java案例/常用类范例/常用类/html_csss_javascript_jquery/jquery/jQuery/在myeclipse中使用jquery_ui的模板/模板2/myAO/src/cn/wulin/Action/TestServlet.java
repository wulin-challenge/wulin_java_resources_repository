package cn.wulin.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String judge=request.getParameter("judge");
		if("left".equals(judge)){
			request.getRequestDispatcher("/WEB-INF/jsp/primary/common/left.jsp").forward(request, response);
		}else if("secondPanel".equals(judge)){
			request.setAttribute("test", "xxxxxxxxxxxxxxxxxxx");
			request.getRequestDispatcher("/haha.jsp").forward(request, response);
		}
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
