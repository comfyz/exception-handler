package xyz.comfyz.exceptions.handler;


public class ErrorMessage {

    private String error;
    private String description;

    public ErrorMessage() {
    }

    public ErrorMessage(ErrorCode error, String errorDescription) {
        this(error.toString(), errorDescription);
    }

    public ErrorMessage(String error, String errorDescription) {
        this.error = error;
        this.description = errorDescription;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
