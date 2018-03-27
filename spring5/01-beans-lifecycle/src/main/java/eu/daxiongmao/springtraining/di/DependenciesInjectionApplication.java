package eu.daxiongmao.springtraining.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependenciesInjectionApplication {

    public static void main(final String[] args) {
        // Default Spring Boot launcher that returns the loaded context
        final ApplicationContext appContext = SpringApplication.run(DependenciesInjectionApplication.class, args);
    }
}
