package eu.daxiongmao.springtraining.chuck.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Declaration of 3rd parties beans.
 * (i) because that class is in a sub-package of the @SpringBootApplication you don't need to add any configuration anywhere.
 * The bean will be available for all
 */
@Configuration
public class ThirdPartyConfiguration {

    /**
     * I named the bean so we can distinct it from the XML one ({#link chuck-library-configuration.xml})
     * @return Chuck norris jokes utility
     */
    @Bean("chuckNorrisQuotesJavaConfig")
    @Primary
    public ChuckNorrisQuotes getChuckNorrisQuotes() {
        // this is how you can declare a bean (i.e a single instance of a class)
        return new ChuckNorrisQuotes();
    }

}
