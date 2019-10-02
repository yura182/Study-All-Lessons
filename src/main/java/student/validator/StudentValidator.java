package student.validator;

import org.springframework.stereotype.Component;
import student.domain.Student;
import student.exception.ArgumentIsNullException;
import student.exception.FieldNotCorrectException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StudentValidator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String NAME_PATTERN = "[A-Za-z]{2,10}";
    private static final String SURNAME_PATTERN = "[A-Za-z]{2,20}";
    private static final String PASSWORD_PATTERN = "[A-Za-z0-9]{6,}";


    public void validate(Student student) {
        checkEmail(student.getEmail());
        checkName(student.getName());
        checkSurname(student.getSurname());
        checkPassword(student.getPassword());
    }

    private void checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new FieldNotCorrectException("Email is not correct");
        }
    }

    private void checkName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new FieldNotCorrectException("Name is not correct");
        }
    }

    private void checkSurname(String surname) {
        Pattern pattern = Pattern.compile(SURNAME_PATTERN);
        Matcher matcher = pattern.matcher(surname);
        if (!matcher.matches()) {
            throw new FieldNotCorrectException("Surname is not correct");
        }
    }

    private void checkPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new FieldNotCorrectException("Password is not correct");
        }
    }

    public void isNull(Object... objects) {
        for (Object obj : objects) {
            if (Objects.isNull(obj)) {
                throw new ArgumentIsNullException("Argument must be not null");
            }
        }
    }
}
