package in.raghu.postgres.employeeAddressRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.raghu.postgres.entity.EmployeeDetails;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeDetails, Integer> {

}
