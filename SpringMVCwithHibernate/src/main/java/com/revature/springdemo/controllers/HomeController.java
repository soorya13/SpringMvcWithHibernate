package com.revature.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.springdemo.model.Employee;
import com.revature.springdemo.service.EmployeeService;

@Controller
public class HomeController {
	@Autowired
	EmployeeService empservice;

	@RequestMapping(value = { "/", "/employee" }, method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("emp", new Employee());
		model.addAttribute("listemployee", empservice.getAllEmployee());
		return "index";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("emp")Employee e) {

		if (e.getId() == 0) {
			// new person, add it
			empservice.addEmployee(e);
		} else {
			// existing person, call update
			empservice.updateEmployee(e);
		}

		return "redirect:/employee";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		empservice.deleteEmployee(id);
		return "redirect:/employee";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("emp", empservice.getEmployeeById(id));
		model.addAttribute("listemployee", empservice.getAllEmployee());
		System.out.println("All done");
	
		return "index";
	}

}
