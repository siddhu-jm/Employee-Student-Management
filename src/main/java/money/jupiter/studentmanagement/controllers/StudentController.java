package money.jupiter.studentmanagement.controllers;


import money.jupiter.studentmanagement.models.Student;
import money.jupiter.studentmanagement.services.StudentService;
import money.jupiter.studentmanagement.services.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudent () {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student>  getStudentById(@PathVariable String id ){
        return studentService.getStudentById(id);
    }
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student ) {
         return studentService.addStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/students")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

}
