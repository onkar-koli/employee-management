package com.example.employeemanagement.mgmt.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.validation.OnlineValidation;
import com.example.employeemanagement.mgmt.validation.EmployeeValidator;
import com.example.employeemanagement.mgmt.validation.offlinevalidation.OfflineValidation;

@Service("employeeValidator")
public class EmployeeValidatorImpl implements EmployeeValidator{

	@Autowired
	private OfflineValidation offlineValidation;
	
	@Autowired
	private OnlineValidation onlineValidation;
	
	@Override
	public void validateManageVender(Employee employee) {
		
		offlineValidation.validateEmployee(employee);
		onlineValidation.validateEmployee(employee);
	
	}

}
