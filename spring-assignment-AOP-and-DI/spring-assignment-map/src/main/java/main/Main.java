package main;

import model.EmployeeMap;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String a[]){
        String xml = "spring.xml";
        ConfigurableApplicationContext context 
                                = new ClassPathXmlApplicationContext(xml);
        EmployeeMap map = (EmployeeMap) context.getBean("emp_map");
        map.print();
    }
}
