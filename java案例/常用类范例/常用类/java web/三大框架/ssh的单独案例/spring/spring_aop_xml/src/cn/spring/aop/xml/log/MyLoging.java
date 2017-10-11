package cn.spring.aop.xml.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyLoging {
	
	public void addLoging(){
		System.out.println("我添加的日志");
	}

	public void editLoging(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("我修改之前的日志");
		System.out.println(pjp.getArgs().length);
		pjp.proceed();
		System.out.println("我修改之后的日志");
		
	}
}
