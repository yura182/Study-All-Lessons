package student.view;

import student.domain.Student;

import java.util.List;

public interface Validator {
    boolean checkEmailCorrectness(String email);

    boolean checkEmailExistence(String email, List<Student> students);

    boolean checkName(String name);
}
