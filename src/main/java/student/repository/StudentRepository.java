package student.repository;

import student.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(Long id);

    Optional<Student> update(Student student);

    Optional<Student> deleteById(Long id);

    List<Student> getAll();

    Optional<Student> findByEmail(String email);
}
