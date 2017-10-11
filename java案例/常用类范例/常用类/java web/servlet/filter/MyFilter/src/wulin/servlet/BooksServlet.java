package wulin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BooksServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String judge=request.getParameter("judge");
		System.out.println("haha");
		if(judge.equals("login")){
			request.getRequestDispatcher("/WEB-INF/jsp/goods/books.jsp").forward(request, response);
		}
		
	}

}
