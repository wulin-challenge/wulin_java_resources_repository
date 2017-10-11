package com.tiantian.springintejms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiantian.springintejms.dao.TestDao;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=false)
	public void insert(final String name) {
		
		jdbcTemplate.update("insert into test(name) values(?)", name);

	}

	public List<Map<String, Object>> findAll() {
		String sql = "select * from test";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<String, Object>>>() {

			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", rs.getInt("id"));
					map.put("name", rs.getString("name"));
					list.add(map);
				}
				return list;
			}
			
		});
	}

	public Map<String, Object> findById(int id) {
		return null;
	}

}
