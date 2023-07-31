package money.jupiter.studentmanagement.services.impl;

import money.jupiter.studentmanagement.repository.StudentDao;
import money.jupiter.studentmanagement.models.Student;
import money.jupiter.studentmanagement.repository.impl.StudentDaoImpl;
import money.jupiter.studentmanagement.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public ResponseEntity<List<Student>> getStudents() {
        return (ResponseEntity<List<Student>>) ResponseEntity.ok(studentDao.getStudents());
    }

    public ResponseEntity<Student> getStudentById(String id){

        if(!studentDao.getStudents().isEmpty() && studentDao.getStudents().stream()
                .anyMatch(std -> std.getId()
                .equals(id)))
        {
            return studentDao.getStudentById(id);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<String> addStudent(Student student) {


        if(student.getStd() == ' ' || student.getFirstName().isEmpty() || student.getLastName().isEmpty() ){
            return  ResponseEntity.badRequest().body("Enter Student details");
        }
        else{
            student.setId(UUID.randomUUID().toString());
            return studentDao.addStudent(student);
        }

    }

    public ResponseEntity<String> deleteStudent(String id){

        if(studentDao.getStudents().stream()
                .anyMatch(std -> std.getId()
                .equals(id)))
        {
            return studentDao.deleteStudent(id);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<String> updateStudent(Student student){

        if(studentDao.getStudents().stream()
                .anyMatch(std -> std.getId()
                .equals(student.getId())))
        {
            return studentDao.updateStudent(student);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
