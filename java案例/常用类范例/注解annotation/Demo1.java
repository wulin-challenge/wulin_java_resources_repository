package cn.itcast.java.annotation;

import java.util.ArrayList;
import java.util.List;

//演示JDK中三个基本的注解(Annotation)


@SuppressWarnings("unchecked")
public class Demo1 {
	
	@SuppressWarnings("unchecked")
	private String name;
	
	@Override
	public String toString(){
		return "1234";
	} 

	@Deprecated
	public void run(){
		System.out.println("Demo1::run()");
	}
	
	@SuppressWarnings("unchecked")
	public void show(){
		List list = new ArrayList();
	}
	
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		demo.run();
	}
}
