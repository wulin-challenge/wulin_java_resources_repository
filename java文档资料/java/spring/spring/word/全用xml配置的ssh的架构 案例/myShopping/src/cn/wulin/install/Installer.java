package cn.wulin.install;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.wulin.domain.User;

public class Installer extends HibernateTemplate implements Install{
	

	public void install(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		this.getSession().save(user);
		
	}
	
	public static void main(String[] args) {
		System.out.println("正在执行安装...");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		Install installer = (Install) ac.getBean("installer");
		installer.install();
		
		
		
		System.out.println("安装完毕...");
	}

	//===========set=====get=========
	
	protected Session getSession(){
		return this.getSessionFactory().getCurrentSession();
	}
}
