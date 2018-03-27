package eu.daxiongmao.springtraining.di;


import eu.daxiongmao.springtraining.injection.services.GreetingService;
import eu.daxiongmao.springtraining.injection.services.GreetingServiceDeImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("de")
public class DependenciesInjectionApplicationProfileDeIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(DependenciesInjectionApplicationProfileDeIT.class);

    @Autowired
    private ApplicationContext appContext;

    /**
     * We expect the GERMAN bean to be inject.
     */
    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGreetingServiceDe() {
        final GreetingService greetingServiceDe = (GreetingService) appContext.getBean("greetingServiceDe");
        LOGGER.debug("German welcome: {}", greetingServiceDe.sayHello());
        Assert.assertNotNull(greetingServiceDe.sayHello());
        Assert.assertEquals(GreetingServiceDeImpl.WELCOME_DE, greetingServiceDe.sayHello());
    }

    @Test
    public void testPrimaryDe() {
        Assert.assertNotNull(greetingService.sayHello());
        Assert.assertEquals(GreetingServiceDeImpl.WELCOME_DE, greetingService.sayHello());
    }
}
