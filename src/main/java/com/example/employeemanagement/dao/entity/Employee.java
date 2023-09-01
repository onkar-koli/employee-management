package com.example.employeemanagement.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ID")
	private long id;
	
	@Column(name= "NAME")
	private String name;
	
	@Column(name= "SALARY")
	private int sal;
	
	@Column(name="PHONE")
	private long phoneNumber;
	
	@Column(name="CITY")
	private String cityName;
	
	@Column(name="EXPERIANCE")
	private float experiance;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
}
