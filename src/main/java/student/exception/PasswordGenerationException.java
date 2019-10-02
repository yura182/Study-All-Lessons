package student.exception;

public class PasswordGenerationException extends RuntimeException {

    public PasswordGenerationException(String errorMessage) {
        super(errorMessage);
    }
}
