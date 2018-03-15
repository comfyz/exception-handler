package xyz.comfyz.exceptions;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({CommonsRestConfiguration.class})
public @interface EnableCommonsRest {
}
