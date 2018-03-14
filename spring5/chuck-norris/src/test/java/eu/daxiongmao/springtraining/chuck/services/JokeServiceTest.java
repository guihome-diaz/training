package eu.daxiongmao.springtraining.chuck.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * Unit tests
 */
public class JokeServiceTest {

    @Test
    public void getJoke() {
        JokeService jokeService = new ChuckNorrisJokeService();
        String joke = jokeService.getJoke();
        Assert.assertNotNull(joke);
        Assert.assertFalse(StringUtils.isEmpty(joke));
        System.out.println("Chuck Norris fact: " + joke);
    }

}
