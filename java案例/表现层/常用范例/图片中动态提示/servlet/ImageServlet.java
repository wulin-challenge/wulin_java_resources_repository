package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.itcast.web.ajax.dao.ImageDao;
import cn.itcast.web.ajax.domain.Image;

public class ImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		ImageDao imageDao = new ImageDao();
		Image image = imageDao.findImageById(Integer.parseInt(id));
		//使用第三方工具API将JavaBean对象转换符合Json格式的字符串
		JSONArray jsonArray = JSONArray.fromObject(image);
		String jsonString = jsonArray.toString();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jsonString);
	}
}



