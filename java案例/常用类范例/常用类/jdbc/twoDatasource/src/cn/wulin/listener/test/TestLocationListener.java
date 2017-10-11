package cn.wulin.listener.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.wulin.listener.LocationListener;
import cn.wulin.listener.impl.LocationEvent;
import cn.wulin.listener.service.impl.LocationService;

public class TestLocationListener implements LocationListener {

	private LocationService ls;

	public TestLocationListener() {
		ls = new LocationService();
		ls.addLocationListener(this); // 注册监听
		System.out.println("添加监听器完毕");
		try {
			// 调用此方法触发事件,触发的事件就是执行locationEvent(接口的方法)的方法
			ls
					.addLocation("insert into t_user (id,name,password) values(68,67,67)");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void locationEvent(LocationEvent le) {
		ScheduledExecutorService executor = Executors
				.newSingleThreadScheduledExecutor();
		executor.scheduleWithFixedDelay(new Runnable(){

			public void run() {
				System.out.println("hhhhhhhhhhhhhhhhhhhhh");
			}
			
		}, 0, 2,
				TimeUnit.SECONDS);
	}

}
