package wulin.wubo.baseService.impl;

import java.sql.SQLException;
import java.util.List;

import wulin.wubo.baseDao.MyBaseDao;
import wulin.wubo.baseDao.impl.MyBaseDaoImpl;
import wulin.wubo.baseDomain.SeparatePage;
import wulin.wubo.baseException.MyBaseAddException;
import wulin.wubo.baseException.MyBaseDeleteException;
import wulin.wubo.baseException.MyBaseEditException;
import wulin.wubo.baseException.MyBaseQueryException;
import wulin.wubo.baseService.MyBaseService;

public class MyBaseServiceImpl<T> implements MyBaseService<T>{

	public void addData(T entity) throws MyBaseAddException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		try {
			dao.addData(entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseAddException();
		}
		
	}

	public void deleteDataById(T entity, Object id)
			throws MyBaseDeleteException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		try {
			dao.deleteDataById(entity, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseDeleteException();
		}
	}

	public void editData(T entity) throws MyBaseEditException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		try {
			dao.editData(entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseEditException();
		}
		
	}

	public List<T> findAllData(T entity) throws MyBaseQueryException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		List<T> dateList=null;
		try {
			dateList=dao.findAllData(entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseQueryException();
		}
		return dateList;
	}

	public SeparatePage<T> findAllDataByConditon(Integer currentPage,
			 T entity) throws MyBaseQueryException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		SeparatePage<T> sp=new SeparatePage<T>();
		sp.setCurrentPage(currentPage);
		try {
			sp.setAllRecord(dao.getRecordCountByCondition(entity).intValue());
			sp.setCurrentPageData(dao.findAllDataByConditon(sp.getStartPage(), sp.getRecordOfPer(), entity));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseQueryException();
		}
		return sp;
	}

	public T findDataById(T entity, Object id) throws MyBaseQueryException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		T data=null;
		try {
			data=dao.findDataById(entity, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseQueryException();
		}
		
		return data;
	}

	public Long getRecordCountByCondition(T entity) throws MyBaseQueryException {
		MyBaseDao<T> dao=new MyBaseDaoImpl<T>();
		Long l=null;
		try {
			l=dao.getRecordCountByCondition(entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyBaseQueryException();
		}
		return l;
	}

}
