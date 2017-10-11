package wulin.wubo.baseDao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import wulin.wubo.baseDao.MyBaseDao;
import wulin.wubo.baseUtil.ConditionUtil;
import wulin.wubo.baseUtil.JdbcUtil;

@SuppressWarnings("unchecked")
public class MyBaseDaoImpl<T> implements MyBaseDao<T>{

	public void addData(T entity) throws SQLException {
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getAddDataSql();
		System.out.println(sql);
		runner.update(sql,condition.getAddParameter());
	}

	public void deleteDataById(T entity,Object id) throws SQLException {
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getDeleteDataSql();
		System.out.println(sql);
		runner.update(sql,id);
	}

	public void editData(T entity) throws SQLException {
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getEditDataSql();
		System.out.println(sql);
		runner.update(sql,condition.getEditParameter());
	}

	
	public List<T> findAllData(T entity) throws SQLException {
		List<T> dataList=new ArrayList<T>();
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getFindAllSql();
		System.out.println(sql);
		dataList=(List<T>) runner.query(sql,new BeanListHandler(entity.getClass()));
		return dataList;
	}

	public List<T> findAllDataByConditon(Integer startRecord,
			Integer recordOfPer, T entity) throws SQLException {
		List<T> dataList=new ArrayList<T>();
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getFindAllDataByConditonSql();
		System.out.println(sql);
		dataList=(List<T>) runner.query(sql, condition.getFindAllDataByConditonParameter(startRecord, recordOfPer), new BeanListHandler(entity.getClass()));
		return dataList;
	}

	public T findDataById(T entity, Object id) throws SQLException {
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getFindDataByIdSql();
		return (T) runner.query(sql,id,new BeanHandler(entity.getClass()));
	}

	public Long getRecordCountByCondition(T entity) throws SQLException {
		ConditionUtil<T> condition=ConditionUtil.getInstance(entity);
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql=condition.getRecordCountByConditionSql();
		System.out.println(sql);
		return (Long) runner.query(sql, condition.getRecordCountByConditionParameter(),new ScalarHandler());
	}

}