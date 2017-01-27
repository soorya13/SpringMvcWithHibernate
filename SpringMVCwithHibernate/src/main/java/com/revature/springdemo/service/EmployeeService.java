package com.revature.springdemo.service;

import java.util.List;

import com.revature.springdemo.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee e);
	public Employee getEmployeeById(int id);
	public List<Employee>getAllEmployee();
	public void updateEmployee(Employee e);
	public void deleteEmployee(int id);

}
