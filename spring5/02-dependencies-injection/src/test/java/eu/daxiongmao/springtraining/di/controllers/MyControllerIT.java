package eu.daxiongmao.springtraining.di.controllers;

import eu.daxiongmao.springtraining.injection.services.GreetingServiceZhImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests for #{@link MyController}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyControllerIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyControllerIT.class);

    @Autowired
    private MyController myController;

    @Test
    public void sayHelloTest() {
        final String welcome = myController.helloWorld();
        Assert.assertEquals(GreetingServiceZhImpl.WELCOME_ZH, welcome);
    }
}
