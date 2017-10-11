package cn.scxh.ittx.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.dao.impl.MedicineDaoImpl;
import cn.scxh.ittx.dao.intf.MedicineDao;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.intf.MedicineService;

public class MedicineServiceImpl implements MedicineService{

	public void addMedicine(Medicine medicine) throws AddObjectException {
		MedicineDao md=new MedicineDaoImpl();
		try {
			md.addMedicine(medicine);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddObjectException();
		}
	}

	public void deleteMedicine(Medicine medicine) throws DeleteObjectException {
		MedicineDao md=new MedicineDaoImpl();
		try {
			md.deleteMedicine(medicine);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteObjectException();
		}
	}

	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine)
			throws QueryObjectException {
		MedicineDao md=new MedicineDaoImpl();
		try {
			return md.differenceConditionQueryMedicines(medicine);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine)
			throws QueryObjectException {
		MedicineDao md=new MedicineDaoImpl();
		try {
			return md.theLargestNumberOfMedicines(medicine);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public void updateMedicine(Medicine medicine) throws UpdateObjectException {
		MedicineDao md=new MedicineDaoImpl();
		try {
			md.updateMedicine(medicine);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateObjectException();
		}
	}

	public SharedArrays queryMedicines(Medicine medicine)
			throws QueryObjectException {
		String[] oneArray=new String[]{"编号","名称","药品类别","药品规格","进口单位","进口价格",
				"成本价格","验证码","销售价格","简单名称","库存上限","库存下限","批准编号","生产公司",
				"主要成分","药品功效","使用方法","主要事项"};
		SharedArrays sharedArrays=new SharedArrays();
		MedicineDao md=new MedicineDaoImpl();
		try {
			List<Medicine> medicineList=md.differenceConditionQueryMedicines(medicine);
			String[][] twoArray=new String[medicineList.size()][oneArray.length];
			int i=0;
			for (Medicine m : medicineList) {
				twoArray[i][0]=String.valueOf(m.getId());
				twoArray[i][1]=m.getName();
				twoArray[i][2]=m.getClassification();
				twoArray[i][3]=m.getStandard();
				twoArray[i][4]=m.getEnterCompany();
				twoArray[i][5]=m.getEnterPrice();
				twoArray[i][6]=m.getShoppingPrice();
				twoArray[i][7]=m.getValidateNumber()+"";
				twoArray[i][8]=m.getSalePrice()+"";
				twoArray[i][9]=m.getSimpleName();
				twoArray[i][10]=m.getUpperLimit();
				twoArray[i][11]=m.getDownLimit();
				twoArray[i][12]=m.getApproveNumber()+"";
				twoArray[i][13]=m.getProduceCompany();
				twoArray[i][14]=m.getMainComponent();
				twoArray[i][15]=m.getMedicineEffect();
				twoArray[i][16]=m.getUseMethod();
				twoArray[i][17]=m.getMattersNeedAttention();
				i++;
			}
			sharedArrays.setSharedOneArray(oneArray);
			sharedArrays.setSharedTwoArray(twoArray);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		return sharedArrays;
	}

}
