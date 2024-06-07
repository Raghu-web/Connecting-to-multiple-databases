package in.raghu.sql.EmployeeRepo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.raghu.sql.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

}
