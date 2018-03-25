package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.injection.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Spring 5 training, Lecture 34.<br>
 * <p>
 * Dependency injection example through CONSTRUCTOR.
 * In case of multiple instances of the same interface, Spring will use the default PRIMARY bean.
 */
@Controller
public class MyController {

    private final GreetingService greetingService;

    /**
     * Constructor for dependency injection.
     * No need of @Autowired for it to work.
     * NO need of @Qualifier: spring will use the default @primary bean
     *
     * @param greetingService greeting service
     */
    public MyController(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * This is for testing purposes only.
     * In principle a controller should return the name of the view to display |or| HTTP response
     *
     * @return welcome string
     */
    public String helloWorld() {
        return greetingService.sayHello();
    }
}
