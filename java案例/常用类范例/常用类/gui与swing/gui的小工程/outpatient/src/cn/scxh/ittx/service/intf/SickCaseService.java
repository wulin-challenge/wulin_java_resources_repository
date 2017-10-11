package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface SickCaseService {
	//增加病例
	public void addSickCase(SickCase sickCase)throws AddObjectException;
	//删除病例 
	public void deleteSickCase(SickCase sickCase) throws DeleteObjectException;
	//更新病例
	public void updateSickCase(SickCase sickCase) throws UpdateObjectException;
	//不同条件查询病例
	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase) throws QueryObjectException;
	//得到病例最大数
	public List<SickCase> theLargestNumberOfSikeCase() throws QueryObjectException;
	
	//返回所有的病例
	public SharedArrays querySickCase(SickCase sickCase)throws QueryObjectException;
}
