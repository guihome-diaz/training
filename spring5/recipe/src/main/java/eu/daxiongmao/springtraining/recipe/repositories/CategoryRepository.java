package eu.daxiongmao.springtraining.recipe.repositories;

import eu.daxiongmao.springtraining.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * To interact with recipes' categories.
 */
// Since Spring Boot 2 we don't need to add @Repository on Class that extends {@link CrudRepository}
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * To retrieve a category by its name.
     *
     * @param name search name
     * @return corresponding category, if found.<br>
     * Since Spring 5 &amp; Spring Boot 2: always check {@link Optional#isPresent()} to see if a value has been found
     */
    Optional<Category> findByName(String name);

}
