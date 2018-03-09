package eu.daxiongmao.springtraining.spring5webapp.repositories;

import eu.daxiongmao.springtraining.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * To interact with database through Spring-data-repository
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
