package cn.spring.aop.service.impl;

import cn.spring.aop.service.UserService;

public class UserServiceImpl implements UserService{

	public void addUser() {
		System.out.println("正在添加用户");
	}

	public void editUser() {
		System.out.println("正在修改用户");
	}

}
