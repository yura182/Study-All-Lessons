package student.service;

import org.springframework.beans.factory.annotation.Autowired;
import student.domain.Faculty;
import student.domain.Group;
import student.domain.Level;
import student.domain.Student;
import student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public List<Student> getFacultyStudents(Faculty faculty) {
        List<Student> studentsOfFaculty = new ArrayList<>();
        List<Student> students = getAll();

        for (Student student : students) {
            if (faculty == student.getFaculty()) {
                studentsOfFaculty.add(student);
            }
        }
        return studentsOfFaculty;
    }

    @Override
    public List<Student> getFacultyAndLevelStudents(Faculty faculty, Level level) {
        List<Student> studentsOfFacultyAndLevel = new ArrayList<>();
        List<Student> studentsOfFaculty = getFacultyStudents(faculty);

        for (Student student : studentsOfFaculty) {
            if (level == student.getLevel()) {
                studentsOfFacultyAndLevel.add(student);
            }
        }
        return studentsOfFacultyAndLevel;
    }

    @Override
    public List<Student> getStudentsBornAfter(int year) {
        List<Student> studentsBornAfter = new ArrayList<>();
        List<Student> students = getAll();

        for (Student student : students) {
            if (Objects.nonNull(student.getBirthDate())
                    && student.getBirthDate().getYear() > year) {
                studentsBornAfter.add(student);
            }
        }
        return studentsBornAfter;
    }

    @Override
    public List<Student> getStudentsOfGroup(Group group) {
        List<Student> studentsOfGroup = new ArrayList<>();
        List<Student> students = getAll();

        for (Student student : students) {
            if (group == student.getGroup()) {
                studentsOfGroup.add(student);
            }
        }
        return studentsOfGroup;
    }
}
