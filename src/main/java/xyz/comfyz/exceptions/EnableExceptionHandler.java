package xyz.comfyz.exceptions;

import org.springframework.context.annotation.Import;
import xyz.comfyz.exceptions.support.CommonsRestConfiguration;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({CommonsRestConfiguration.class})
public @interface EnableExceptionHandler {
}
