package fr.utbm.to52.dao;



import fr.utbm.to52.domain.PublicationType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author to52
 *
 */
@Repository
public interface PublicationTypeDao extends JpaRepository<PublicationType,String> {
    //List<PublicationType> findByPublicationId(String memberId);
}
