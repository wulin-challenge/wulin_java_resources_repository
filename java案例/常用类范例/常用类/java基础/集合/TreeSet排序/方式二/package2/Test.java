package cn.scxh.servlet.package2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test{
	public static void main(String[] args) {
		Test test=new Test();
		Set<User> userSet=test.getAllUser();
		TreeSet<User> treeSet=(TreeSet<User>) userSet;
		treeSet.comparator();
		for (User user : userSet) {
			System.out.println(user.getId());
		}
		
	}
	
	public Set<User> getAllUser(){
	 Set<User> userSet=new TreeSet<User>();
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
