package xyz.comfyz.rest.exceptions;

import xyz.comfyz.rest.exceptions.handler.DefaultErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonsRestConfiguration {
    @Bean
    public DefaultErrorController defaultErrorController() {
        return new DefaultErrorController();
    }
}