package com.example.employeemanagement.dao.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.repository.EmployeeRepository;
import com.example.employeemanagement.dao.service.EmployeeDaoService;

@Service("employeeDaoServices")
public class EmployeeDaoServiceImpl implements EmployeeDaoService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployee() {
		
		return (List<Employee>) employeeRepository.findAll();
	
	}

	@Override
	public List<Employee> getEmployeeById(long id) {
	
		return employeeRepository.getEmployee(id);
	
	}

	@Override
	public Employee addEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	
	}

	@Override
	public void deleteEmployee(long id) {
	
		employeeRepository.deleteById(id);
	
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
	
		return employeeRepository.getEmployeeByName(name);
	
	}

	@Override
	public Employee getEmpByPhone(long phoneNumber) {
	
		return employeeRepository.getEmpByPhone(phoneNumber);
	
	}

}