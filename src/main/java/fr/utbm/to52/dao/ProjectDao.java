package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author to52
 *
 */
@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {
    
}
