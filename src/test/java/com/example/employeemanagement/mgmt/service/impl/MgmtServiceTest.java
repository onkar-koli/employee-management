package com.example.employeemanagement.mgmt.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.service.EmployeeDaoService;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;
import com.example.employeemanagement.mgmt.validation.EmployeeValidator;

public class MgmtServiceTest {

	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	private MgmtServiceImpl mgmtService;

	@Mock
	private EmployeeValidator employeeValidator;

	@Mock
	private EmployeeDaoService employeeDaoServices;

	@Test
	public void addEmployeeEntityTest() {
		
		ResponseEntity<?> res = new ResponseEntity<>(HttpStatus.OK);
		doNothing().when(employeeValidator).validateManageVender(Mockito.any());
		when(employeeDaoServices.addEmployee(Mockito.any())).thenReturn(getEntity());
		ResponseEntity<?> entity = mgmtService.addEmployeeEntity(getEntity());
		assertEquals(res.getStatusCode(), entity.getStatusCode());
	
	}
	
	@Test
	public void addEmployeeEntityTest01() {
	
		ResponseEntity<?> res = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		doNothing().when(employeeValidator).validateManageVender(Mockito.any());
		when(employeeDaoServices.addEmployee(Mockito.any())).thenThrow(EmployeeValidationException.class);
		ResponseEntity<?> entity = mgmtService.addEmployeeEntity(getEntity());
		assertEquals(res.getStatusCode(), entity.getStatusCode());
	
	}
	
	@Test
	public void addEmployeeEntityTest02() {
	
		ResponseEntity<?> res = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		doNothing().when(employeeValidator).validateManageVender(Mockito.any());
		when(employeeDaoServices.addEmployee(Mockito.any())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = mgmtService.addEmployeeEntity(getEntity());
		assertEquals(res.getStatusCode(), entity.getStatusCode());
	
	}
	
	@Test
	public void getAllEmployeeTest() {
	
		when(employeeDaoServices.getEmployee()).thenReturn(Collections.singletonList(getEntity()));
		ResponseEntity<?> entity = mgmtService.getAllEmployee();
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void getEmplByIdTest() {
	
		when(employeeDaoServices.getEmployeeById(Mockito.anyLong())).thenReturn(Collections.singletonList(getEntity()));
		ResponseEntity<?> entity = mgmtService.getEmplById(1l);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}
	
	@Test
	public void deleteemplTest() {
	
		doNothing().when(employeeDaoServices).deleteEmployee(Mockito.anyLong());
		ResponseEntity<?> entity = mgmtService.deleteempl(1l);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}
	
	@Test
	public void getEmployeeByNameTest() {
	
		when(employeeDaoServices.getEmployeeByName(Mockito.anyString())).thenReturn(Collections.singletonList(getEntity()));
		ResponseEntity<?> entity = mgmtService.getEmployeeByName("abc");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void getEmpByPhoneTest() {
	
		when(employeeDaoServices.getEmpByPhone(Mockito.anyLong())).thenReturn(getEntity());
		ResponseEntity<?> entity = mgmtService.getEmpByPhone(12345l);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

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