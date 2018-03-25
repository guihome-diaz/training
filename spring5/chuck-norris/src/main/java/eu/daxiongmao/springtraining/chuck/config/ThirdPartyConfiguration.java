package eu.daxiongmao.springtraining.chuck.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Declaration of 3rd parties beans.
 * (i) because that class is in a sub-package of the @SpringBootApplication you don't need to add any configuration anywhere.
 * The bean will be available for all
 */
@Configuration
public class ThirdPartyConfiguration {

    /**
     * @return Chuck norris jokes utility
     */
    @Bean
    public ChuckNorrisQuotes getChuckNorrisQuotes() {
        // this is how you can declare a bean (i.e a single instance of a class)
        return new ChuckNorrisQuotes();
    }

}
