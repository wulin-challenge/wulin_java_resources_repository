package cn.itcast.java.annotation;

public @interface YouAnnotation {
	String who() default "marry";
	int age() default 22;
	String gender() default "female";
}
