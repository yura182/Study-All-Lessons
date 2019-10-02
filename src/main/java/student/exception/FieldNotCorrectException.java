package student.exception;

public class FieldNotCorrectException extends RuntimeException {

    public FieldNotCorrectException(String errorMessage) {
        super(errorMessage);
    }
}
