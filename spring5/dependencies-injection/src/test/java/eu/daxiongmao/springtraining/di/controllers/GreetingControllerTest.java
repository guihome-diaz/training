package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.di.services.GreetingService;
import eu.daxiongmao.springtraining.di.services.GreetingServiceEnImpl;
import eu.daxiongmao.springtraining.di.services.GreetingServiceFrImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test: Spring isn't loaded at all
 * <p>
 * Maven convention:
 * <ul>
 * <li>Naming convention: unit tests classes must be *Test.java</li>
 * <li>These tests will be handled by MAVEN SUREFIRE (unit tests phase)</li>
 * </ul>
 * </p>
 */
public class GreetingControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingControllerTest.class);

    /**
     * To test a controller through manual dependencies injection
     */
    @Test
    public void manualDependencyInjection() {
        // English
        GreetingService greetingService = new GreetingServiceEnImpl();
        GreetingController controller = new GreetingController(greetingService);
        final String helloEn = controller.sayHello();
        LOGGER.debug("English welcome: {}", helloEn);
        Assert.assertNotNull(helloEn);

        // French
        greetingService = new GreetingServiceFrImpl();
        controller = new GreetingController(greetingService);
        final String helloFr = controller.sayHello();
        LOGGER.debug("French welcome: {}", helloFr);
        Assert.assertNotNull(helloFr);

        Assert.assertNotEquals(helloEn, helloFr);
    }
}
