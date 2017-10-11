package cn.wulin.timer;

import java.util.Timer;
import cn.wulin.dao.impl.UserDaoImpl;

public class MyTimer {
	public static void main(String[] args) {
		final UserDaoImpl u=new UserDaoImpl();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyTask(), 1, 1000);
	}
}