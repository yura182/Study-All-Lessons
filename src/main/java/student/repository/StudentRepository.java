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
    List<Student> getFacultyStudents(Faculty faculty);
    List<Student> getFacultyAndLevelStudents(Faculty faculty, Level level);
    List<Student> getStudentsBornAfter(int year);
    List<Student> getStudentsOfGroup(Group group);

}
