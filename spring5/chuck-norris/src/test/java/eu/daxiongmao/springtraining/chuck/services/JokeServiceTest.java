package eu.daxiongmao.springtraining.chuck.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * Unit tests
 */
public class JokeServiceTest {

    @Test
    public void getJoke() {
        // Careful ! When you use an unit test you MUST either mock or inject manually the dependencies
        JokeService jokeService = new ChuckNorrisJokeService(new ChuckNorrisQuotes());

        String joke = jokeService.getJoke();
        Assert.assertNotNull(joke);
        Assert.assertFalse(StringUtils.isEmpty(joke));
        System.out.println("Chuck Norris fact: " + joke);
    }

}
