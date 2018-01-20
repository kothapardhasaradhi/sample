package com.pardha.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pardha.sample.dao.Dao;
import com.pardha.sample.modal.Emp;



@RestController
public class SpringController {
	
	@Autowired
	Dao dao;
	
	@RequestMapping("/home")
	public ModelAndView getAllMembers(){
		
		List<Emp> list = dao.getEmployees();
		return new ModelAndView("viewemp","list",list);
	}
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Emp emp){
		int i = dao.save(emp);
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping("/empform")
	public ModelAndView empform(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("empform");
		model.addObject("message", "AddDetails");
		model.addObject("submit_value", "Save");
		model.addObject("command",new Emp());
		return model;
		
	}
	
	@RequestMapping("/edit/{name}")
	public ModelAndView edit(@PathVariable String name){
		Emp emp = dao.getEmpDetails(name);
		ModelAndView model = new ModelAndView();
		model.setViewName("empform");
		model.addObject("message", "Edit your Details");
		model.addObject("submit_value", "Update");
		model.addObject("command",emp);
		return model; 
	}
	
	@RequestMapping(value="/edit/save")
	public ModelAndView update(@ModelAttribute Emp emp){
		
		int i= dao.update(emp);
		return new ModelAndView("redirect:/home");	
	}
	
	@RequestMapping(value="/delete/{name}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String	name){
		dao.delete(name);
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping("/")
	public Emp hello(){
		System.out.println("HELLOOOO");
		//return dao.
		Emp emp = new Emp();
		emp.setEmail("AAA@gmail.com");
		emp.setName("aaaaa");
		return emp;
		
	}

}
