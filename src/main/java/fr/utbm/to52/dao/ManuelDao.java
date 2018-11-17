package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Manuel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author to52
 *
 */
@Repository
public interface ManuelDao extends CrudRepository<Manuel, Long> {
}
