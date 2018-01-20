package com.pardha.sample.dao;

import java.util.List;

import com.pardha.sample.modal.Emp;

public interface Dao {
	
	public List<Emp> getEmployees();
	public int save(Emp emp);
	public int update(Emp emp);
	public int delete(String name);
	public Emp getEmpDetails(String name);
	
}
