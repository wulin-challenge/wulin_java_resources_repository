package cn.itcast.bbs.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import cn.itcast.bbs.domain.User;

public class SessionScannerListener implements HttpSessionListener,ServletContextListener {
	private Timer timer = new Timer();
	private List<HttpSession> sessionList = new ArrayList<HttpSession>();
	//实例变量只创建一次
	public SessionScannerListener(){
		sessionList = Collections.synchronizedList(sessionList);
	}
	public void sessionCreated(HttpSessionEvent se) {
		//取得该用户的HttpSession
		HttpSession session = se.getSession();
		synchronized (sessionList) {
			sessionList.add(session);
		}
	}
	public void sessionDestroyed(HttpSessionEvent se) {
	}
	public void contextDestroyed(ServletContextEvent sce) {
	}
	public void contextInitialized(ServletContextEvent sce) {
		timer.schedule(new MyTimerTask(sessionList),0,1*1000);
	}
}
class MyTimerTask extends TimerTask{
	private List<HttpSession> sessionList;
	public MyTimerTask(List<HttpSession> sessionList) {
		this.sessionList = sessionList;
	}
	public void run() {
		//当有HttpSession存在时，再迭代
		int i=1;
		System.out.println("run()"+i);
				i++;
		if(sessionList.size()>0){
			ListIterator<HttpSession> it = sessionList.listIterator();
			synchronized (sessionList) {
				while (it.hasNext()) {
					HttpSession session = it.next();
					User user = (User) session.getAttribute("user");
					//用户未按"安全退出"
					if(user!=null){
						int mid = (int) ((System.currentTimeMillis()-session.getLastAccessedTime())/1000);
						if(mid > 10){
							//将该HttpSession从集合中删除
							it.remove();
							//取得在线用户列表
							List<String> usernameList = (List<String>) session.getServletContext().getAttribute("usernameList");
							//取得用户名
							String username = user.getUsername();
							//从列表中删除该用户名
							usernameList.remove(username);
							//销毁当前用户的HttpSession
							session.removeAttribute("user");
							int j=1;
							System.out.println("exit()"+j);
							j++;
						}
					}else{
						//用户已按"安全退出"
					}
				}
			}
		}
	}
}




