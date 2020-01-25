package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import model.Employee;

@Configuration
@ComponentScan("service")
public class AppConfig {
	
	@Autowired
	@Bean
	public Employee getEmployee() {
		Employee emp = new Employee(1, "h",9,"l");
		return emp;
	}
}
