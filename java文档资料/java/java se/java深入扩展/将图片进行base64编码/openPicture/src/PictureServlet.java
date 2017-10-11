import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PictureServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.getRequestDispatcher("/image/IMG_0073.JPG").forward(request, response);//方式一
		//response.sendRedirect("/image/IMG_0073.JPG");//方式2
		response.getWriter().write("<img src=\"http://localhost:8080/openPicture/image/IMG_0073.JPG\"/>");//方式3
	}

}
