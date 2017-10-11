package cn.wulin.listener.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import cn.wulin.listener.LocationListener;
import cn.wulin.listener.impl.LocationEvent;
import cn.wulin.listener.test.TestLocationListener;
import cn.wulin.util.DBMysql;

public class LocationService {

	private Connection conn = null;
	private Vector repository = new Vector();
	private LocationListener ll;

	List list = new ArrayList();
	String sql = "select * from t_user";
	Statement st = null;

	public LocationService() {
	}

	public void addLocationListener(LocationListener ll) {
		repository.addElement(ll);
	}


	public void notifyLocationEvent(LocationEvent event) {
		Enumeration e = repository.elements();// 这步要注意同步问题
		while (e.hasMoreElements()) {
			ll = (LocationListener) e.nextElement();
			ll.locationEvent(event);
		}
	}

	// 删除监听器，如果这里没有使用Vector而是使用ArrayList那么要注意同步问题
	public void removeLocationListener(LocationListener ll) {
		repository.remove(ll);// 这步要注意同步问题
	}

	public List getLocationList() throws SQLException {
		conn = DBMysql.getConnection();
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String longitude = rs.getString("longitude");
				list.add(longitude);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addLocation(String sql) throws SQLException {
		boolean b = false;
		conn = DBMysql.getConnection();
		try {
			st = conn.createStatement();
			int id = st.executeUpdate(sql);
			if (id > 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 添加一个记录成功就通知事件,然后执行接口的方法
		if (b) {
			System.out.println("sss");
			notifyLocationEvent(new LocationEvent(this));
		}
	}

	public static void main(String[] args) {
		new TestLocationListener();
	}

}
