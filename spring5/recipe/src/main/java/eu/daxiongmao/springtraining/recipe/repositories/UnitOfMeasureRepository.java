package eu.daxiongmao.springtraining.recipe.repositories;

import eu.daxiongmao.springtraining.recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * To interact with the database list of measures
 */
// Since Spring Boot 2 we don't need to add @Repository on Class that extends {@link CrudRepository}
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    /**
     * To retrieve an unit of measure by its unit's name.
     *
     * @param unit search unit
     * @return corresponding unit, if found.<br>
     * Since Spring 5 &amp; Spring Boot 2: always check {@link Optional#isPresent()} to see if a value has been found
     */
    Optional<UnitOfMeasure> findByUnit(String unit);
}
