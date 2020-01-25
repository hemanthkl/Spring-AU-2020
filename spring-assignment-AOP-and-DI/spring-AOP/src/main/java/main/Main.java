package main;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.Employee;
import service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	    EmployeeService ser = (EmployeeService) context.getBean(EmployeeService.class);
	    List<Employee> emp_List = ser.getAllEmployees();
	    for(Employee i : emp_List)
	    {
	    	i.print();
	    }
	    
	}
}
