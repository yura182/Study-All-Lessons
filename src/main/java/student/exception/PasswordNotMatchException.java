package student.exception;

public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException(String errorMessage) {
        super(errorMessage);
    }
}
