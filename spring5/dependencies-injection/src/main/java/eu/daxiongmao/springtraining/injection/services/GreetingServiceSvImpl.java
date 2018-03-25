package eu.daxiongmao.springtraining.injection.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the SWEDISH language.
 * <h3>Technical note</h3>
 * <p>
 * This is the only available for a particular <strong>Spring profile</strong>.<br>
 * You have to enable the corresponding profile(s). 2 way to enable profile(s):
 * <ul>
 * <li>in the <code>application.properties</code> file and use <code>spring.profile.active=sv</code></li>
 * <li>Use @ActiveProfile (mostly for unit tests)</li>
 * </ul>
 * </p>
 */
@Service("greetingServiceSv")
@Profile("sv")
@Primary
public class GreetingServiceSvImpl implements GreetingService {


    public static final String WELCOME_SV = "Hej! Välkommen till träningen";

    @Override
    public String sayHello() {
        return WELCOME_SV;
    }
}
