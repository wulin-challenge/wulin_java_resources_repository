package com.xaccp.service;

import com.xaccp.domain.Person;

public interface Ihello {
	public String sayHello(String name);
	public String sayThanks(String name);
	public Person getPerson(String id,String name);
	public void getPerson(Person person);
}
