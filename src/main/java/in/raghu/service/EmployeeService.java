package in.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.raghu.postgres.employeeAddressRepo.EmployeeAddressRepository;
import in.raghu.postgres.entity.EmployeeDetails;
import in.raghu.sql.EmployeeRepo.EmployeeRepository;
import in.raghu.sql.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private EmployeeAddressRepository empAddressRepo;
	
	
	
	public void createEmployee(Employee emp, EmployeeDetails empDetails) {
		emp.setName("Hari");
		emp.setSalary(25000.00);
		emp.setDesignation("Engineer");
		empRepo.save(emp);
		empDetails.setCountry("India");
		empDetails.setPincode("523001");
		empDetails.setState("AP");
		empAddressRepo.save(empDetails);
		
	}
	
}
