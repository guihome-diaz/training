package eu.daxiongmao.springtraining.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Since Spring Boot 2 we don't need to add @EnableJpaRepositories on the SpringBootApplication class or unit tests
@SpringBootApplication
public class WebAppRecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAppRecipesApplication.class, args);
    }
}
