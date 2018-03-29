package eu.daxiongmao.springtraining.di;

import eu.daxiongmao.springtraining.injection.services.GreetingService;
import eu.daxiongmao.springtraining.injection.services.GreetingServiceZhImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DependenciesInjectionApplicationTests {

    @Autowired
    private ApplicationContext appContext;

    /**
     * We expect the CHINESE bean to be inject (because it has the @Primary on the 'default' profile).
     */
    @Autowired
    private GreetingService greetingService;


    @Value("${developer.mood}")
    private String developerMood;

    @Value("${developer.name}")
    private String developerName;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testGreetingServiceSv() {
        // No profile has been loaded for that test !! You should not be able to retrieve any profiles' beans
        try {
            appContext.getBean("greetingServiceSv");
            Assert.fail("You should not be able to retrieve any profile's bean in that configuration");
        } catch (final NoSuchBeanDefinitionException e) {
            // success case! No bean has been found!
        }
    }

    @Test
    public void testPrimaryZh() {
        Assert.assertNotNull(greetingService.sayHello());
        Assert.assertEquals(GreetingServiceZhImpl.WELCOME_ZH, greetingService.sayHello());
    }

    @Test
    public void testDefaultPropertiesFilesLoaded() {
        Assert.assertNotNull(developerMood);
        Assert.assertEquals("happy", developerMood);

        Assert.assertNotNull(developerName);
        Assert.assertEquals("Guillaume", developerName);
    }
}
