package xyz.comfyz.rest.exceptions.handler;


import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private final int code;
    private final String type;
    private final String msg;

    public ErrorMessage(HttpStatus status, String msg) {
        this(status.value(), status.getReasonPhrase(), msg);
    }

    public ErrorMessage(xyz.comfyz.rest.exceptions.handler.HttpStatus status, String msg) {
        this(status.value(), status.getReasonPhrase(), msg);
    }

    public ErrorMessage(int code, String type, String msg) {
        this.code = code;
        this.type = type;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }
}
