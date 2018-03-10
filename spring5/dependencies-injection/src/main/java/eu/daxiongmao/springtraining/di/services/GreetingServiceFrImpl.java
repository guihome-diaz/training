package eu.daxiongmao.springtraining.di.services;


import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the FRENCH language
 */
@Service("greetingServiceFr")
public class GreetingServiceFrImpl implements GreetingService {

    @Override
    public String sayHello() {
        return "Bonjour! Bienvenue à la formation Spring 5";
    }
}
