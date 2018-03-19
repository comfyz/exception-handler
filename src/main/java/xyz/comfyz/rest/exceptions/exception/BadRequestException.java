package xyz.comfyz.rest.exceptions.exception;


public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        this("Bad request");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
