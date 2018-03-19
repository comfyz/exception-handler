package xyz.comfyz.rest.exceptions.exception;


public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        this("The server has rejected your operations");
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
