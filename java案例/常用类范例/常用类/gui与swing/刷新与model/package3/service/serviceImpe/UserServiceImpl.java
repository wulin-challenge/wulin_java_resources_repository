package package3.service.serviceImpe;

import java.util.List;

import package3.dao.UserDao;
import package3.dao.daoImpl.UserDaoImpl;
import package3.domain.User;
import package3.domain.UserString;
import package3.service.UserService;

public class UserServiceImpl implements UserService{

	private String[] string1=new String[]{"编号","姓名","性别","年龄"};
	public UserString findAll() {
		List<User> userList=null;
		UserString userString=new UserString();
		UserDao userDao=new UserDaoImpl();
		userList=userDao.findAll();
		String[][] string2=new String[userList.size()][string1.length];
		int i=0;
		for (User user : userList) {
			
			string2[i][0]=""+user.getId();
			string2[i][1]=user.getName();
			string2[i][2]=user.getGender();
			string2[i][3]=user.getAge();
			i++;
		}
		userString.setString1(string1);
		userString.setString2(string2);
		
		return userString;
	}

	@Override
	public UserString findAll1() {
		List<User> userList=null;
		UserString userString=new UserString();
		UserDao userDao=new UserDaoImpl();
		userList=userDao.findAll1();
		String[][] string2=new String[userList.size()][string1.length];
		int i=0;
		for (User user : userList) {
			
			string2[i][0]=""+user.getId();
			string2[i][1]=user.getName();
			string2[i][2]=user.getGender();
			string2[i][3]=user.getAge();
			i++;
		}
		userString.setString1(string1);
		userString.setString2(string2);
		
		return userString;

	}

}
