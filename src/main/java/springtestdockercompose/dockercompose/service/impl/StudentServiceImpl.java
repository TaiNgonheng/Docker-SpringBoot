package springtestdockercompose.dockercompose.service.impl;

import lombok.*;
import org.springframework.stereotype.Service;
import springtestdockercompose.dockercompose.entity.Student;
import springtestdockercompose.dockercompose.repository.StudentRepository;
import springtestdockercompose.dockercompose.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getUserById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAllUser() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student newUser = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("This Id is not exist"));
        newUser.setFirstname(student.getFirstname());
        newUser.setLastname(student.getLastname());
        Student user = studentRepository.save(newUser);
        return user;
    }

    @Override
    public void deleteStudent(Long studentId) {
       studentRepository.deleteById(studentId);
    }
}
