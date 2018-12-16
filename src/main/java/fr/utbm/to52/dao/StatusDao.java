/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Address;
import fr.utbm.to52.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adilsoncapaia
 */
@Repository
public interface StatusDao extends JpaRepository<Status, String> {
    
}
