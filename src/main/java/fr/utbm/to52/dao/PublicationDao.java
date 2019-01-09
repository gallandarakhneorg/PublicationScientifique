
package fr.utbm.to52.dao;
import fr.utbm.to52.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author adilsoncapaia
 */
public interface PublicationDao<T extends Publication> extends JpaRepository<T, Long>{
    //Publication findByAuthors(Set<Author> authors);
    List<T> findByEnglishTitleContainingIgnoreCase(String title);
    List<T> findByFrenchTitleContainingIgnoreCase(String title);
    List<T> findByYear(Long year);
    List<T> findByPublicationTypeCode(String code);
    @Override
    T findOne(Long id);
     @Query("select a From Author a inner join a.publication where a.publication.idPublication= :idPublication ")
    List<Author>  findAllPublicationAuthorMemberByIdPublication(@Param("idPublication")Long idPublication);


    
}
