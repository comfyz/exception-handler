package xyz.comfyz.exceptions.exception;


public class InvalidFieldException extends BadRequestException {

    private final String field;
    private final Object rejected;
    private final String message;

    public InvalidFieldException(String field, Object rejected, String message) {
        super(String.format("Field [%s:%s] is invalid, %s", field, rejected, message));
        this.field = field;
        this.rejected = rejected;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public Object getRejected() {
        return rejected;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
