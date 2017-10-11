package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;
@Component
public class CriminalRecordScheduled implements IScheduled {
    
	@Autowired
	@Qualifier("criminalRecordService")
	private Command criminalRecordService;
	@Override
	public void timer() {
		criminalRecordService.analyze();
	}

}
