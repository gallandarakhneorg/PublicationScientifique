/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.controller;

import fr.utbm.to52.dao.*;
import fr.utbm.to52.domain.Member;
import fr.utbm.to52.domain.Status;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adilsoncapaia
 * Cette class est un rest controller, elle sert a fournir aux utilisateurs 
 * toutes les services concerné aux status des utilisateurs
 */
@RestController
public class StatusController {
    
    //object used to make query on the database, extract info 
    // about the status of the members
    @Autowired
    private StatusDao statusDao; 
    
    
    // service that give all types of status on the database 
    @GetMapping("/status")
    public Page<Status> getStatus(Pageable pageable)
    {
        return statusDao.findAll(pageable) ;
    } 
    
    // Service that give informations about the matched specified code 
    @GetMapping("/status/code/{code}")
    public Status getStatusById(@PathVariable String code)
    {
        return statusDao.findOne(code) ;
    } 
    
    // service that allow users to create a status
   @PostMapping("/status")
   public Status createStatus(@Valid @RequestBody Status status)
   {
      return statusDao.save(status);
   }
   
}
