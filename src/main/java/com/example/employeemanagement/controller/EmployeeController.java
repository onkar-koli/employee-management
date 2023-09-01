package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.mgmt.service.MgmtService;

@RestController
public class EmployeeController {

	@Autowired
	private MgmtService mgmtService;
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployees(){
		
		return mgmtService.getAllEmployee();
	
	}
	
	@GetMapping("/employee/{employeeid}")
	public ResponseEntity<?> getEmployeeById(@PathVariable String employeeid) {
	
		return mgmtService.getEmplById(Long.parseLong(employeeid));
	
	}
	
	@GetMapping("/employee/name/{name}")
	public ResponseEntity<?> getEmployeeByName(@PathVariable String name){
	
		return mgmtService.getEmployeeByName(name);
	
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
	
		return mgmtService.addEmployeeEntity(employee);
	
	}
	
	@DeleteMapping("/employee/{employeeid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String employeeid) {
	
		return mgmtService.deleteempl(Long.parseLong(employeeid));
	
	}
	
	@GetMapping("/employee/phone/{phonenumber}")
	public ResponseEntity<?> getEmpByPhone(@PathVariable String phonenumber){
	
		return mgmtService.getEmpByPhone(Long.parseLong(phonenumber));
	
	}
	
}