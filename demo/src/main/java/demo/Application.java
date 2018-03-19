package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.comfyz.rest.exceptions.EnableCommonsRest;


@SpringBootApplication
@EnableCommonsRest
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
