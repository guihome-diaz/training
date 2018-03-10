package eu.daxiongmao.springtraining.di.services;

import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the ENGLISH language
 */
@Service("greetingServiceEn")
public class GreetingServiceEnImpl implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello! Welcome to the spring5 training";
    }
}
