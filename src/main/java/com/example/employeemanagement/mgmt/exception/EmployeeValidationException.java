package com.example.employeemanagement.mgmt.exception;

public class EmployeeValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public EmployeeValidationException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

}