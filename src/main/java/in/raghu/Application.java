package in.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.raghu.postgres.entity.EmployeeDetails;
import in.raghu.service.EmployeeService;
import in.raghu.sql.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService bean = context.getBean(EmployeeService.class);
		bean.createEmployee(new Employee(), new EmployeeDetails());
	}

}
