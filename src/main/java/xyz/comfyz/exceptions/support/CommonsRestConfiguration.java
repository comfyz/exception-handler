package xyz.comfyz.exceptions.support;

import xyz.comfyz.exceptions.core.DefaultErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonsRestConfiguration {
    @Bean
    public DefaultErrorController defaultErrorController() {
        return new DefaultErrorController();
    }
}
