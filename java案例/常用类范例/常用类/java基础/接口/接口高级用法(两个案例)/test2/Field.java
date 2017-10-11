package com.bjhy.platform.test2;

public class Field {
	private String column;
	private Object value;
	private AutoDefine autoDefine;
	public void autoDefineValue(AutoDefine autoDefine){
		this.autoDefine = autoDefine;
	}
	
	public void triggerEvent(){
		this.value = this.autoDefine.define(column, value);
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
