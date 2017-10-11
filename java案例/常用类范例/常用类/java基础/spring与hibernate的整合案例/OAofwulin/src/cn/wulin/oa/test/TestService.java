package cn.wulin.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wulin.oa.domain.User;

@Service("testService")
@Transactional
public class TestService {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void savaTwoUsers(){
		Session session = sessionFactory.getCurrentSession();
		session.save(new User());
		//int a = 1/0;//这行会抛出异常
		session.save(new User());
	}
}



























