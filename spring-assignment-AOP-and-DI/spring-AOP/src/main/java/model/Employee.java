package model;

public class Employee {

	private int emp_id;
	private String emp_name;
	private int dep_id;
	private String dep;
	
	public Employee() {
		
	}
	public Employee(int emp_id,String emp_name,int dep_id,String dep)
	{
		this.emp_id=emp_id;
		this.emp_name=emp_name;
		this.dep_id=dep_id;
		this.dep=dep;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public void print() {
		System.out.println(this.emp_id+" : "+this.emp_name+" : "+this.dep_id+" : "+this.dep);
	}
	
}
