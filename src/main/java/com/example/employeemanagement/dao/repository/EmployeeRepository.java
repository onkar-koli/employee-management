package com.example.employeemanagement.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.dao.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select e FROM Employee e WHERE id= :Id")
	public List<Employee> getEmployee(@Param("Id") Long ID);
	
	@Query("select e FROM Employee e WHERE name= :n")
	public List<Employee> getEmployeeByName(@Param("n") String name);
	
	@Query("select e FROM Employee e WHERE phoneNumber= :phone")
	public Employee getEmpByPhone(@Param("phone") Long Phone);
	
}
