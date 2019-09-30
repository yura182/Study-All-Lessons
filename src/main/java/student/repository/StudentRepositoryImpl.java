package student.repository;

import student.domain.Faculty;
import student.domain.Group;
import student.domain.Level;
import student.domain.Student;

import java.util.*;

public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> idToStudents = new HashMap<>();

    @Override
    public Student save(Student student) {
        return idToStudents.put(student.getId(), student);
    }

    @Override
    public Student findById(Long id) {
        return idToStudents.get(id);
    }

    @Override
    public Student update(Student student) {
        return idToStudents.replace(student.getId(), student);
    }

    @Override
    public Student deleteById(Long id) {
        return idToStudents.remove(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(idToStudents.values());
    }

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
