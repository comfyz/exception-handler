package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.comfyz.rest.exceptions.EnableExceptionHandler;


@SpringBootApplication
@EnableExceptionHandler
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
