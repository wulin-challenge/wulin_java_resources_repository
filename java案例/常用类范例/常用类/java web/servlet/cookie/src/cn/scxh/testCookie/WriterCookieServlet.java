package cn.scxh.testCookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriterCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		
		Cookie[] cookies = req.getCookies();
		boolean flag = false;
		if(cookies != null && cookies.length>0){
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())){
					String value = cookie.getValue();
					String[] sv = value.split("-");
					sv[1] = (Integer.parseInt(sv[1]))+1+"";
					cookie.setValue(sv[0]+"-"+sv[1]);
					resp.addCookie(cookie);
					flag = true;
				}
			}
		}
		if(!flag){
			Cookie cookie = new Cookie(name,price+"-"+1);
			cookie.setMaxAge(3600);
			resp.addCookie(cookie);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
