package fr.utbm.to52.dao;

import fr.utbm.to52.domain.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author to52
 *
 */
@Repository
public interface AddressDao extends JpaRepository<Address, Long>{
    

}
