package money.jupiter.employeemanagement.services;

import money.jupiter.employeemanagement.models.EmployeeData;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface EmployeeService {
    ResponseEntity<EmployeeData> getEmployeeById(String employeeId);
    ResponseEntity<List<EmployeeData>> getAllEmployees();
    ResponseEntity<String> addEmployee(EmployeeData emp);
    ResponseEntity<String> dropEmployee(String employeeId);
    ResponseEntity<String> updateEmployee(EmployeeData emp);


}
