package eu.daxiongmao.springtraining.di;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DependenciesInjectionApplicationTests {

    @Autowired
    private ApplicationContext appContext;

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
}
