package eu.daxiongmao.springtraining.recipe.repositories;

import eu.daxiongmao.springtraining.recipe.model.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
// Since Spring Boot 2 we don't need to add @Repository on Class that extends {@link CrudRepository}
// Since Spring Boot 2 we don't need to add @EnableJpaRepositories on the SpringBootApplication class or unit tests
//@EnableJpaRepositories("eu.daxiongmao.springtraining.recipe.repositories")
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository repository;

    @Test
    public void findAll() {
        List<UnitOfMeasure> measures = (ArrayList<UnitOfMeasure>) repository.findAll();
        Assert.assertNotNull(measures);
        Assert.assertFalse(measures.isEmpty());
    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = repository.findByUnit("Ounce");
        Assert.assertTrue(unitOfMeasureOptional.isPresent());
    }

}
