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
}
