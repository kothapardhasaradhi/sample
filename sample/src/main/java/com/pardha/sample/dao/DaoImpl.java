package com.pardha.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pardha.sample.modal.Emp;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Emp> getEmployees() {
		
		return jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	@Override
	public int save(Emp emp){  
	    String sql="insert into EMPLOYEE(name,email)values(?,?)";  
	    return jdbcTemplate.update(sql,new Object[]{emp.getName(),emp.getEmail()});  
	}


	@Override
	public int update(Emp emp) {
		String sql="update EMPLOYEE set email='"+emp.getEmail()+"' where name='"+emp.getName()+"'";
		return jdbcTemplate.update(sql);
	}


	@Override
	public int delete(String name) {
		String sql="delete from EMPLOYEE where name=?";
		return jdbcTemplate.update(sql,new Object[]{name});
	}


	@Override
	public Emp getEmpDetails(String name) {
		String sql="select * from EMPLOYEE where name=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{name},new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	
	

}
