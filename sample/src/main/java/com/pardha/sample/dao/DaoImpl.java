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
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> getEmployees() {

		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Emp").list();

		// return jdbcTemplate.query("select * from employee",new
		// BeanPropertyRowMapper<Emp>(Emp.class));

	}

	@Override
	public void save(Emp emp) {

		Session session = sessionFactory.getCurrentSession();
		session.persist(emp);

		// String sql="insert into EMPLOYEE(name,email)values(?,?)";
		// return jdbcTemplate.update(sql,new
		// Object[]{emp.getName(),emp.getEmail()});
	}

	@Override
	public void update(Emp emp) {

		Session session = sessionFactory.getCurrentSession();
		System.out.println(emp.getId()+"ssssssssssssssssssssssssss");
		session.update(emp);
		// String sql="update EMPLOYEE set email='"+emp.getEmail()+"' where
		// name='"+emp.getName()+"'";
		// return jdbcTemplate.update(sql);
	}

	@Override
	public void delete(int empId) {

		Session session = sessionFactory.getCurrentSession();
		Emp emp = (Emp) session.load(Emp.class, empId);
		session.delete(emp);

		// String sql="delete from EMPLOYEE where name=?";
		// return jdbcTemplate.update(sql,new Object[]{name});
	}

	@Override
	public Emp getEmpDetails(int empId) {

		Session session = sessionFactory.getCurrentSession();
		return session.get(Emp.class,empId);
		// String sql="select * from EMPLOYEE where name=?";
		// return jdbcTemplate.queryForObject(sql,new Object[]{name},new
		// BeanPropertyRowMapper<Emp>(Emp.class));
	}

}
