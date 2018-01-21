package com.pardha.sample.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pardha.sample.modal.Emp;

@Repository("dao")
@Transactional
public class DaoImpl implements Dao {

	/*@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
*/
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> getEmployees() {
		
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from employee").list();		
		
		//return jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<Emp>(Emp.class));
		
	}

	@Override
	public void save(Emp emp){  
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(emp);
		
//	    String sql="insert into EMPLOYEE(name,email)values(?,?)";  
//	    return jdbcTemplate.update(sql,new Object[]{emp.getName(),emp.getEmail()});  
	}


	@Override
	public void update(Emp emp) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
//		String sql="update EMPLOYEE set email='"+emp.getEmail()+"' where name='"+emp.getName()+"'";
//		return jdbcTemplate.update(sql);
	}


	@Override
	public void delete(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		Emp emp = (Emp)session.load(Emp.class,new String(name));
		session.delete(emp);
		
//		String sql="delete from EMPLOYEE where name=?";
//		return jdbcTemplate.update(sql,new Object[]{name});
	}


	@Override
	public Emp getEmpDetails(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.load(Emp.class,new String(name));
//		String sql="select * from EMPLOYEE where name=?";
//		return jdbcTemplate.queryForObject(sql,new Object[]{name},new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	
	

}
