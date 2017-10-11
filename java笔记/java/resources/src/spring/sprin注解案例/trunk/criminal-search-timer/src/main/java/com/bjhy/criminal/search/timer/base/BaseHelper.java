package com.bjhy.criminal.search.timer.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.bjhy.criminal.search.timer.domain.Helper;
import com.bjhy.criminal.search.timer.domain.JcsjJdbcTemplate;

/**
 * 同步工具类
 * @author 吴波
 *
 */
public class BaseHelper {
	
	/**
	 * 该方法提供了非常灵活的配置,这些配置信息如何使用请看Helper的实体说明
	 * 但是当使用使用PrimaryKeyId属性后必须注意自定义的列中不能在包含主键列
	 * 在用dataSyn或dataSynDeleteByJybh可以完成的情况下,不推荐使用该方法
	 * @param helper 同步帮助实体
	 */
	public static void dataSynByHelper(Helper helper){
		if(StringUtils.isEmpty(helper.getToPrimaryKeyId()) && (helper.getToColumnList().isEmpty())){
			System.err.println("primaryKeyId 属性与toColumnList 属性不能同时为空!!");
			System.err.println("监狱名称:"+helper.getFromTemplate().getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+helper.getFromTemplate().getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+helper.getToTableName()+
					" 时 [同步失败] !!");
			return;
		}
		try {
			new BaseHelper().setDataListParams(helper);
			System.out.println("监狱名称:"+helper.getFromTemplate().getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+helper.getFromTemplate().getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+helper.getToTableName()+
					" 时 [同步成功] !!");
		} catch (Exception e) {
			System.err.println("监狱名称:"+helper.getFromTemplate().getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+helper.getFromTemplate().getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+helper.getToTableName()+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据同步的静态方法,该方法提供使用自定义列进行更新数据的能力,
	 * 但是相比较dataSyn与dataSynDeleteByJybh,这个方法的性能要低很多,
	 * 在用dataSyn或dataSynDeleteByJybh可以完成的情况下,不推荐使用该方法
	 * @param fromTemplate 数据来源的JdbcTemplate
	 * @param toTemplate 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 * @param toTableName 将数据同步到那张表,目标表
	 * @param toColumnMap 将数据同步到目标表,额外增加的列与值,
	 * @param fromSql 数据来源的sql
	 */
	public static void dataSynByToColumnMap(JcsjJdbcTemplate fromTemplate,JcsjJdbcTemplate toTemplate,String toTableName,List<String> toColumnList,Map<String,Object> toColumnMap,String fromSql){
		Helper helper = new Helper();
		helper.setFromTemplate(fromTemplate);
		helper.setToTemplate(toTemplate);
		helper.setToTableName(toTableName);
		helper.getToColumnMap().putAll(toColumnMap);
		helper.getToColumnList().addAll(toColumnList);
		helper.setFromSql(fromSql);
		try {
			new BaseHelper().setDataListParams(helper);
			System.out.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步成功] !!");
		} catch (Exception e) {
			System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据同步的静态方法,该方法提供使用自定义列进行更新数据的能力,
	 * 但是相比较dataSyn与dataSynDeleteByJybh,这个方法的性能要低很多,
	 * 在用dataSyn或dataSynDeleteByJybh可以完成的情况下,不推荐使用该方法
	 * @param fromTemplate 数据来源的JdbcTemplate
	 * @param toTemplate 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 * @param toTableName 将数据同步到那张表,目标表
	 * @param toColumnList如何一张表中有唯一列,或者我们需要用某一列或几列进行数据删除时,我们就可以使用该字段,如何 toPrimaryKeyId 这个属性不为null,
	 * 那么该属性将联合 toPrimaryKeyId 一起作为条件使用
	 * @param fromSql 数据来源的sql
	 */
	public static void dataSynByToColumnList(JcsjJdbcTemplate fromTemplate,JcsjJdbcTemplate toTemplate,String toTableName,List<String> toColumnList,String fromSql){
		Helper helper = new Helper();
		helper.setFromTemplate(fromTemplate);
		helper.setToTemplate(toTemplate);
		helper.setToTableName(toTableName);
		
		helper.setFromSql(fromSql);
		try {
			new BaseHelper().setDataListParams(helper);
			System.out.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步成功] !!");
		} catch (Exception e) {
			System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据同步的静态方法,该方法提供使用主键进行更新数据的能力
	 * 但是相比较dataSyn与dataSynDeleteByJybh,这个方法的性能要低很多,
	 * 在用dataSyn或dataSynDeleteByJybh可以完成的情况下,不推荐使用该方法
	 * @param fromTemplate 数据来源的JdbcTemplate
	 * @param toTemplate 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 * @param toTableName 将数据同步到那张表,目标表
	 * @param toPrimaryKeyId 将数据源同步到目标表的主键
	 * @param fromSql 数据来源的sql
	 */
	public static void dataSynByPrimaryKeyId(JcsjJdbcTemplate fromTemplate,JcsjJdbcTemplate toTemplate,String toTableName,String toPrimaryKeyId,String fromSql){
		Helper helper = new Helper();
		helper.setFromTemplate(fromTemplate);
		helper.setToTemplate(toTemplate);
		helper.setToTableName(toTableName);
		helper.setToPrimaryKeyId(toPrimaryKeyId);
		helper.setFromSql(fromSql);
		try {
			new BaseHelper().setDataListParams(helper);
			System.out.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步成功] !!");
		} catch (Exception e) {
			System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据同步的静态方法,该方法不提供清空数据和更新数据的能力
	 * 但是性能是最高的,一般情况下 推荐使用 该方法
	 * @param fromTemplate 数据来源的JdbcTemplate
	 * @param toTemplate 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 * @param toTableName 将数据同步到那张表,目标表
	 * @param fromSql 数据来源的sql
	 */
	public static void dataSyn(JcsjJdbcTemplate fromTemplate,JcsjJdbcTemplate toTemplate,String toTableName,String fromSql){
		List<Map<String,Object>> dataList = fromTemplate.queryForList(fromSql);
		BaseHelper bh = new BaseHelper();
		try {
			bh.update(toTemplate, toTableName, dataList);
			System.out.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步成功] !!");
		} catch (Exception e) {
			System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据同步的静态方法,带监狱名称与监狱编号,使用该方法要求目标数据表一定有varchar2类型的jymc与jybh这两列,而该方法
	 * 提供了使用jybh进行清空数据后在同步数据的能力
	 * 该方法的性能比较高,一般情况下 推荐使用 该方法
	 * @param fromTemplate 数据来源的JdbcTemplate
	 * @param toTemplate 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 * @param toTableName 将数据同步到那张表,目标表
	 * @param fromSql 数据来源的sql
	 */
	public static void dataSynDeleteByJybh(JcsjJdbcTemplate fromTemplate,JcsjJdbcTemplate toTemplate,String toTableName,String fromSql){
		List<Map<String,Object>> dataList = fromTemplate.queryForList(fromSql);
		BaseHelper bh = new BaseHelper();
		try {
			if(StringUtils.isEmpty(fromTemplate.getConnectConfig().getPrisonNumber())){
				System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
						" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
						" , 同步到表  : "+toTableName+
						" 时 [同步失败] !!");
				System.err.println("原因 : 监狱编号为空!!");
			}else{
				String deleteSql = "DELETE FROM "+toTableName+" WHERE jybh=?";
				toTemplate.update(deleteSql, new Object[]{fromTemplate.getConnectConfig().getPrisonNumber()});
				
				bh.update(toTemplate, toTableName, 
						fromTemplate.getConnectConfig().getPrisonName(),
						fromTemplate.getConnectConfig().getPrisonNumber(),
						dataList);
				System.out.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
						" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
						" , 同步到表  : "+toTableName+
						" 时 [同步成功] !!");
			}
		} catch (Exception e) {
			System.err.println("监狱名称:"+fromTemplate.getConnectConfig().getPrisonName()+
					" , 监狱编号 : "+fromTemplate.getConnectConfig().getPrisonNumber()+
					" , 同步到表  : "+toTableName+
					" 时 [同步失败] !!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置dataList参数
	 * @param helper
	 * @throws Exception
	 */
	private void setDataListParams(Helper helper)throws Exception{
		List<Map<String,Object>> dataList = helper.getFromTemplate().queryForList(helper.getFromSql());
		this.update(helper, dataList);
	}
	
	/**
	 * 将数据同步到toTableName中
	 * @param toTemplate
	 * @param toTableName
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	private void update(JcsjJdbcTemplate toTemplate,String toTableName,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> insertList = this.getInsertSqlAndParams(toTableName, dataList);
		for (Map<String, Object> map : insertList) {
			String sql = (String) map.get("sql");
		
			List<Object> params = (List<Object>) map.get("params");
			toTemplate.update(sql, params.toArray());
		}
	}
	
	/**
	 * 将数据同步到toTableName中,带监狱名称与监狱编号
	 * @param toTemplate
	 * @param toTableName
	 * @param dataList
	 */
	@SuppressWarnings({ "unchecked"})
	private void update(JcsjJdbcTemplate toTemplate,String toTableName,String jymc,String jybh,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> insertList = this.getInsertSqlAndParams(toTableName,jymc,jybh,dataList);
		for (Map<String, Object> map : insertList) {
			String sql = (String) map.get("sql");
			List<Object> params = (List<Object>) map.get("params");
			toTemplate.update(sql, params.toArray());
		}
	}
	
	/**
	 * 采用helper方式进行传参来进行更新数据
	 * @param helper
	 * @param dataList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void update(Helper helper,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> resultList = this.getSqlAndParams(helper,dataList);
		for (Map<String, Object> map : resultList) {
			String judgeSql = (String) map.get("judgeSql");
			List<Object> selectParams = (List<Object>) map.get("selectParams");
			if((helper.getUpdateMode()).equals(Helper.TO_DELETE)){
				//先删除数据
				String deleteSql = (String) map.get("deleteSql");
				List<Object> deleteParams = (List<Object>) map.get("deleteParams");
				helper.getToTemplate().update(deleteSql, deleteParams.toArray());
				//插入该条数据
				String insertSql = (String) map.get("insertSql");
				List<Object> insertParams = (List<Object>) map.get("insertParams");
				helper.getToTemplate().update(insertSql, insertParams.toArray());
			}else if((helper.getUpdateMode()).equals(Helper.TO_UPDATE)){
				if(this.isExistOfData(helper,judgeSql,selectParams)){
					String updateSql = (String) map.get("updateSql");
					List<Object> updateParams = (List<Object>) map.get("updateParams");
					helper.getToTemplate().update(updateSql, updateParams.toArray());
				}else{
					String insertSql = (String) map.get("insertSql");
					List<Object> insertParams = (List<Object>) map.get("insertParams");
					helper.getToTemplate().update(insertSql, insertParams.toArray());
				}
			}
			
		}
	}
	
	/**
	 * 得到insert的sql与params
	 * @param toTableName
	 * @param dataList
	 * @return
	 */
	private List<Map<String,Object>> getInsertSqlAndParams(String toTableName,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> insertList = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : dataList) {
			String sql = "";
			boolean isFirst = true;
			StringBuffer insert = new StringBuffer();
			StringBuffer values = new StringBuffer();
			List<Object> params = new ArrayList<Object>();
			Map<String,Object> row = new HashMap<String,Object>();
			Set<Entry<String,Object>> entrySet = map.entrySet();
			insert.append("INSERT INTO "+toTableName+"(");
			values.append("VALUES(");
			for (Entry<String, Object> entry : entrySet) {
				if(isFirst){
					insert.append(entry.getKey());
					values.append("?");
					params.add(entry.getValue());
					isFirst = false;
				}else{
					insert.append(","+entry.getKey());
					values.append(",?");
					params.add(entry.getValue());
				}
			}
			insert.append(") ");
			values.append(")");
			sql = insert.toString()+values.toString();
			row.put("sql", sql);
			row.put("params", params);
			insertList.add(row);
		}
		
		return insertList;
	}
	
	/**
	 * 得到insert的sql与params,带监狱名称与监狱编号
	 * @param toTableName
	 * @param dataList
	 * @return
	 */
	private List<Map<String,Object>> getInsertSqlAndParams(String toTableName,String jymc,String jybh,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> insertList = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : dataList) {
			String sql = "";
			boolean isFirst = true;
			StringBuffer insert = new StringBuffer();
			StringBuffer values = new StringBuffer();
			List<Object> params = new ArrayList<Object>();
			Map<String,Object> row = new HashMap<String,Object>();
			Set<Entry<String,Object>> entrySet = map.entrySet();
			insert.append("INSERT INTO "+toTableName+"(jymc,jybh,");
			values.append("VALUES(?,?,");
			for (Entry<String, Object> entry : entrySet) {
				if(isFirst){
					if("jymc".equalsIgnoreCase(entry.getKey().trim())){
						continue;
					}
					if("jybh".equalsIgnoreCase(entry.getKey().trim())){
						continue;
					}
					params.add(jymc);
					params.add(jybh);
					insert.append(entry.getKey());
					values.append("?");
					params.add(entry.getValue());
					isFirst = false;
				}else{
					if("jymc".equalsIgnoreCase(entry.getKey().trim())){
						continue;
					}
					if("jybh".equalsIgnoreCase(entry.getKey().trim())){
						continue;
					}
					insert.append(","+entry.getKey());
					values.append(",?");
					params.add(entry.getValue());
				}
			}
			insert.append(") ");
			values.append(")");
			sql = insert.toString()+values.toString();
			row.put("sql", sql);
			row.put("params", params);
			insertList.add(row);
		}
		
		return insertList;
	}
	
	/**
	 * 该方法是用于得到insert,update,delete 及其参数
	 * @param helper 
	 * @param dataList 
	 * @return
	 * @throws Exception
	 */
	private List<Map<String,Object>> getSqlAndParams(Helper helper,List<Map<String,Object>> dataList)throws Exception{
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : dataList) {
			Map<String,Object> toColumnMap = helper.getToColumnMap();
			if(!toColumnMap.isEmpty()){
				map.putAll(toColumnMap);
			}
			String insertSql = "";
			String updateSql = "";
			String deleteSql = "";
			String judgeSql = "";
			boolean isFirst = true;
			boolean hasCount = false;
			StringBuffer insert = new StringBuffer();
			StringBuffer values = new StringBuffer();
			StringBuffer update = new StringBuffer();
			StringBuffer updateWhere = new StringBuffer();
			StringBuffer delete = new StringBuffer();
			StringBuffer deleteWhere = new StringBuffer();
			StringBuffer select = new StringBuffer();
			StringBuffer selectWhere = new StringBuffer();
			List<Object> insertParams = new ArrayList<Object>();
			List<Object> updateParams = new ArrayList<Object>();
			List<Object> updateWhereParams = new ArrayList<Object>();
			List<Object> deleteParams = new ArrayList<Object>();
			List<Object> deleteWhereParams = new ArrayList<Object>();
			List<Object> selectParams = new ArrayList<Object>();
			List<Object> selectWhereParams = new ArrayList<Object>();
			Map<String,Object> row = new HashMap<String,Object>();
			Set<Entry<String,Object>> entrySet = map.entrySet();
			insert.append("INSERT INTO "+helper.getToTableName()+"(");
			values.append("VALUES(");
			update.append("UPDATE "+helper.getToTableName()+" SET");
			updateWhere.append(" WHERE 1=1");
			delete.append("DELETE FROM "+helper.getToTableName());
			deleteWhere.append(" WHERE 1=1");
			select.append("SELECT COUNT(");
			selectWhere.append(" FROM "+helper.getToTableName()+" WHERE 1=1");
			for (Entry<String, Object> entry : entrySet) {
				if(isFirst){
					insert.append(entry.getKey());
					values.append("?");
					insertParams.add(entry.getValue());
					update.append(" "+entry.getKey()+"=?");
					updateParams.add(entry.getValue());
					if(StringUtils.isEmpty(helper.getToPrimaryKeyId()) && (helper.getToColumnList().isEmpty())){
						if(!hasCount){
							select.append("*)");
							hasCount = true;
						}
					}
					if(!StringUtils.isEmpty(helper.getToPrimaryKeyId())){
						if((helper.getToPrimaryKeyId().trim()).equalsIgnoreCase(entry.getKey())){
							updateWhere.append(" AND "+entry.getKey()+"=?");
							deleteWhere.append(" AND "+entry.getKey()+"=?");
							updateWhereParams.add(entry.getValue());
							deleteWhereParams.add(entry.getValue());
							if(!hasCount){
								select.append(entry.getKey()+")");
								hasCount = true;
							}
							selectWhere.append(" AND "+entry.getKey()+"=?");
							selectWhereParams.add(entry.getValue());
						}
					}
					if(!(helper.getToColumnList().isEmpty())){
						for (String column : helper.getToColumnList()) {
							if((column.trim()).equalsIgnoreCase(entry.getKey())){
								updateWhere.append(" AND "+entry.getKey()+"=?");
								deleteWhere.append(" AND "+entry.getKey()+"=?");
								updateWhereParams.add(entry.getValue());
								deleteWhereParams.add(entry.getValue());
								if(!hasCount){
									select.append(entry.getKey()+")");
									hasCount = true;
								}
								selectWhere.append(" AND "+entry.getKey()+"=?");
								selectWhereParams.add(entry.getValue());
							}
						}
					}
					isFirst = false;
				}else{
					insert.append(","+entry.getKey());
					values.append(",?");
					insertParams.add(entry.getValue());
					update.append(","+entry.getKey()+"=?");
					updateParams.add(entry.getValue());
					if(StringUtils.isEmpty(helper.getToPrimaryKeyId()) && (helper.getToColumnList().isEmpty())){
						if(!hasCount){
							select.append("*)");
							hasCount = true;
						}
					}
					if(!StringUtils.isEmpty(helper.getToPrimaryKeyId())){
						if((helper.getToPrimaryKeyId().trim()).equalsIgnoreCase(entry.getKey())){
							updateWhere.append(" AND "+entry.getKey()+"=?");
							deleteWhere.append(" AND "+entry.getKey()+"=?");
							updateWhereParams.add(entry.getValue());
							deleteWhereParams.add(entry.getValue());
							if(!hasCount){
								select.append(entry.getKey()+")");
								hasCount = true;
							}
							selectWhere.append(" AND "+entry.getKey()+"=?");
							selectWhereParams.add(entry.getValue());
						}
					}
					if(!(helper.getToColumnList().isEmpty())){
						for (String column : helper.getToColumnList()) {
							if((column.trim()).equalsIgnoreCase(entry.getKey())){
								updateWhere.append(" AND "+entry.getKey()+"=?");
								deleteWhere.append(" AND "+entry.getKey()+"=?");
								updateWhereParams.add(entry.getValue());
								deleteWhereParams.add(entry.getValue());
								if(!hasCount){
									select.append(entry.getKey()+")");
									hasCount = true;
								}
								selectWhere.append(" AND "+entry.getKey()+"=?");
								selectWhereParams.add(entry.getValue());
							}
						}
					}
				}
			}
			insert.append(") ");
			values.append(")");
			insertSql = insert.toString()+values.toString();
			updateSql = update.toString()+updateWhere.toString();
			deleteSql = delete.toString()+deleteWhere.toString();
			judgeSql = select.toString()+selectWhere.toString();
			updateParams.addAll(updateWhereParams);
			deleteParams.addAll(deleteWhereParams);
			selectParams.addAll(selectWhereParams);
			row.put("insertSql", insertSql);
			row.put("insertParams", insertParams);
			row.put("updateSql", updateSql);
			row.put("updateParams", updateParams);
			row.put("deleteSql", deleteSql);
			row.put("deleteParams", deleteParams);
			row.put("judgeSql", judgeSql);
			row.put("selectParams", selectParams);
			resultList.add(row);
		}
		return resultList;
	}
	
	/**
	 * 数据存在返回true,否则返回false
	 * @param helper
	 * @param judgeSql
	 * @param selectParams
	 * @return
	 */
	private boolean isExistOfData(Helper helper ,String judgeSql,List<Object> selectParams){
		boolean isExist = false;
		List<Map<String,Object>> list = helper.getToTemplate().queryForList(judgeSql, selectParams.toArray());
		if(!(list.isEmpty())){
			for (Map<String, Object> map : list) {
				Set<Entry<String,Object>> entrySet = map.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					BigDecimal value = (BigDecimal) entry.getValue();
					int i = value.intValue();
					if(i != 0){
						isExist = true;
					}
				}
			}
		}
		return isExist;
	}
	
	/**
	 * 开启一个线程
	 * @param br
	 */
	public static void startRun(BaseRunnable br){
		Thread thread = new Thread(br);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
