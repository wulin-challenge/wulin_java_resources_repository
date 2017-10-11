package com.bjhy.criminal.search.timer.service;

import java.util.List;
import java.util.Map;

/**
 * 罪犯奖励情况接口
 * @author wangbowen
 * @date 2015-12-11
 * @version 1.0
 *
 */
public interface RewardService {
	/**
     * * 罪犯奖励情况
     * @return
     */
	public List<Map<String,Object>> getCriminalRewardInfo();
}
