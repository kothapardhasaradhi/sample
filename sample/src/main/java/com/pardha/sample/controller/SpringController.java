package com.pardha.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pardha.sample.dao.Dao;
import com.pardha.sample.modal.Emp;

@RestController
public class SpringController {
	
	@Autowired
	Dao dao;
	
	@GetMapping("/home")
	public ModelAndView getAllMembers(){
		
		List<Emp> list = dao.getEmployees();
		return new ModelAndView("viewemp","list",list);
	}
	@RequestMapping("/save")
	public void save(){
		int i = dao.save();
	}
	
	
	
	@RequestMapping("/")
	public Emp hello(){
		System.out.println("HELLOOOO");
		//return dao. dsvkmd
		Emp emp = new Emp();
		emp.setEmail("AAA@gmail.com");
		emp.setName("aaaaa");
		return emp;
		
	}

}
