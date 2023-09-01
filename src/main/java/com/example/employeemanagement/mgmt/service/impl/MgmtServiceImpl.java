package com.example.employeemanagement.mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.service.EmployeeDaoService;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;
import com.example.employeemanagement.mgmt.service.MgmtService;
import com.example.employeemanagement.mgmt.validation.EmployeeValidator;

@Service("mgmtService")
public class MgmtServiceImpl implements MgmtService {

	@Autowired
	private EmployeeValidator employeeValidator;

	@Autowired
	private EmployeeDaoService employeeDaoServices;

	@Override
	public ResponseEntity<?> addEmployeeEntity(Employee employee) {
		
		try {
			employeeValidator.validateManageVender(employee);
			employeeDaoServices.addEmployee(employee);
		} catch (EmployeeValidationException e1) {
			return new ResponseEntity<>(e1.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> getAllEmployee() {
		
		return new ResponseEntity<>(employeeDaoServices.getEmployee(), HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<?> getEmplById(long id) {
		
		return new ResponseEntity<>(employeeDaoServices.getEmployeeById(id), HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<?> deleteempl(long id) {
		
		employeeDaoServices.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<?> getEmployeeByName(String name) {
		
		return new ResponseEntity<>(employeeDaoServices.getEmployeeByName(name), HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<?> getEmpByPhone(long phoneNumber) {
		
		return new ResponseEntity<>(employeeDaoServices.getEmpByPhone(phoneNumber), HttpStatus.OK);
	
	}
}