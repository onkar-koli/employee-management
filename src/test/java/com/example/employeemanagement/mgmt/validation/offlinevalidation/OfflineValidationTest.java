package com.example.employeemanagement.mgmt.validation.offlinevalidation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;
import com.example.employeemanagement.mgmt.validation.offlinevalidation.impl.OfflineValidationImpl;

public class OfflineValidationTest {
	
	@BeforeEach
	private void init() {
		
		MockitoAnnotations.openMocks(this);
	
	}
	
	@InjectMocks
	private OfflineValidationImpl offlineValidation;
	
	@Test
	public void validateEmployeeTest(){
	
		offlineValidation.validateEmployee(getEntity());
	
	}
	
	@Test
	public void validateEmployeeTest01(){
	
		Employee entity = getEntity();
		entity.setName("@##$");
		assertThrows(EmployeeValidationException.class, () -> {
			offlineValidation.validateEmployee(entity);
		});
		
	}
	
	@Test
	public void validateEmployeeTest02(){
		
		Employee entity = getEntity();
		entity.setPhoneNumber(100000055555555555l);
		assertThrows(EmployeeValidationException.class, () -> {
			offlineValidation.validateEmployee(entity);
		});
	
	}
	
	private Employee getEntity() {
	
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("abc");
		employee.setPhoneNumber(1234520500);
		employee.setExperiance(1.5f);
		employee.setSal(100000);
		employee.setTechnology("Java");
		employee.setCityName("Ichalkaranji");
		return employee;
	
	}

}