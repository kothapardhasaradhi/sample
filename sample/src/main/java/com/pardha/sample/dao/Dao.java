package com.pardha.sample.dao;

import java.util.List;

import com.pardha.sample.modal.Emp;

public interface Dao {
	
	public List<Emp> getEmployees();
	public int save();
	//public String getEmail(String name);

}
