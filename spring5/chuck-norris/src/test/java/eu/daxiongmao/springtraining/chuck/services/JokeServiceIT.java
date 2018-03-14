package eu.daxiongmao.springtraining.chuck.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * Integration test (it loads the Spring context)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceIT {

    @Autowired
    private JokeService jokeService;

    @Test
    public void getJoke() {
        String joke = jokeService.getJoke();
        Assert.assertNotNull(joke);
        Assert.assertFalse(StringUtils.isEmpty(joke));
        System.out.println("Chuck Norris fact: " + joke);
    }
}
