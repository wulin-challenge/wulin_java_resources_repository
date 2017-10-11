package org.tempuri;


public enum SexEnum {
	/**
	 * M=1	男
	 */
	M("男",1),
	/**
	 * W=2	女
	 */
	W("女",2);
	
	private String name;
	private int index;
	
	private SexEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	/**
	 * 得到名称
	 * @param index
	 * @return
	 */
	public static String getName(int index){ //重构getName方法
		for (SexEnum sf : SexEnum.values()) {
			if(sf.getIndex() == index){
				return sf.name;
			}
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}