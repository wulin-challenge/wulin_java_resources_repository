package com.bjhy.criminal.search.timer.service;

import java.util.List;
import java.util.Map;

/**
 * 罪犯收押逮捕情况
 * @author wangbowen
 * @date 2015-12-11
 * @version 1.0
 *
 */
public interface CriminalArrestService {
	/**
     * 获取 罪犯收押逮捕情况
     * @return
     */
	public List<Map<String,Object>> getCriminalArrestInfo();
}
