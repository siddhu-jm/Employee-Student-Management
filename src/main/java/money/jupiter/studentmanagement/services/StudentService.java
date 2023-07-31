package money.jupiter.studentmanagement.services;

import money.jupiter.studentmanagement.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    ResponseEntity<List<Student>> getStudents();

    ResponseEntity<Student> getStudentById(String id);
    ResponseEntity<String> addStudent(Student student);

    ResponseEntity<String> deleteStudent(String id);

    ResponseEntity<String> updateStudent(Student student);

}
