package Aspect;


import java.time.Duration;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	private LocalDateTime bf,af;
	@Before("execution(* service.EmployeeService.getAllEmployees())")
	public void logBeforeV1(JoinPoint joinPoint) {
		bf = LocalDateTime.now();
	}
	@After("execution(* service.EmployeeService.getAllEmployees())")
	public void logAfterV1(JoinPoint joinPoint) {
		af = LocalDateTime.now();
		Duration Time_elapsed = Duration.between(bf, af);
		System.out.println("Time_elapsed in nano sec : " + Time_elapsed.getNano() + " ns");
	}
}
