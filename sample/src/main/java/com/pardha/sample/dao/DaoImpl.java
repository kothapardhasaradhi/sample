package com.pardha.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pardha.sample.modal.Emp;

@Repository
public class DaoImpl implements Dao {

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Emp> getEmployees() {
		
		return jdbcTemplate.query("select * from employee",new RowMapper<Emp>(){  
	        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
	            Emp e=new Emp();  
	            e.setName(rs.getString(0));
	            e.setEmail(rs.getString(1));  
	            return e;  
	        }  
	    });  
	}

	@Override
	public int save(){  
	    String sql="insert into EMPLOYEE(name,email)values('aASFASFa','saSDASAFaaaa@a.com')";  
	    return jdbcTemplate.update(sql);  
	}

	/*@Override
	public String getEmail(String name) {
		
		String sql="select name,email from team_members where name=?";

		return jdbcTemplate.queryForObject(sql, new Object[]{name},new BeanPropertyRowMapper<Emp>(Emp.class));
	}*/
	

}
