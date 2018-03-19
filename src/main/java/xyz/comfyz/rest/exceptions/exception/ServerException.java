package xyz.comfyz.rest.exceptions.exception;


public class ServerException extends RuntimeException {

    public ServerException() {
        this("Internal server error");
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
