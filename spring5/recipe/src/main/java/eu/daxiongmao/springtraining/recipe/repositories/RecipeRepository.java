package eu.daxiongmao.springtraining.recipe.repositories;

import eu.daxiongmao.springtraining.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * To interact with our RECIPE database table and relations
 */
// Since Spring Boot 2 we don't need to add @Repository on Class that extends {@link CrudRepository}
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
