package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;

/**
 * 社会关系定时器
 * @author wangbowen
 *
 */
@Component
public class SocietyRelationshipScheduled implements IScheduled {
	@Autowired
	@Qualifier("societyRelationship")
	private Command societyRelationship;
	@Override
	public void timer() {
		societyRelationship.analyze();
	}


}
