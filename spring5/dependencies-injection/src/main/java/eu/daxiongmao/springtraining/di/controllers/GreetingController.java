package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Spring 5 training, Lecture 32.<br>
 * <p>
 * Dependency injection example through CONSTRUCTOR.
 * In case of multiple instances of the same interface, the bean to use is set with QUALIFIER.
 */
@Controller
public class GreetingController {

    // It is not recommended to @autowired private properties because it makes the class harder to test
    //    @Autowired
    private final GreetingService greetingService;

    /**
     * To create a new instance.<br>
     * You don't have to put @autowired (the annotation is useless), however it helps the maintenance and tells other
     * developers that this is the constructor Spring is going to use.
     *
     * @param greetingService service to use
     */
    @Autowired
    public GreetingController(@Qualifier("greetingServiceFr") final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayHello();
    }
}
