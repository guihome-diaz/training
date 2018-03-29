package eu.daxiongmao.springtraining.di;

import eu.daxiongmao.springtraining.injection.services.GreetingService;
import eu.daxiongmao.springtraining.injection.services.GreetingServiceSvImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("sv")
public class DependenciesInjectionApplicationProfileSvIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(DependenciesInjectionApplicationProfileSvIT.class);

    @Autowired
    private ApplicationContext appContext;

    @Value("${developer.mood}")
    private String developerMood;

    @Value("${developer.name}")
    private String developerName;


    /**
     * We expect the SWEDISH bean to be inject.
     */
    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGreetingServiceSv() {
        final GreetingService greetingServiceSv = (GreetingService) appContext.getBean("greetingServiceSv");
        LOGGER.debug("Swedish welcome: {}", greetingServiceSv.sayHello());
        Assert.assertNotNull(greetingServiceSv.sayHello());
        Assert.assertEquals(GreetingServiceSvImpl.WELCOME_SV, greetingServiceSv.sayHello());
    }

    @Test
    public void testPrimarySv() {
        Assert.assertNotNull(greetingService.sayHello());
        Assert.assertEquals(GreetingServiceSvImpl.WELCOME_SV, greetingService.sayHello());
    }

    @Test
    public void testDefaultPropertiesFilesLoaded() {
        // check the properties override by the profile switch
        Assert.assertNotNull(developerMood);
        Assert.assertEquals("super happy", developerMood);

        Assert.assertNotNull(developerName);
        Assert.assertEquals("GuiHome", developerName);
    }
}
