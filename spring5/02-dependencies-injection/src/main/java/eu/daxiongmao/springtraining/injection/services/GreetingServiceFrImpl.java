package eu.daxiongmao.springtraining.injection.services;


import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the FRENCH language
 */
@Service("greetingServiceFr")
public class GreetingServiceFrImpl implements GreetingService {

    public static final String WELCOME_FR = "Bonjour! Bienvenue à la formation Spring 5";

    @Override
    public String sayHello() {
        return WELCOME_FR;
    }
}
