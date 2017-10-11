package com.bjhy.criminal.search.timer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.base.BaseHelper;
import com.bjhy.criminal.search.timer.base.BaseRunnable;
import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.domain.DataSourceAndTemplate;
import com.bjhy.criminal.search.timer.domain.Helper;
import com.bjhy.criminal.search.timer.domain.JcsjJdbcTemplate;
import com.bjhy.criminal.search.timer.service.MyTestService;

@Service(value="myTestServiceImpl")
public class MyTestServiceImpl implements Command,MyTestService{

	@Autowired
	@Qualifier("yzJdbcTemplateList")
	private DataSourceAndTemplate yzJdbcTemplateList;
	
	@Autowired
	@Qualifier("jcsjJdbcTemplateList")
	private DataSourceAndTemplate jcsjJdbcTemplateList;
	
	
	public void analyze() {
		List<JcsjJdbcTemplate> jdbcTemplateList = yzJdbcTemplateList.getJcsjJdbcTemplateList();
		final JcsjJdbcTemplate toTemplate = jcsjJdbcTemplateList.getJcsjJdbcTemplateList().get(0);
		for (final JcsjJdbcTemplate jdbcTemplate : jdbcTemplateList) {
			BaseHelper.startRun(new BaseRunnable(){
				public void run() {
					//...
				}
			});
		}
	}

	public void transfort() {
		
	}

	public void test() {
		List<JcsjJdbcTemplate> jdbcTemplateList = yzJdbcTemplateList.getJcsjJdbcTemplateList();
		for (JcsjJdbcTemplate jdbcTemplate : jdbcTemplateList) {
			List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from T_USER");
			for (Map<String, Object> map : list) {
				Set<Entry<String, Object>> entrySet = map.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					System.out.println(entry.getKey()+" : "+entry.getValue());
				}
			}
			System.out.println(jdbcTemplate.getConnectConfig().getHttpUrl());
			System.out.println(jdbcTemplate.getConnectConfig().getPrisonName());
			System.out.println(jdbcTemplate.getConnectConfig().getPrisonNumber());
			System.out.println("========================");
		}
	}
	
	public void test2() {
		List<JcsjJdbcTemplate> jdbcTemplateList = yzJdbcTemplateList.getJcsjJdbcTemplateList();
		final JcsjJdbcTemplate toTemplate = jcsjJdbcTemplateList.getJcsjJdbcTemplateList().get(0);
		for (final JcsjJdbcTemplate jdbcTemplate : jdbcTemplateList) {
			BaseHelper.startRun(new BaseRunnable(){
				public void run() {
					long l1= System.currentTimeMillis();
					System.out.println("正在同步中...");
					String fromSql = "select * from testSynchronization2";
					//String fromSql = "select USERNAME,AGE,GENDER,PASSWORD,WORDFILE,INSERTDATE from testSynchronization";
					//BaseHelper.dataSyn(jdbcTemplate, toTemplate, "T_USER2", fromSql);
					//BaseHelper.dataSyn(jdbcTemplate, toTemplate, "testSynchronization4", fromSql);
					//BaseHelper.dataSynDeleteByJybh(jdbcTemplate, toTemplate, "T_USER3", fromSql);
					//BaseHelper.dataSynDeleteByJybh(jdbcTemplate, toTemplate, "testSynchronization3", fromSql);
					//BaseHelper.dataSynByPrimaryKeyId(jdbcTemplate, toTemplate, "testSynchronization4", "id", fromSql);
					List<String> list = new ArrayList<String>();
					list.add("id");
//					BaseHelper.dataSynByToColumnList(jdbcTemplate, toTemplate, "testSynchronization4", list, fromSql);
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("jybh", "11023");
					map.put("jymc", "第二监狱3");
					BaseHelper.dataSynByToColumnMap(jdbcTemplate, toTemplate, "testSynchronization3", list,map, fromSql);
					////////////////////////////////////////////////////
//					Helper helper = new Helper();
//					helper.setFromSql(fromSql);
//					helper.setFromTemplate(jdbcTemplate);
//					helper.setToTemplate(toTemplate);
//					//helper.setToPrimaryKeyId("id");
//					helper.setToTableName("testSynchronization3");
//					helper.setUpdateMode(Helper.TO_UPDATE);
//					Map<String,Object> map = new HashMap<String,Object>();
//					map.put("jybh", "11023");
//					map.put("jymc", "第二监狱3");
//					helper.getToColumnMap().putAll(map);
//					BaseHelper.dataSynByHelper(helper);
//////				//////////////////////////////////////////////
					long l2= System.currentTimeMillis();
					System.out.println((l2-l1)/1000+"秒");
					System.out.println((l2-l1)/60000+"分钟");
				}
			});
		}
	}
	
	public void test3() {
		List<JcsjJdbcTemplate> jdbcTemplateList = yzJdbcTemplateList.getJcsjJdbcTemplateList();
		final JcsjJdbcTemplate toTemplate = jcsjJdbcTemplateList.getJcsjJdbcTemplateList().get(0);
		for (final JcsjJdbcTemplate jdbcTemplate : jdbcTemplateList) {
			BaseHelper.startRun(new BaseRunnable(){
				public void run() {
					long l1= System.currentTimeMillis();
					System.out.println("正在同步中...");
					String sql = "";
					String insertSql = "INSERT INTO testSynchronization2(";
					String values = " VALUES(";
					List<Object> params = new ArrayList<Object>();
					boolean isFirst = true;
					String fromSql = "select USERNAME,AGE,GENDER,PASSWORD,WORDFILE,INSERTDATE from testSynchronization";
					List<Map<String,Object>> listMap = jdbcTemplate.queryForList(fromSql);
					Map<String,Object> map = listMap.get(0);
					Set<Entry<String,Object>> entrySet = map.entrySet();
					
					for (Entry<String,Object> entry : entrySet) {
						if(isFirst){
							insertSql +=entry.getKey();
							values +="?";
							params.add(entry.getValue());
							isFirst = false;
						}else{
							insertSql +=","+entry.getKey();
							values +=",?";
							params.add(entry.getValue());
						}
					}
					insertSql +=",ID)";
					values +=",?)";
					sql = insertSql+values;
					for(int i=21;i<1000;i++){
						List<Object> params2 = new ArrayList<Object>(params);
						params2.add(i);
						System.out.println(sql);
						System.out.println(params2);
						toTemplate.update(sql, params2.toArray());
					}
					long l2= System.currentTimeMillis();
					System.out.println((l2-l1)/1000+"秒");
					System.out.println((l2-l1)/60000+"分钟");
				}
			});
		}
	}
	

}
