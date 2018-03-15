package demo;

import xyz.comfyz.exceptions.handler.RestExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler extends RestExceptionHandler {
}
