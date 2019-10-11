package lesson11.http;

public enum Status {
    OK(200), NOT_FOUND(404), SERVER_ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
