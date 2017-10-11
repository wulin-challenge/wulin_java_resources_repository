package cn.wulin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import cn.wulin.domain.User;
import cn.wulin.util.UserComparator;

public class UserController {
	
	/**
	 * 将userList中值打印出来
	 */
	@Test
	public void printUserList(){
		List<User> userList = this.userSort();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * 得到排序后的userList
	 * @return
	 */
	private List<User> userSort(){
		List<User> userList = this.getUserList();
		Collections.sort(userList, new UserComparator());
		return userList;
	}
	
	/**
	 * 得到user的list
	 * @return
	 */
	private List<User> getUserList(){
		List<User> userList = new ArrayList<User>();
		User user1 = new User("wulin1",23);
		User user2 = new User("wulin2",11);
		User user3 = new User("wulin3",33);
		User user4 = new User("wulin4",22);
		User user5 = new User("wulin5",23);
		User user6 = new User("wulin6",44);
		User user7 = new User("wulin7",54);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		return userList;
	}

}
