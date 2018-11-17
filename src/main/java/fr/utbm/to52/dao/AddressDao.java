package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author to52
 *
 */
@Repository
public interface AddressDao extends CrudRepository <Address, Long> {

}
