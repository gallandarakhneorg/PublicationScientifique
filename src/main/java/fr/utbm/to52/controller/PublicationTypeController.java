/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.controller;

import fr.utbm.to52.dao.PublicationTypeDao;
import fr.utbm.to52.domain.Publication;
import fr.utbm.to52.domain.PublicationType;
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
 * toutes les services concerné types publications
 */
@RestController
public class PublicationTypeController {
    
    //object used to make query on the database, extract info 
    // about the publications
    @Autowired
    private PublicationTypeDao pubDao;
    
    // service that extract on the DB and give all types of publications
    @GetMapping("/types")
    public Page<PublicationType> getPublicationTypes(Pageable pageable)
    {
        return pubDao.findAll(pageable);
    }
    // service that extract on the DB and give all types of publications with the matched code
    @GetMapping("/types/code/{code}")
    public PublicationType getPublicationTypeById(@PathVariable String code)
    {
        return pubDao.findOne(code);
    }
    // services that allow users create type of publications
   @PostMapping("/types")
   public PublicationType createPublicationType(@Valid @RequestBody PublicationType publicationType)
   {
      return pubDao.save(publicationType);
   }
    
}
