package com.bjhy.criminal.search.timer.tool;
/**
 * 罪犯信息相关sql工具类
 * @author wangbowen
 * @date 2015-12-09
 * @version 1.0
 *
 */
public class CriminalSearchSqlUtis {
	/*******罪犯基础信息部分**********/
	/**
	 * 获取罪犯当前信息sql
	 */
	public static final String criminalCurrentSql ="select t.* from BS_DQXX t where 1=1";
	/**
	 * 获取罪犯基本信息sql
	 */
	public static final String criminalBaseInfoSql ="select * from V_ZFJC_BS_BSINFO where 1=1";
	
	/**
	 * 获取罪犯体貌特征sql
	 */
	public static final String criminalPhysicalSql ="select * from bs_tmtz where 1=1";

	/**
	 * 获取罪犯外籍信息sql
	 */
	public static final String criminalForeignSql ="select * from bs_wjxx where 1=1";

	/**
	 * 获取罪犯社会关系sql
	 */
	public static final String criminalSocialRelationsSql ="select * from  V_ZFJC_BS_ZFSHGX  where 1=1";
	/**
	 * 获取罪犯简历sql
	 */
	public static final String criminalResumeSql ="select * from bs_zfjl where 1=1";
	/**
	 * 获取罪犯媒体sql
	 */
	public static final String criminalMediaSql ="select * from bs_mtxx where 1=1";
	
	/**
	 * 获取罪犯逮捕收押sql
	 */
	public static final String criminalArrestDetainSql =" select * from bs_zfsyqk where 1=1";
	/**
	 *  获取罪犯审判信息sql
	 */
	public static final String criminalTrialSql =" select * from bs_zfspqk";
	/**
	 *  获取罪犯非法组织sql
	 */
	public static final String criminalIllegalGroupSql =" select * from bs_cjffzz where 1=1";
	/**
	 *  获取罪犯刑法变动sql
	 */
	public static final String criminalLawChangesSql =" select * from t_punishment where 1=1";
	/**
	 *   获取罪犯奖励情况sql
	 */
	public static final String criminalRewardSql =" select * from t_zfxzjl where 1=1";
	/**
	 * 获取罪犯其他称呼sql
	 */
	public static final String criminalOtherCallSql ="select bb.bmid,bb.zfid,s.codename as "
		                                         	+ "chlb,bb.xh,bb.chnr,bb.bz,bb.Createdate from bs_bmxx bb  "
		                                         	+ "left join sys_dic s on  s.dicid = bb.chlb ";
	/**
	 *  获取罪犯前科信息sql
	 */
	public static final String criminalRecordSql =" select b.id,b.zfid,s.codename as qklb,"
													+ "b.qr,b.zr,b.zm,b.zmstr,b.ay,b.pjrq,b.gydd,b.createDate "
													+ "from bs_zfqk b left join sys_dic s on  s.dicid = b.qklb";
	/**
	 * 获取罪犯证件信息sql
	 */
	public static final String criminalCertificateSql ="select bp.id,bp.zfid, s.codename as "
												+ "zjlx,bp.zjhm,bp.zjzr,bp.Createdate from bs_paperwork bp "
												+ "left join sys_dic s on  s.dicid = bp.zjlx ";
	//死亡登记、解回假释
	/*********静态资源部分******/
	/**
	 * 获取静态资源信息sql
	 */
	public static final String  sysDicSql = "select dicid,codeName from sys_dic ";
	/**
	 * 罪犯状态sql
	 */
	public static final String  criminalStateSql = "select ps_code,ps_name from bs_prison_state";
	/**
	 * 查询监狱信息sql
	 */
	public static final String  jySql = "select id,jymc,jybh from bs_prison ";
	/**
	 * 关押监区sql
	 */
	public static final String jqSql ="select bmid,jgmc,jgdm from bs_jgxx ";
	/**
	 * 查询处理等级信息sql
	 */
	public static final String handleLevelSql ="select  id,mc,bzmc from  t_cydj ";
	
}
