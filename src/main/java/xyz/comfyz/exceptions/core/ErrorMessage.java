package xyz.comfyz.exceptions.core;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel("错误消息")
public class ErrorMessage {

    @ApiModelProperty("错误代码")
    private final int code;
    @ApiModelProperty("错误类别")
    private final String type;
    @ApiModelProperty("错误消息")
    private final String msg;

    public ErrorMessage(HttpStatus status, String msg) {
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
