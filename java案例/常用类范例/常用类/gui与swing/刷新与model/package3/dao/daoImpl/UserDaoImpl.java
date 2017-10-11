package package3.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import package3.dao.UserDao;
import package3.domain.User;

public class UserDaoImpl implements UserDao{
	
	List<User> userList=new ArrayList<User>();
	@Override
	public List<User> findAll() {
		for (int i = 0; i < 10; i++) {
			User user=new User();
			user.setAge(i+20+"");
			user.setGender("Å®");
			user.setName("haha"+i);
			user.setId(i);
			userList.add(user);
		}
		return userList;
	}
	public List<User> findAll1() {
		for (int i = 0; i < 36; i++) {
			User user=new User();
			user.setAge(i+20+"");
			user.setGender("ÄÐ");
			user.setName("¹þ¹þ"+i);
			user.setId(i);
			userList.add(user);
		}
		return userList;
	}

}
