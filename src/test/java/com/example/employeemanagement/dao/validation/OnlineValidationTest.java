package com.example.employeemanagement.dao.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.repository.EmployeeRepository;
import com.example.employeemanagement.dao.validation.impl.OnlineValidationImpl;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;

public class OnlineValidationTest {
	
	@InjectMocks
	private OnlineValidationImpl onlineValidation;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void validateEmployeeTest() {
		
		Employee entity = getEntity();
		entity.setName("xyz");
		entity.setPhoneNumber(32516);
		when(employeeRepository.findAll()).thenReturn(Collections.singletonList(entity));
		onlineValidation.validateEmployee(getEntity());
	
	}
	
	@Test
	public void validateEmployeeTest01() {
	
		Employee entity = getEntity();
		when(employeeRepository.findAll()).thenReturn(Collections.singletonList(entity));
		assertThrows(EmployeeValidationException.class, () -> {
			onlineValidation.validateEmployee(getEntity());
		});
	
	}
	
	@Test
	public void validateEmployeeTest02() {
	
		Employee entity = getEntity();
		entity.setName("xyz");
		when(employeeRepository.findAll()).thenReturn(Collections.singletonList(entity));
		assertThrows(EmployeeValidationException.class, ()->{
			onlineValidation.validateEmployee(getEntity());			
		});
	
	}
	
	private Employee getEntity() {
	
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("abc");
		employee.setPhoneNumber(123452);
		employee.setExperiance(1.5f);
		employee.setSal(100000);
		employee.setTechnology("Java");
		employee.setCityName("Ichalkaranji");
		return employee;
	
	}

}