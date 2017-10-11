package cn.scxh.ittx.service.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;

import cn.scxh.ittx.dao.impl.SickCaseDaoImpl;
import cn.scxh.ittx.dao.intf.SickCaseDao;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.intf.SickCaseService;

public class SickCaseServiceImpl implements SickCaseService{

	public void addSickCase(SickCase sickCase) throws AddObjectException {
		SickCaseDao sc=new SickCaseDaoImpl();
		try {
			sc.addSickCase(sickCase);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddObjectException();
		}
	}

	public void deleteSickCase(SickCase sickCase) throws DeleteObjectException {
		SickCaseDao sc=new SickCaseDaoImpl();
		try {
			sc.deleteSickCase(sickCase);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteObjectException();
		}

		
	}

	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase)
			throws QueryObjectException {
		SickCaseDao sc=new SickCaseDaoImpl();
		try {
			return sc.differenceConditionQuerySickCase(sickCase);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<SickCase> theLargestNumberOfSikeCase()
			throws QueryObjectException {
		SickCaseDao sc=new SickCaseDaoImpl();
		try {
			return sc.theLargestNumberOfSikeCase();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public void updateSickCase(SickCase sickCase) throws UpdateObjectException {
		SickCaseDao sc=new SickCaseDaoImpl();
		try {
			sc.updateSickCase(sickCase);
		} catch (SQLException e) {
			e.printStackTrace(); 
			throw new UpdateObjectException();
		}
	}

	public SharedArrays querySickCase(SickCase sickCase) throws QueryObjectException {
		String[] oneArray=new String[]{"病历编号","主诉","现病史","既往史","个人史","体格检查","实验室检查",
				"诊断","意见","其他说明","就诊日期","医疗证号"};
		String[][] twoArray=null;
		SickCaseDao sc=new SickCaseDaoImpl();
		SharedArrays sharedArrays=new SharedArrays();
		try {
			List<SickCase> sickCaseList=sc.differenceConditionQuerySickCase(sickCase);
			twoArray=new String[sickCaseList.size()][oneArray.length];
			int i=0;
			for (SickCase s : sickCaseList) {
				twoArray[i][0]=s.getId()+"";
				twoArray[i][1]=s.getMainSymptom();
				twoArray[i][2]=s.getNowSymptom();
				twoArray[i][3]=s.getPastSymptom();
				twoArray[i][4]=s.getPersonalSymptom();
				twoArray[i][5]=s.getBodyTest();
				twoArray[i][6]=s.getLabTest();
				twoArray[i][7]=s.getExamination();
				twoArray[i][8]=s.getAdvice();
				twoArray[i][9]=s.getOtherExplain();
				twoArray[i][10]=DateFormat.getDateInstance().format(s.getExaminationTime());
				twoArray[i][11]=s.getPatientIdFk();
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
