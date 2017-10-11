package cn.itcast.java.annotation;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
	String username() default "jack";
	String password() default "123456";
}
