package cn.wulin.listener.impl;

import java.util.EventObject;

public class LocationEvent extends EventObject{

	private static final long serialVersionUID = 1L;

	private Object obj;
	
	public LocationEvent(Object source) {
		super(source);
		obj=source;
	}

	public Object getObj() {
		return obj;
	}

}
