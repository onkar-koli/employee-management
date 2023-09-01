package com.example.employeemanagement.dao.validation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.repository.EmployeeRepository;
import com.example.employeemanagement.dao.validation.OnlineValidation;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;

@Service("onlineValidation")
public class OnlineValidationImpl implements OnlineValidation{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void validateEmployee(Employee employee) {
		
		List<Employee> list=(List<Employee>) employeeRepository.findAll();
		for (Employee employeeEntity : list) {
			if(employee.getName().equalsIgnoreCase(employeeEntity.getName())) {
				throw new EmployeeValidationException("Name is already present");
			}
			if(employee.getPhoneNumber()==employeeEntity.getPhoneNumber()) {
				throw new EmployeeValidationException("Phone Number is present");
			}
		}
		
	}	
}
