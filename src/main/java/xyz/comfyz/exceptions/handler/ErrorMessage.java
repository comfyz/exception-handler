package xyz.comfyz.exceptions.handler;


public class ErrorMessage {

    private String error;
    private String decs;

    public ErrorMessage() {
    }

    public ErrorMessage(ErrorCode error, String errorDescription) {
        this(error.toString(), errorDescription);
    }

    public ErrorMessage(String error, String errorDescription) {
        this.error = error;
        this.decs = errorDescription;
    }

    public String getError() {
        return error;
    }

    public String getDecs() {
        return decs;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }
}
