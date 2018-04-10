package xyz.comfyz.exceptions.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        this("Not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
