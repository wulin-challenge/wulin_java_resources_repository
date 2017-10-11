package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.SickCase;

public interface SickCaseDao {
	//增加病例
	public void addSickCase(SickCase sickCase) throws SQLException;
	//删除病例 
	public void deleteSickCase(SickCase sickCase) throws SQLException;
	//更新病例
	public void updateSickCase(SickCase sickCase) throws SQLException;
	//不同条件查询病例
	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase) throws SQLException;
	//得到病例最大数
	public List<SickCase> theLargestNumberOfSikeCase() throws SQLException;

}
