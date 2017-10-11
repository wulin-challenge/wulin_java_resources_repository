package cn.wulin.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.wulin.hibernate.domain.User;


public class TestHibernate {
	
	@Test
	public void testSave(){
		User user=new User();
		user.setName("¹þ¹þ");
		user.setPassword("1234");
		user.setAge(25);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
