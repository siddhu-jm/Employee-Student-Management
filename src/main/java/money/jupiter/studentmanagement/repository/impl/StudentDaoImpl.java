package money.jupiter.studentmanagement.repository.impl;

import money.jupiter.studentmanagement.repository.StudentDao;
import money.jupiter.studentmanagement.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class StudentDaoImpl implements StudentDao {

    private List<Student> studentList = new ArrayList<Student>();


    @Override
    public List<Student> getStudents(){
        List<Student> studentList1 = studentList;
        return studentList1;
    }

    public ResponseEntity<Student> getStudentById(String id){

        return ResponseEntity.ok(studentList.stream()
                .filter(std -> std.getId().equals(id))
                .findFirst() // Get the first matched EmployeeData
                .orElse(null));


    }

    @Override
    public ResponseEntity<String> addStudent(Student stud){

        studentList.add(stud);
        return  ResponseEntity.ok("Student added Successfully");
    }

    @Override
    public ResponseEntity<String> deleteStudent(String id){

        studentList = (ArrayList<Student>) studentList.stream()
                                        .filter(std -> !std.getId().equals(id))
                                        .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<String> updateStudent(Student student){

        int index= studentList.indexOf(studentList.stream()
                .filter(stud -> stud.getId().equals(stud.getId()))
                .findFirst()
                .orElse(null));
        studentList.set(index,student);

//        int ind = list.indexOf(student);
//        list.set(ind,student);
//        for (Student std : list){
//            if (std.getRoll() == student.getRoll()){
//                list.remove(std);
//                list.add(student);
//                break;
//            }
//        }

        return ResponseEntity.ok("updated student successfully");
    }

}
