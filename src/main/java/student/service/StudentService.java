package student.service;

import student.domain.Student;

public interface StudentService {
    Student register(Student student);
    Student changePhone(Student student, String phone);
}
