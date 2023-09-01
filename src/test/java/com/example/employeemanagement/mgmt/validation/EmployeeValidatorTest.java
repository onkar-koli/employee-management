package com.example.employeemanagement.mgmt.validation;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.validation.OnlineValidation;
import com.example.employeemanagement.mgmt.validation.impl.EmployeeValidatorImpl;
import com.example.employeemanagement.mgmt.validation.offlinevalidation.OfflineValidation;

public class EmployeeValidatorTest {
	
	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@InjectMocks
	private EmployeeValidatorImpl employeeValidator;
	
	@Mock
	private OfflineValidation offlineValidation;
	
	@Mock
	private OnlineValidation onlineValidation;
	
	@Test
	public void validateManageVender() {
		
		doNothing().when(offlineValidation).validateEmployee(Mockito.any());
		doNothing().when(onlineValidation).validateEmployee(Mockito.any());
		employeeValidator.validateManageVender(new Employee());
	
	}

}
