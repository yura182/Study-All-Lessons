package student.service;

import student.domain.Student;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CheckEmail {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private CheckEmail() {
        throw new UnsupportedOperationException();
    }

    public static boolean checkCorrectness(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean checkExistence(String email, List<Student> students) {
        if (email == null) {
            return false;
        }
        for (Student student : students) {
            if (email.equals(student.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
