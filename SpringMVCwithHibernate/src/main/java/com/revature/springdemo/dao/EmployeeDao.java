package com.revature.springdemo.dao;

import java.util.List;

import com.revature.springdemo.model.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee e);
	public Employee getEmployeeById(int id);
	public List<Employee>getAllEmployee();
	public void updateEmployee(Employee e);
	public void deleteEmployee(int id);

}
