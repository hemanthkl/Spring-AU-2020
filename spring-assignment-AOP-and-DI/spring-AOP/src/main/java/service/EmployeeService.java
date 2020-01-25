package service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	@Qualifier("employee")
	
	public List<Employee> getAllEmployees(){
		List<Employee> emp_arr = new ArrayList<Employee>();
		emp_arr.add(new Employee(1,"Hemanth",101,"python" ));
		emp_arr.add(new Employee(2, "kirthi",102,"c"));
		emp_arr.add(new Employee(3, "manish", 103,"c++"));
		emp_arr.add(new Employee(4, "rafath", 104,"java"));

		return emp_arr;
	}
}