package eu.daxiongmao.springtraining.injection.services;

import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the ENGLISH language
 */
@Service("greetingServiceEn")
public class GreetingServiceEnImpl implements GreetingService {

    public static final String WELCOME_EN = "Hello! Welcome to the spring5 training";

    @Override
    public String sayHello() {
        return WELCOME_EN;
    }
}
