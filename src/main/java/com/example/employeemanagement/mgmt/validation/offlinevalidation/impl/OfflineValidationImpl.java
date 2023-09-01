package com.example.employeemanagement.mgmt.validation.offlinevalidation.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dao.entity.Employee;
import com.example.employeemanagement.mgmt.exception.EmployeeValidationException;
import com.example.employeemanagement.mgmt.regularexpressions.RegularExpression;
import com.example.employeemanagement.mgmt.validation.offlinevalidation.OfflineValidation;

@Service("offlineValidation")
public class OfflineValidationImpl implements OfflineValidation {

	public void validateEmployee(Employee employee) {

		if (!Pattern.matches(RegularExpression.azAz, employee.getName())) {
			throw new EmployeeValidationException("Name is not correct");
		}
		if (!Pattern.matches(RegularExpression.phoneNumber, Long.toString(employee.getPhoneNumber()))) {
			throw new EmployeeValidationException("Phone number is not correct");
		}
		
	}
}

		/*public boolean checkName(String name) {
			// TODO Auto-generated method stub
			int namespecial=0;
			for(int i=0;i<name.length();i++) {
				if((name.charAt(i)>=65 && name.charAt(i)<=90) || (name.charAt(i)>=97 && name.charAt(i)<125)){
				
				}
				else{
					namespecial++;
				}
			}
			if(namespecial==0)
				return true;
			return false;
		}

		public boolean checkPhoneNumber(long phoneNumber) {
			// TODO Auto-generated method stub
			String phone= Long.toString(phoneNumber);
			int phoneSpecial=0;
			if(phone.length()==10) {
			for(int j=0;j<phone.length();j++) {
				if(phone.charAt(j)>='0' && phone.charAt(j)<='9'){
				
				}
				else{
					phoneSpecial++;
				}
			}
			if(phoneSpecial==0)
				return true;
			return false;
			}
			else
				return false;
		}

		public boolean checkExperiance(float experiance) {
			// TODO Auto-generated method stub
			if(experiance<0.0f) {
				return false;
			}
			return true;
		}
		
	}*/