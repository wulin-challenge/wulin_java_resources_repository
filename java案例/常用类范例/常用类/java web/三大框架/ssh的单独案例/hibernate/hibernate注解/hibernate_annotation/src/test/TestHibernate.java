package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import domain.Person;


public class TestHibernate {
	
	@Test
	public void testSave(){
		Person person=new Person();
		person.setId(1);
		person.setName("¹þ¹þ");
		person.setPassword("1234");
		person.setAge(25);
		
		Configuration cfg=new AnnotationConfiguration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
	}

}
