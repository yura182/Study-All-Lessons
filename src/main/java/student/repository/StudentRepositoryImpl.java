package student.repository;

import org.springframework.stereotype.Repository;
import student.domain.Student;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<Long, Student> idToStudents = new HashMap<>();

    @Override
    public Student save(Student student) {
        return idToStudents.put(student.getId(), student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(idToStudents.get(id));
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.ofNullable(idToStudents.replace(student.getId(), student));
    }

    @Override
    public Optional<Student> deleteById(Long id) {
        return Optional.ofNullable(idToStudents.remove(id));
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(idToStudents.values());
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        Optional<Student> student = getAll().stream()
                .filter(s -> s.getEmail().equals(email))
                .findAny();
        return student;
    }
}
