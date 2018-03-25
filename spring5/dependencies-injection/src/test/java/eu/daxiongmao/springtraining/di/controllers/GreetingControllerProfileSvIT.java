package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.injection.services.GreetingService;
import eu.daxiongmao.springtraining.injection.services.GreetingServiceSvImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("sv")
public class GreetingControllerProfileSvIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingControllerProfileSvIT.class);

    @Autowired
    @Qualifier("greetingServiceSv")
    private GreetingService greetingServiceSv;

    @Test
    public void testGreetingServiceSv() {
        LOGGER.debug("Swedish welcome: {}", greetingServiceSv.sayHello());
        Assert.assertNotNull(greetingServiceSv.sayHello());
        Assert.assertEquals(GreetingServiceSvImpl.WELCOME_SV, greetingServiceSv.sayHello());
    }
}
