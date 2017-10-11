package cn.scxh.servlet.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test{
	public static void main(String[] args) {
		Test test=new Test();
		List<User> userList=test.getAllUser();
		Collections.sort(userList,new Comparator<User>(){

			public int compare(User o1, User o2) {
				
				return -o1.getId().compareTo(o2.getId());
			}
			
		});
		for (User user : userList) {
			System.out.println(user.getId());
		}
		
	}
	
	public List<User> getAllUser(){
		List<User> userSet=new ArrayList<User>();
		Random r=new Random();
		for(int i=0;i<10;i++){
			User user=new User();
			user.setId(Long.valueOf(r.nextInt(100)+""));
			user.setName("ÕÅÈý"+r.nextInt(100));
			userSet.add(user);
		}
		return userSet;
	}
}
