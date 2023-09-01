package com.example.employeemanagement.dao.service;

import java.util.List;

import com.example.employeemanagement.dao.entity.Employee;

public interface EmployeeDaoService {
	
	public List<Employee> getEmployee();

	public List<Employee> getEmployeeById(long id);

	public Employee addEmployee(Employee employee);

	public void deleteEmployee(long id);

	public List<Employee> getEmployeeByName(String name);

	public Employee getEmpByPhone(long phoneNumber);

}
