package wulin.wubo.baseService;

import java.util.List;

import wulin.wubo.baseDomain.SeparatePage;
import wulin.wubo.baseException.MyBaseAddException;
import wulin.wubo.baseException.MyBaseDeleteException;
import wulin.wubo.baseException.MyBaseEditException;
import wulin.wubo.baseException.MyBaseQueryException;

public interface MyBaseService<T> {

	/**增加数据*/
	public void addData(T entity) throws MyBaseAddException;
	/**修改数据*/
	public void editData(T entity) throws MyBaseEditException;
	/**通过ID进行删除*/
	public void deleteDataById(T entity,Object id) throws MyBaseDeleteException;
	/**查询所有数据*/
	public List<T> findAllData(T entity) throws MyBaseQueryException;
	/**根据ID进行查询*/
	public T findDataById(T entity,Object id) throws MyBaseQueryException;
	/**查询所有数据*/
	public SeparatePage<T> findAllDataByConditon(Integer currentPage,T entity) throws MyBaseQueryException;
	/**通过条件得到所有记录数*/
	public Long getRecordCountByCondition(T entity) throws MyBaseQueryException;
}
