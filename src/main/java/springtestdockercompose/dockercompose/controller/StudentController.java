package springtestdockercompose.dockercompose.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springtestdockercompose.dockercompose.entity.Student;
import springtestdockercompose.dockercompose.service.StudentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/create")
public class StudentController {
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createUser(@RequestBody Student student){
       Student user= studentService.createStudent(student);
       return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable("id") Long studentId){
        Student user = studentService.getUserById(studentId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllUser(){
        List<Student> allstudent= studentService.getAllUser();
        return ResponseEntity.ok(allstudent);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateUser(@PathVariable("id") Long studentId,@RequestBody Student student){
        Student update= studentService.updateStudent(studentId,student);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return "This user with this Id was delete";
    }
}
