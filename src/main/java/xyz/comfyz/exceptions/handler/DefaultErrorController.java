package xyz.comfyz.exceptions.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class DefaultErrorController implements ErrorController {

    @Value("${server.error.path:${error.path:/error}}")
    String errorPath;

    @RequestMapping
    @ResponseBody
    public ResponseEntity<ErrorMessage> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        ErrorMessage message;
        if (status == HttpStatus.NOT_FOUND) {
//            getAttribute("javax.servlet.error.request_uri").toString()
            String desc = "Request uri '" + request.getRequestURI() + "' not found";
            message = new ErrorMessage(ErrorCode.NotFound, desc);
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
            String desc = request.getAttribute("javax.servlet.error.message").toString();
            message = new ErrorMessage(ErrorCode.InternalServerError, desc);
        } else {
            String desc = "Unknown error";
            message = new ErrorMessage(ErrorCode.InternalServerError, desc);
        }
        return new ResponseEntity<>(message, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.NOT_FOUND;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }
}
