package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;
@Component
public class RewardScheduled implements IScheduled {
    
	@Autowired
	@Qualifier("rewardService")
	private Command rewardService;
	@Override
	public void timer() {
		rewardService.analyze();
	}

}
