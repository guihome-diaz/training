package eu.daxiongmao.springtraining.injection.services;

/**
 * Implementation of a particular service for the GERMAN language.<br>
 * This is not declared as a @component : it is manually configured as a spring bean in the GreetingConfig
 */
public class GreetingServiceDeImpl implements GreetingService {

    public static final String WELCOME_DE = "Hallo! Willkommen beim Spring5-Training";

    @Override
    public String sayHello() {
        return WELCOME_DE;
    }
}
