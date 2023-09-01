package com.example.employeemanagement.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.example.employeemanagement.dao.entity.Employee;

public interface MgmtService {

	public ResponseEntity<?> addEmployeeEntity(Employee employee);

	public ResponseEntity<?> getAllEmployee();

	public ResponseEntity<?> getEmplById(long id);

	public ResponseEntity<?> deleteempl(long id);

	public ResponseEntity<?> getEmployeeByName(String name);

	public ResponseEntity<?> getEmpByPhone(long phoneNumber);

}
