package cn.itcast.java.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DbInfo {
	String driver() default "com.mysql.jdbc.Driver";
	String url() default "jdbc:mysql://localhost:3306/bbs";;
	String usrename() default "root";
	String password() default "root";
}
