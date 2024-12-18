package springtestdockercompose.dockercompose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springtestdockercompose.dockercompose.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
