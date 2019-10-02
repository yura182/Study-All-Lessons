package student.service;

import student.domain.Student;
import java.util.Optional;

public interface StudentService {
    Student register(Student student);

    Student login(String email, String password);
}
