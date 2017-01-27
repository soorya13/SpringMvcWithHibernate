package com.revature.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.springdemo.dao.EmployeeDao;
import com.revature.springdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao empd;

	@Transactional
	public void addEmployee(Employee e) {
		empd.addEmployee(e);

	}
	
	@Transactional
	public Employee getEmployeeById(int id) {

		return empd.getEmployeeById(id);
	}
	@Transactional
	public List<Employee> getAllEmployee() {

		return empd.getAllEmployee();
	}
	
	@Transactional
	public void updateEmployee(Employee e) {

		empd.updateEmployee(e);
	}
	
	@Transactional
	public void deleteEmployee(int id) {
		empd.deleteEmployee(id);

	}

}
