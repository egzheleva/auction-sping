package com.auction.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.auction.dao.AuctionDao;
import com.auction.model.Auction;

@Repository
public class AuctionDaoImpl extends JdbcDaoSupport implements AuctionDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public void insertEmployee(Auction emp) {
//		String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
//		getJdbcTemplate().update(sql, new Object[] { emp.getEmpId(), emp.getName() });
	}

	public void insertEmployees(final List<Auction> employees) {
//		String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
//		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				Auction employee = employees.get(i);
//				ps.setString(1, employee.getEmpId());
//				ps.setString(2, employee.getName());
//			}
//
//			public int getBatchSize() {
//				return employees.size();
//			}
//		});

	}

	public List<Auction> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Auction> result = new ArrayList<Auction>();
		for (Map<String, Object> row : rows) {
			Auction emp = new Auction();
			emp.setEmpId((String) row.get("empId"));
			emp.setName((String) row.get("empName"));
			result.add(emp);
		}

		return result;
	}

	public Auction getEmployeeById(String empId) {
		/*String sql = "SELECT * FROM employee WHERE empId = ?";
		return (Auction) getJdbcTemplate().queryForObject(sql, new Object[] { empId }, new RowMapper<Auction>() {
			public Auction mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Auction emp = new Auction();
				emp.setEmpId(rs.getString("empId"));
				emp.setName(rs.getString("empName"));
				return emp;
			}
		});*/
		return null;
	}

}
