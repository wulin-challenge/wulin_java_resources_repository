package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;

@Component
public class CriminalBaseInfoScheduled implements IScheduled {
    
	@Autowired
	@Qualifier("criminalBaseInfo")
	private Command criminalBaseInfo;
	@Override
	public void timer() {
		criminalBaseInfo.analyze();
	}

}
