package eu.daxiongmao.springtraining.di.config;

import eu.daxiongmao.springtraining.injection.services.GreetingService;
import eu.daxiongmao.springtraining.injection.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Configuration class to manually declare additional beans / application configuration.<br>
 * As this is under the a sub-package of {@link eu.daxiongmao.springtraining.di.DependenciesInjectionApplication}
 * it will be included in the application's configuration by default thanks to component scan.
 */
@Configuration
public class GreetingConfig {

    @Bean
    public GreetingServiceFactory getGreetingServiceFactory() {
        return new GreetingServiceFactory();
    }

    // From that point onwards you can use the factory to create new beans.

    @Bean("greetingServiceDe")
    @Profile("de")
    @Primary
    public GreetingService greetingServiceDe() {
        return getGreetingServiceFactory().createGreetingService("de");
    }
}
