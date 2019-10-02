package student.exception;

public class ArgumentIsNullException extends RuntimeException {
    public ArgumentIsNullException(String errorMessage) {
        super(errorMessage);
    }
}
