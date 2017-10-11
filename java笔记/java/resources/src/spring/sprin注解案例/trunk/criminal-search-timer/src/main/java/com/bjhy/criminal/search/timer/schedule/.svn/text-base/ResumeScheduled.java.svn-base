package com.bjhy.criminal.search.timer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.command.Command;
/**
 * 罪犯简历定时器
 * @author wangbowen
 *
 */
@Component
public class ResumeScheduled  implements IScheduled  {
	@Autowired
	@Qualifier("resumeService")
	private Command resumeService;
	@Override
	public void timer() {
		resumeService.analyze();
	}

}
