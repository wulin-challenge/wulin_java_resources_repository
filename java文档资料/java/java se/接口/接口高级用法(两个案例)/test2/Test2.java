package com.bjhy.platform.test2;

import java.util.UUID;

public class Test2 {
	
	public static void main(String[] args) {
		Field field= new Test2().getField();
		field.triggerEvent();
		field.triggerEvent();
	}
	
	public Field getField(){
		Field field = new Field();
		field.setColumn("Id");
		field.setValue("1");
		field.autoDefineValue(new AutoDefine(){
			public Object define(String column, Object value) {
				System.out.println(column+" : "+value);
				System.out.println(UUID.randomUUID().toString());
				return "2";
			}
		});
		return field;
	}

}
