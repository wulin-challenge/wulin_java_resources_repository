package spring2_5;

public class UserServiceImpl {
	static{
		System.out.println("c");
	}
	private UserDao userDao=BeanFactory.getBeanInstance(UserDao.class);
	static{
		System.out.println("d");
	}
	public UserServiceImpl(){
		System.out.println("f");
		System.out.println("所使用的UserDao="+userDao.getClass());
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
