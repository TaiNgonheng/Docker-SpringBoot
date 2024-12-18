package springtestdockercompose.dockercompose.service;

import springtestdockercompose.dockercompose.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getUserById(Long studentId);
    List<Student> getAllUser();
    Student updateStudent(Long studentId, Student student);
    void deleteStudent(Long studentId);
}
