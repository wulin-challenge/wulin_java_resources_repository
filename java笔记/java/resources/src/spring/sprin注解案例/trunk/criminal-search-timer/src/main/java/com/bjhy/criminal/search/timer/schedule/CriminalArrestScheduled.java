package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;
@Component
public class CriminalArrestScheduled implements IScheduled {
    
	@Autowired
	@Qualifier("criminalArrestService")
	private Command criminalArrestService;
	@Override
	public void timer() {
		criminalArrestService.analyze();
	}

}