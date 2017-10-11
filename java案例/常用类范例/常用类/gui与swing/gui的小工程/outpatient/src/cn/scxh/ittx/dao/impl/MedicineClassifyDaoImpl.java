package cn.scxh.ittx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.dao.intf.MedicineClassifyDao;
import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.util.DBConnection;

public class MedicineClassifyDaoImpl implements MedicineClassifyDao {

	public void addMedicineClassify(MedicineClassify classify)
			throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql = "INSERT INTO t_medicine_classify(id,name,p_id) values(?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getId());
		ps.setString(2, classify.getName());
		ps.setInt(3, classify.getPid());
		ps.execute();
		DBConnection.close(ps, connection);
	}

	public void deleteMedicineClassify(MedicineClassify classify)
			throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql = "DELETE from t_medicine_classify where id=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getId());
		ps.execute();
		DBConnection.close(ps, connection);

	}

	public List<MedicineClassify> differenceConditionQueryMedicineClassify(
			MedicineClassify classify) throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		connection=DBConnection.getConnection();
		String sql=VariousConditionsQueryMedicineClassify.getSql(classify);
		ps=connection.prepareStatement(sql);
		VariousConditionsQueryMedicineClassify.setPreparedStatement(ps, classify);
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int pid=rs.getInt("p_id");
			MedicineClassify c=new MedicineClassify();
			c.setId(id);
			c.setName(name);
			c.setPid(pid);
			classifyList.add(c);
		}
		return classifyList;
	}

	public List<MedicineClassify> theLargestNumberOfMedicineClassify(
			MedicineClassify classify) throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		connection = DBConnection.getConnection();
		String sql = "SELECT max(id) from t_medicine_classify";
		ps = connection.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("max(id)");
			MedicineClassify mc=new MedicineClassify();
			mc.setId(id);
			classifyList.add(mc);
		}
		DBConnection.close(rs,ps, connection);
		return classifyList;
	}

	public void updateMedicineClassify(MedicineClassify classify)
			throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql = "update t_medicine_classify set id=?,name=? p_id=? where id=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getId());
		ps.setString(2, classify.getName());
		ps.setInt(3, classify.getPid());
		ps.setInt(4, classify.getId());
		ps.execute();
		DBConnection.close(ps, connection);
	}

	public List<MedicineClassify> getChildren(MedicineClassify classify) throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		connection = DBConnection.getConnection();
		String sql = "SELECT children.* " +
				"FROM t_medicine_classify children ,t_medicine_classify parent " +
				"WHERE children.P_id=parent.id and children.id!=? and children.P_id=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getId());
		ps.setInt(2, classify.getId());
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int pid=rs.getInt("p_id");
			MedicineClassify c=new MedicineClassify();
			c.setId(id);
			c.setName(name);
			c.setPid(pid);
			classifyList.add(c);
		}
		DBConnection.close(rs,ps, connection);
		return classifyList;
	}

	public List<MedicineClassify> getParent(MedicineClassify classify) throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		connection = DBConnection.getConnection();
		String sql = "SELECT parent.* FROM t_medicine_classify children ," +
				"t_medicine_classify parent WHERE children.P_id=parent.id and parent.id=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getPid());
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int pid=rs.getInt("p_id");
			MedicineClassify c=new MedicineClassify();
			c.setId(id);
			c.setName(name);
			c.setPid(pid);
			classifyList.add(c);
		}
		DBConnection.close(rs,ps, connection);
		return classifyList;
	}

	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify)
			throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		connection = DBConnection.getConnection();
		String sql = "SELECT * FROM t_medicine_classify where id=p_id";
		ps = connection.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int pid=rs.getInt("p_id");
			MedicineClassify c=new MedicineClassify();
			c.setId(id);
			c.setName(name);
			c.setPid(pid);
			classifyList.add(c);
		}
		DBConnection.close(rs,ps, connection);
		return classifyList;
	}
	
	//通过父亲的id与孩子的名字的得到孩子的id
	public List<MedicineClassify> getChildrenBynameAndId(MedicineClassify classify) throws SQLException {
		List<MedicineClassify> classifyList=new ArrayList<MedicineClassify>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		connection = DBConnection.getConnection();
		String sql = "SELECT children.* " +
				"FROM t_medicine_classify children ,t_medicine_classify parent " +
				"WHERE children.P_id=parent.id and children.id!=? and children.P_id=? and children.name=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, classify.getId());
		ps.setInt(2, classify.getId());
		ps.setString(3, classify.getName());
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int pid=rs.getInt("p_id");
			MedicineClassify c=new MedicineClassify();
			c.setId(id);
			c.setName(name);
			c.setPid(pid);
			classifyList.add(c);
		}
		DBConnection.close(rs,ps, connection);
		return classifyList;
	}

}
