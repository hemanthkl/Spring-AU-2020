package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import model.point;

@Configuration
@PropertySource("classpath:value.properties")
public class AppConfig {

	@Autowired
    Environment env;
	
	@Bean
	public point getPoint() {
		return new point(Integer.parseInt(env.getProperty("x_value")), Integer.parseInt(env.getProperty("y_value")));
	}
}
