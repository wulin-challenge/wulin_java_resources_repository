package cn.scxh.ittx.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.dao.impl.MedicineClassifyDaoImpl;
import cn.scxh.ittx.dao.intf.MedicineClassifyDao;
import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.intf.MedicineClassifyService;

public class MedicineClassifyServiceImpl implements MedicineClassifyService{

	public void addMedicineClassify(MedicineClassify classify)
			throws AddObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			mcd.addMedicineClassify(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddObjectException();
		}
	}

	public void deleteMedicineClassify(MedicineClassify classify)
			throws DeleteObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			mcd.deleteMedicineClassify(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteObjectException();
		}
	}

	public List<MedicineClassify> differenceConditionQueryMedicineClassify(
			MedicineClassify classify) throws QueryObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		
		try {
			return mcd.differenceConditionQueryMedicineClassify(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<MedicineClassify> theLargestNumberOfMedicineClassify(
			MedicineClassify classify) throws QueryObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			return mcd.theLargestNumberOfMedicineClassify(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public void updateMedicineClassify(MedicineClassify classify)
			throws UpdateObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			mcd.updateMedicineClassify(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateObjectException();
		}
	}

	public List<MedicineClassify> getChildren(MedicineClassify classify)
			throws QueryObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			return mcd.getChildren(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<MedicineClassify> getParent(MedicineClassify classify)
			throws QueryObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			return mcd.getParent(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify)
			 throws QueryObjectException {
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			return mcd.getMedicineRoot(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<MedicineClassify> getChildrenBynameAndId(
			MedicineClassify classify) throws QueryObjectException{
		MedicineClassifyDao mcd=new MedicineClassifyDaoImpl();	
		try {
			return mcd.getChildrenBynameAndId(classify);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		
	}

	

}
