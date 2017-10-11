package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.FieldsValuesUtils;
import com.bjhy.criminal.search.timer.tool.LoggerUtils;
/**
 * 存储基础数据的实现接口
 * @author wangbowne
 * @date 2015-12-10
 * @version 10
 *
 */
@Transactional
@Service("storeDataService")
public class StoreDataServiceImpl  implements StoreDataService{
	@Autowired
	private PersistConfig persistConfig;
	@Autowired
	@Qualifier("zfjcJdbcTemplate")
	private JdbcTemplate zfjcJdbcTemplate;//省局数据源
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public void saveOrUpdateData(String tableName,List<Map<String, Object>> data) {
				LoggerUtils.info("开始清空"+tableName+"数据......");
		    	zfjcJdbcTemplate.update(FieldsValuesUtils.deleteTemplateSql(tableName));
		    	LoggerUtils.info("清空"+tableName+"数据成功！");
		    	LoggerUtils.info("开始新增"+tableName+"数据,请耐心等待......");
		    	for (Map<String, Object> rowData : data) {
						Map<String, Object> insertfiled =FieldsValuesUtils.getInsertFieldsValues(rowData);
						String fs =  insertfiled.get("fields").toString();
						String mark  = insertfiled.get("mark").toString();
						List<String> valuesStr = (List<String>) insertfiled.get("values");
						String realInsertSql = FieldsValuesUtils.insertTemplateSql(tableName).replace("#[fields]", fs).replace("#[values]", mark);
					   try{
						zfjcJdbcTemplate.update(realInsertSql, valuesStr.toArray());
						}catch(Exception e){
							LoggerUtils.debug("插入表"+tableName+"第"+data.size()+"条数据有错误"+e.getMessage());
						}
					}
				    LoggerUtils.info("新增"+tableName+"数据"+data.size()+"条");
			}
		
	
}
