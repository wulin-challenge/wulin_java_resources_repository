package com.bjhy.platform.test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("44");
		list.add("55");
		MyHelper.startFor(list,new BaseHelper(){
			public void getValue(String s) {
				System.out.println("---"+s);
			}

		});
	}

}
