package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.di.services.GreetingService;
import eu.daxiongmao.springtraining.di.services.GreetingServiceEnImpl;
import eu.daxiongmao.springtraining.di.services.GreetingServiceFrImpl;
import eu.daxiongmao.springtraining.di.services.GreetingServiceZhImpl;
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
 * <p>
 * Greeting service tests
 * </p>
 * <h3>Note: Spring wiring</h3>
 * <p>
 * While the Spring community does not recommend to use @autowired on attributes in the runtime code, that is
 * perfectly acceptable for the jUnits. As long as the jUnits are actually testing the corresponding beans.
 * </p>
 * <h3>Note: Integration Tests</h3>
 * <p>
 * These tests can be considered "Integration Test" because they are loading the Spring context: all application's beans.<br>
 * Unlike "unit tests" they rely on the complete application (and sometimes its dependencies) to work.
 * </p>
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

    /**
     * Should be the primary value
     */
    @Autowired
    private GreetingService greetingServiceZh;

    @Test
    public void testGreetingController() {
        LOGGER.debug("Welcome: {}", greetingController.sayHello());
        Assert.assertNotNull(greetingController.sayHello());
        Assert.assertEquals(GreetingServiceFrImpl.WELCOME_FR, greetingController.sayHello());
    }

    @Test
    public void testGreetingServiceEn() {
        LOGGER.debug("English welcome: {}", greetingServiceEn.sayHello());
        Assert.assertNotNull(greetingServiceEn.sayHello());
        Assert.assertEquals(GreetingServiceEnImpl.WELCOME_EN, greetingServiceEn.sayHello());
    }


    @Test
    public void testGreetingServiceFr() {
        LOGGER.debug("French welcome: {}", greetingServiceFr.sayHello());
        Assert.assertNotNull(greetingServiceFr.sayHello());
        Assert.assertEquals(GreetingServiceFrImpl.WELCOME_FR, greetingServiceFr.sayHello());
    }

    @Test
    public void testGreetingServiceZh() {
        LOGGER.debug("Chinese welcome: {}", greetingServiceZh.sayHello());
        Assert.assertNotNull(greetingServiceZh.sayHello());
        Assert.assertEquals(GreetingServiceZhImpl.WELCOME_ZH, greetingServiceZh.sayHello());
    }
}
