package com.bjhy.criminal.search.timer.service;

import java.util.List;
import java.util.Map;

/**
 * 罪犯体貌特征接口
 * @author wangbowen
 * @date 2015-12-11
 * @version 1.0
 *
 */
public interface PhysicalCharacterService {
	/**
     * 罪犯体貌特征
     * @return
     */
	public List<Map<String,Object>> getPhysicalCharacterInfo();
}