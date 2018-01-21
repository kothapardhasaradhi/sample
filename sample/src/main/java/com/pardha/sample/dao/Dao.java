package com.pardha.sample.dao;

import java.util.List;

import com.pardha.sample.modal.Emp;

public interface Dao {
	
	public List<Emp> getEmployees();
	public void save(Emp emp);
	public void update(Emp emp);
	public void delete(String name);
	public Emp getEmpDetails(String name);
	
}
