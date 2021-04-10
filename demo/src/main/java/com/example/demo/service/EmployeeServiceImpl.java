package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public void registerTest () {
		Employee emp = new Employee();
		
		emp.setName("Golang");
		emp.setStartDate(new Timestamp(System.currentTimeMillis()));
		emp.setTitle("NG Language");
		emp.setDeptName("High Performance");
		emp.setSalary(4433.25);
		
		repository.insertEmployee(emp);
		
		List<Employee> employeeList = repository.getEmployeeList();
		
		for (Employee tmp : employeeList) {
			System.out.println("res: " + tmp.toString());
		}
	}
}