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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adilsoncapaia
 */
@RestController
public class StatusController {
    
    @Autowired
    private StatusDao statusDao; 
    
    
    
    @GetMapping("/status")
    public Page<Status> getStatus(Pageable pageable)
    {
        return statusDao.findAll(pageable) ;
    } 
    
   @PostMapping("/status")
   public Status createStatus(@Valid @RequestBody Status status)
   {
      return statusDao.save(status);
   }
   /* 
   @GetMapping("/status/id/")
    public Page<Status> getStatus(@RequestPram String id)
    {
        return statusDao.findOne(id) ;
    } 
    */
}
