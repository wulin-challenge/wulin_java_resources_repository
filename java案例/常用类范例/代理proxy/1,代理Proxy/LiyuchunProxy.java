package cn.itcast.java.proxy.exe2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class LiyuchunProxy{ 
	
	//代理谁，通过构造方法赋值
	private Liyuchun liyuchun = new Liyuchun();
	
	//动态产生代理对象
	public Star getProxy(){
		return (Star) Proxy.newProxyInstance(
				LiyuchunProxy.class.getClassLoader(), 
				liyuchun.getClass().getInterfaces(), 
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						String money = (String) args[0];
						if("sing".equals(method.getName())){
							if("3".equals(money)){
								//调用春哥的sing()方法
								return method.invoke(liyuchun,args);//这里返回值是真正方法public void sing(String money){}
								//的返回值,这个方法没有返回值,所以不返回任何值.如果该方法是public String sing(String money
								//则return method.invoke(liyuchun,args);这句话的返回值就是String类型
							}else{
								System.out.println("不够出场费");	
							}
						}else if("dance".equals(method.getName())){
							if("5".equals(money)){
								return method.invoke(liyuchun,args);
							}else{
								System.out.println("不够出场费");	
							}
						}else if("eat".equals(method.getName())){
							System.out.println("春哥今天有事，不能来");
						}
						return null;
					}
				});
	}
}
//参数一：loader表示动态代理对象是由哪个类加载器完成的
//参数二：interfaces表示动态代理对象与目标对象（春哥）有一样的方法
//参数三：表示动态代理对象的栏截方法，即每次调用目标对象都会执行该invoke()方法(难点)


//invoke()方法的三个参数含义如下
//参数一：动态产生的代理对象本身
//参数二：method表示方法
//参数三：args表示方法参数
