package wulin.wubo.baseDao;

import java.sql.SQLException;
import java.util.List;

public interface MyBaseDao<T> {
	/**增加数据*/
	public void addData(T entity) throws SQLException;
	/**修改数据*/
	public void editData(T entity) throws SQLException;
	/**通过ID进行删除*/
	public void deleteDataById(T entity,Object id) throws SQLException;
	/**查询所有数据*/
	public List<T> findAllData(T entity) throws SQLException;
	/**根据ID进行查询*/
	public T findDataById(T entity,Object id) throws SQLException;
	/**查询所有数据*/
	public List<T> findAllDataByConditon(Integer startRecord ,Integer recordOfPer,T entity) throws SQLException;
	/**通过条件得到所有记录数*/
	public Long getRecordCountByCondition(T entity) throws SQLException;

}
