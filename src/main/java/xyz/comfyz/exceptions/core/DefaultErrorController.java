package xyz.comfyz.exceptions.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class DefaultErrorController implements ErrorController {

    @Value("${server.error.path:${error.path:/error}}")
    String errorPath;

    @RequestMapping(produces = {"text/html"})
    public void handleHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ErrorMessage message = getMessage(request);
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        OutputStreamWriter out = new OutputStreamWriter(outputStream, "UTF-8");
        try {
            out.write("<html>");
            out.write("<head>");
            out.write("<title>" + message.getType() + "</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<h1>" + message.getCode() + " : " + message.getType() + "</h1>");
            out.write("<h2>" + message.getMsg() + "</h2>");
            out.write("</body>");
            out.write("</html>");
        } finally {
            out.flush();
            out.close();
        }
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<ErrorMessage> error(HttpServletRequest request) {
        return new ResponseEntity<>(getMessage(request), getStatus(request));
    }

    private ErrorMessage getMessage(HttpServletRequest request) {
        org.springframework.http.HttpStatus status = getStatus(request);
        ErrorMessage message;
        if (status == NOT_FOUND) {
            String url;
            if (!StringUtils.isEmpty(request.getAttribute("javax.servlet.error.request_uri"))) {
                url = request.getAttribute("javax.servlet.error.request_uri").toString();
            } else {
                url = request.getRequestURI();
            }
            String desc = "Request uri '" + url + "' not found";
            message = new ErrorMessage(NOT_FOUND, desc);
        } else if (status == INTERNAL_SERVER_ERROR) {
            String desc = request.getAttribute("javax.servlet.error.message").toString();
            if (!StringUtils.hasText(desc)) {
                desc = request.getAttribute("javax.servlet.error.exception").toString();
                desc = desc.substring(desc.lastIndexOf(":") + 1);
            }
            message = new ErrorMessage(INTERNAL_SERVER_ERROR, desc.trim());
        } else {
            String desc = "Unknown error";
            message = new ErrorMessage(INTERNAL_SERVER_ERROR, desc);
        }
        return message;
    }

    private org.springframework.http.HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return NOT_FOUND;
        }
        try {
            return org.springframework.http.HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }
}
