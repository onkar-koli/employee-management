package com.example.employeemanagement.dao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.dao.repository.EmployeeRepository;
import com.example.employeemanagement.dao.service.impl.EmployeeDaoServiceImpl;

public class EmployeeDaoServiceImplTest {
	
	@InjectMocks
	private EmployeeDaoServiceImpl employeeDaoServiceImpl; 
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void getEmployeeTest() {
		
		when(employeeRepository.findAll()).thenReturn(Collections.singletonList(getEntity()));
		List<Employee> employees = employeeDaoServiceImpl.getEmployee();
		assertEquals(getEntity().getId(), employees.get(0).getId());
	
	}
	
	@Test
	public void getEmployeeByIdTest() {
	
		when(employeeRepository.getEmployee(Mockito.anyLong())).thenReturn(Collections.singletonList(getEntity()));
		List<Employee> employee = employeeDaoServiceImpl.getEmployeeById(1l);
		assertEquals(getEntity().getId(), employee.get(0).getId());
	
	}
	
	@Test
	public void addEmployeeTest() {
	
		when(employeeRepository.save(Mockito.any())).thenReturn(getEntity());
		Employee employee = employeeDaoServiceImpl.addEmployee(getEntity());
		assertEquals(getEntity().getId(), employee.getId());
	
	}
	
	@Test
	public void deleteEmployeeTest() {
	
		doNothing().when(employeeRepository).deleteById(Mockito.anyLong());
		employeeDaoServiceImpl.deleteEmployee(1l);

	}
	
	@Test
	public void getEmployeeByNameTest() {
	
		when(employeeRepository.getEmployeeByName(Mockito.anyString())).thenReturn(Collections.singletonList(getEntity()));
		List<Employee> employee = employeeDaoServiceImpl.getEmployeeByName("abc");
		assertEquals(getEntity().getId(), employee.get(0).getId());
	
	}

	@Test
	public void getEmpByPhoneTest() {
	
		when(employeeRepository.getEmpByPhone(Mockito.anyLong())).thenReturn(getEntity());
		Employee employee = employeeDaoServiceImpl.getEmpByPhone(12345);
		assertEquals(getEntity().getPhoneNumber(), employee.getPhoneNumber());
		assertEquals(getEntity().getSal(), employee.getSal());
		assertEquals(getEntity().getExperiance(), employee.getExperiance());
		assertEquals(getEntity().getCityName(), employee.getCityName());
		assertEquals(getEntity().getTechnology(), employee.getTechnology());

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