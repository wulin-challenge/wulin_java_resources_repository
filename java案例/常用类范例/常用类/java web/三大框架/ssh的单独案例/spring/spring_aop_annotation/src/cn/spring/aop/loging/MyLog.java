package cn.spring.aop.loging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

@Aspect
public class MyLog implements Ordered{
	
	@Pointcut("execution(* cn.spring.aop.service.impl.*.*(..))")
	public void a(){};
	
	@Before("a()")
	public void addLog(){
		System.out.println("之前添加日志");
	}

	public boolean isLog(){
		System.out.println("改日志已经有了");
		return true;
	}

	public int getOrder() {
		return 1;//这表示优先级的
	}
}
