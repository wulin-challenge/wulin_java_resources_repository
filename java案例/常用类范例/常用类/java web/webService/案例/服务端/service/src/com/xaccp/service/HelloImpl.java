package com.xaccp.service;

import com.xaccp.domain.Person;

public class HelloImpl implements Ihello {

	public String sayHello(String name) {
		
		return "Hello"+name;
	}

	public String sayThanks(String name) {
		return " Thanks "+name;
	}

	public Person getPerson(String id, String name) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		return person;
	}

	public void getPerson(Person person) {
		System.out.println("这是我的Id和名称:"+person.getId()+","+person.getName());
	}
	
	
	
}