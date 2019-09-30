package student.service;

import student.domain.Faculty;
import student.domain.Group;
import student.domain.Level;
import student.domain.Student;

import java.util.List;

public interface UniversityService {
    public List<Student> getAll();

    public List<Student> getFacultyStudents(Faculty faculty);

    public List<Student> getFacultyAndLevelStudents(Faculty faculty, Level level);

    public List<Student> getStudentsBornAfter(int year);

    public List<Student> getStudentsOfGroup(Group group);



}
