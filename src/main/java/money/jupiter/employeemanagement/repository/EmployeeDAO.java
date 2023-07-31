package money.jupiter.employeemanagement.repository;
import money.jupiter.employeemanagement.models.EmployeeData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {
    EmployeeData getEmployeeById(String employeeId);
    List<EmployeeData> getAllEmployees();
    ResponseEntity<String> postData(EmployeeData emp);
    ResponseEntity<String> dropEmployee(String employeeId);
    ResponseEntity<String> updateEmployee(EmployeeData emp);
}
