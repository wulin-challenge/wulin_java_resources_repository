package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;
@Component
public class PhysicalCharacterScheduled implements IScheduled {
    
	@Autowired
	@Qualifier("physicalCharacterService")
	private Command physicalCharacterService;
	@Override
	public void timer() {
		physicalCharacterService.analyze();
	}

}
