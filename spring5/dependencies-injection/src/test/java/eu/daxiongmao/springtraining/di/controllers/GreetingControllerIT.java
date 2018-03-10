package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.di.services.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * These can be considered "Integration Test" because they are loading the Spring context: all application's beans.<br>
 * Unlike "unit tests" they rely on the complete application (and sometimes its dependencies) to work.
 * <p>
 * <p>
 * Maven convention:
 * <ul>
 * <li>Naming convention: integration tests classes must be *IT.java</li>
 * <li>These tests will be handled by MAVEN FAILSAFE (integration tests phase)</li>
 * </ul>
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingControllerIT.class);

    @Autowired
    @Qualifier("greetingServiceEn")
    private GreetingService greetingServiceEn;

    @Autowired
    @Qualifier("greetingServiceFr")
    private GreetingService greetingServiceFr;

    @Autowired
    private GreetingController greetingController;

    @Test
    public void testGreetingController() {
        LOGGER.debug("Welcome: {}", greetingController.sayHello());
        Assert.assertNotNull(greetingController.sayHello());
    }

    @Test
    public void testGreetingServiceEn() {
        LOGGER.debug("English welcome: {}", greetingServiceEn.sayHello());
        Assert.assertNotNull(greetingServiceEn.sayHello());
    }


    @Test
    public void testGreetingServiceFr() {
        LOGGER.debug("French welcome: {}", greetingServiceFr.sayHello());
        Assert.assertNotNull(greetingServiceFr.sayHello());
    }
}
