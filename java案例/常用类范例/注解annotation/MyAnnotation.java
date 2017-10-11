package cn.itcast.java.annotation;

//自定义注解
public @interface MyAnnotation {
	//属性
	String who();
	int age();
	String gender();
}
