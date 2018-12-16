/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Author;
import fr.utbm.to52.domain.AuthorId;
import fr.utbm.to52.domain.Member;
import fr.utbm.to52.domain.Project;
import fr.utbm.to52.domain.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author adilsoncapaia
 */
@Repository
public interface AuthorDao extends JpaRepository<Author, Long>{
    
    Publication findByPublicationIdPublication(Long id);
    Author findById(AuthorId id);
    
}
