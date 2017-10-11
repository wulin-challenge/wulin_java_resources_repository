package cn.wulin.timer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import cn.wulin.dao.UserDao;
import cn.wulin.dao.impl.UserDaoImpl;
import cn.wulin.domain.User;

public class MyTask extends TimerTask{
	private Date previouslyMax=null;
	public void run() {
		judgeMysql();
	}
	
	public void judgeMysql(){
		UserDao userDao = new UserDaoImpl();
		List<User> userList = new ArrayList<User>();
		try {
			Date date=userDao.getNewTimeMysql();
			if(previouslyMax==null){
				previouslyMax=date;
				userList = userDao.findUser1(previouslyMax);
				printValue(userList, "mysql");
				userList = userDao.findUser();
				printValue(userList, "oracle");
				System.out.println(date);
			}
			if(previouslyMax.getTime()!=date.getTime()){
				userList = userDao.findUser1(previouslyMax);
				printValue(userList, "mysql");
				userList = userDao.findUser();
				printValue(userList, "oracle");
				previouslyMax=date;
				System.out.println(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printValue(List<User> userList,String flag){
		for (User user : userList) {
			System.out.println("我是"+flag+" : "+user.getPassword());
		}
	}
	
	/**将日期存储到文件中*/
	public void getDateFromFile(Long dateFile) throws Exception{
		File file = new File("./newDate.txt");
		String dateString = dateFile.toString();
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
		dos.writeUTF(dateString);
	}
	
	/**从文件中读取内容*/
	public Long setDateToFile() throws Exception{
		File file = new File("./newDate.txt");
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		String dateString=dis.readUTF();
		Long dateLong = new Long(dateString);
		return dateLong;
	}

}
