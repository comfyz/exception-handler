package demo;


import xyz.comfyz.exceptions.exception.BadRequestException;
import xyz.comfyz.exceptions.exception.NotFoundException;
import xyz.comfyz.exceptions.exception.ServerException;
import xyz.comfyz.exceptions.exception.ServiceUnavailableException;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class DemoController {

    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String handleOK() {
        return "OK";
    }

    @RequestMapping(value = "/unhandled", method = RequestMethod.GET)
    public void unhandledException() throws Throwable {
        throw new Throwable("message");
    }

    @RequestMapping(value = "/serverException", method = RequestMethod.GET)
    public void handleServerException() {
        throw new ServerException("message");
    }

    @RequestMapping(value = "/serviceUnavailable", method = RequestMethod.GET)
    public void handleServiceUnavailable() {
        throw new ServiceUnavailableException("message");
    }

    @RequestMapping(value = "/badRequest", method = RequestMethod.GET)
    public void handleBadRequest() {
        throw new BadRequestException("message");
    }

    @RequestMapping(value = "/notFound", method = RequestMethod.GET)
    public void handleNotFound() {
        throw new NotFoundException("message");
    }

    @RequestMapping(value = "/validationError", method = RequestMethod.POST)
    public void handleValidationError(@Valid @RequestBody TestRequest request) {
    }

    @RequestMapping(value = "/mediaTypeNotAcceptable", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void handleMediaTypeNotAcceptable() {
    }

    @RequestMapping(value = "/missingPathVariable", method = RequestMethod.GET)
    public void handleMissingPathVariable(@PathVariable String name) {
    }

    @RequestMapping(value = "/invalidRequestBody", method = RequestMethod.POST)
    public void handleHttpMessageNotReadable(@RequestBody TestRequest request) {
    }

    public static class TestRequest {

        @NotBlank
        private String p1;

        @NotBlank
        private String p2;

        public String getP1() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1 = p1;
        }

        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }
    }
}
