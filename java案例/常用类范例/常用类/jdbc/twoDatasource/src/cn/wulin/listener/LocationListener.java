package cn.wulin.listener;

import java.util.EventListener;

import cn.wulin.listener.impl.LocationEvent;

public interface LocationListener extends EventListener{

	public void locationEvent(LocationEvent le);
}
