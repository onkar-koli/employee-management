package com.example.employeemanagement.mgmt.regularexpressions;

public interface RegularExpression {

	String azAz09 = "^[a-zA-Z0-9]*$";
	
	String Id = "^[0-9]*$";
	
	String azAz = "^[a-zA-Z]*$";
	
	String phoneNumber = "^\\d{10}$";

}
