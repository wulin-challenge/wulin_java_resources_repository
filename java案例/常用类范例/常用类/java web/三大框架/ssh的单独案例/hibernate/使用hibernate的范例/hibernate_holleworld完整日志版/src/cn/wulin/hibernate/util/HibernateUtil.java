package cn.wulin.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory factory;
	
	static{
		try {
			factory=new Configuration().configure().buildSessionFactory();
		} catch (Throwable  e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	

}
