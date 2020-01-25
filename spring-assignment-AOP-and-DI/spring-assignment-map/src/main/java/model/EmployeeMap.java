package model;

import java.util.Map;

public class EmployeeMap {
	private Map<Integer,Employee> emp_map;
	public Map<Integer, Employee> getEmp_map() {
		return emp_map;
	}
	public void setEmp_map(Map<Integer, Employee> emp_map) {
		this.emp_map = emp_map;
	}
	public void print() {
		for(Map.Entry<Integer, Employee> e: emp_map.entrySet()) {
			System.out.println(e.getValue().getEmp_id()+"  :  "+e.getValue().getEmp_name());
		}
	}
}
