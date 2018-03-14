package eu.daxiongmao.springtraining.chuck.controllers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * Integration tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeControllerIT {

    @Autowired
    private JokeController jokeController;

    @Test
    public void jokeController() {
        Model fakeModel = new RedirectAttributesModelMap();
        String page = jokeController.getJoke(fakeModel);
        Assert.assertNotNull(page);
        Assert.assertEquals("index", page);
        Assert.assertFalse(StringUtils.isEmpty(fakeModel.asMap()));
        System.out.println("Chuck Norris fact: " + fakeModel.asMap().get("joke"));
    }

}
