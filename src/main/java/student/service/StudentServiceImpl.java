package student.service;

import student.domain.Student;
import student.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student register(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Argument must be non-null");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student changePhone(Student student, String phone) {
        if (student == null) {
            throw new IllegalArgumentException("Argument student must be non-null");
        }

        return studentRepository.update(new Student(student, phone));
    }
}
