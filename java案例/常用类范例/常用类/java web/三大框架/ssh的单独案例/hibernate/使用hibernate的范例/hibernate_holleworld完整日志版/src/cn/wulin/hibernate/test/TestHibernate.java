package cn.wulin.hibernate.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wulin.hibernate.domain.User;
import cn.wulin.hibernate.util.HibernateUtil;


public class TestHibernate {
	
	@Test
	public void testSave(){
		User user=new User();
		user.setName("¹þ¹þ");
		user.setPassword("1234");
		user.setAge(25);
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpdate(){
		User user=new User();
		user.setId(3l);
		user.setAge(24);
		user.setName("ÎûÎû");
		user.setPassword("4321");
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFind(){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		List<User> userList=session.createQuery("from User").list();
		t.commit();
		session.close();
		for (User user : userList) {
			System.out.println(user.getId()+"  "+user.getName());
		}
		
	}
	
	@Test
	public void testDelete(){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		User user=(User) session.get(User.class,2l);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}
	

}
