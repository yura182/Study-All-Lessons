package student.repository;

import student.domain.Faculty;
import student.domain.Group;
import student.domain.Level;
import student.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);

    Student findById(Long id);

    Student update(Student student);

    Student deleteById(Long id);

    List<Student> getAll();
}
