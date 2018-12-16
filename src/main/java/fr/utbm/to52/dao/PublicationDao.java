
package fr.utbm.to52.dao;
import fr.utbm.to52.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

/**
 *
 * @author adilsoncapaia
 */
public interface PublicationDao extends JpaRepository<Publication, Long>{
    //Publication findByAuthors(Set<Author> authors);
    List<Publication> findByEnglishTitle(String title);
    List<Publication>  findByFrenchTitle(String title);
    List<Publication>  findByYear(Long year);
}
