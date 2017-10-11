package com.bjhy.platform.test;

import java.util.List;

public class MyHelper {

	public static void startFor(List<String> list,final BaseHelper basehelper){
		for (final String s : list) {
			startRun(new BaseRunnable(){
				public void run() {
					basehelper.getValue(s);
				}
			});
		}
	}
	
	public static void startRun(BaseRunnable br){
		Thread thread = new Thread(br);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
