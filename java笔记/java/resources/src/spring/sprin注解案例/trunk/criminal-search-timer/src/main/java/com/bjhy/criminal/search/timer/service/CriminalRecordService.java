package com.bjhy.criminal.search.timer.service;

import java.util.List;
import java.util.Map;

/**
 * 罪犯前科信息接口
 * @author wangbowen
 * @date 2015-12-11
 * @version 1.0
 *
 */
public interface CriminalRecordService {

	/**
     * 获取罪犯前科信息
     * @return
     */
	public List<Map<String,Object>> getCriminalRecordInfo();
}
