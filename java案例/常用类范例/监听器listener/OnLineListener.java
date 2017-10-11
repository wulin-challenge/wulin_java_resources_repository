package cn.itcast.bbs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import cn.itcast.bbs.domain.User;

public class OnLineListener implements HttpSessionAttributeListener,ServletRequestListener {
	public void attributeAdded(HttpSessionBindingEvent se) {
		String name = se.getName();//name="user"字符串
		Object obj =  se.getValue();//value=user对象
		if(obj instanceof User){
			//确实是向HttpSession中绑定是的user对象
			if("user".equals(name)){
				HttpSession session = se.getSession();
				ServletContext context = session.getServletContext();
				Integer online = (Integer) context.getAttribute("online");
				if(online==null){
					online = 1;
				}else{
					online ++;
				}
				//在线人数  online:在线人数
				context.setAttribute("online",online);
				Integer caller = (Integer) context.getAttribute("caller");  //caller:第几个访问者
				if(caller==null){
					caller = 1;
				}else{
					caller ++;
				}
				//访问次序
				context.setAttribute("caller",caller);//可变
				session.setAttribute("caller",caller);//不变
			}
		}
	}
	public void attributeRemoved(HttpSessionBindingEvent se) {
		String name = se.getName();//name="user"字符串
		//确实是向HttpSession中绑定是的user对象
		if("user".equals(name)){
			HttpSession session = se.getSession();
			ServletContext context = session.getServletContext();
			Integer online = (Integer) context.getAttribute("online");
			online --;
			context.setAttribute("online",online);
		}
	}
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}
	public void requestDestroyed(ServletRequestEvent sre) {
	}
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		HttpSession session = request.getSession();
		if(session.isNew()){
			//打开浏览器所产生的session如果没有经过isNew()方法判断过,就是新的session,
			//一旦经过isNew()方法判断过了,就是就是旧的session
			ServletContext context = sre.getServletContext();
			Integer todayFlow = (Integer) context.getAttribute("todayFlow");
			if(todayFlow==null){
				todayFlow = 1;
			}else{
				todayFlow ++;
			}
			//将今日流量绑定到ServletContext对象中
			context.setAttribute("todayFlow",todayFlow);
		}else{
			;
		}
	}
}








