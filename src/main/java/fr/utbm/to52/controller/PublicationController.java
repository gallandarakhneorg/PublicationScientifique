/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.controller;

import fr.utbm.to52.dao.PublicationDao;
import fr.utbm.to52.domain.Member;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import exception.ResourceNotFoundException;
//import fr.utbm.to52.dao.MemberDao;
import fr.utbm.to52.domain.Publication;
import java.util.ArrayList;
import javax.faces.bean.RequestScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.data.jpa.repository.Query;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
/**
 *
 * @author adilsoncapaia
 */
@RestController
public class PublicationController {
    
    @Autowired
    private PublicationDao pubDao;
   
//    private MemberDao memberDao;
    
    @GetMapping("/publications")
    public Page<Publication> getPublications(Pageable page)
    {
        return pubDao.findAll(page);
    }
    
    
    @GetMapping("/publications/id/{publicationId}")
    public Publication getPulication(@PathVariable Long publicationId)
    {
        return pubDao.findOne(publicationId);
    }
    
    @GetMapping("/publications/title/{englishTtitle}")
    public List<Publication> getPulicationByEnglishTitle(@PathVariable String englishTtitle)
    {
        
        return pubDao.findByEnglishTitle(englishTtitle);
    }
    
    @GetMapping("/publications/year/{year}")
    public List<Publication> getPulicationsByYear(@PathVariable Long year)
    {
        
        return pubDao.findByYear(year);
    }
    
    @GetMapping("/publications/year/begin/{yearBegin}/end/{yearEnd}")
    public List<Publication> getPulicationsByBetweenYears(@PathVariable Long yearBegin, @PathVariable Long yearEnd)
    {
        List<Publication> listPub = new ArrayList<Publication>();
        // returner une liste vide
        if( yearEnd < yearBegin)
        {
            // returner liste vide ou returner une incorrect range
              // return new ArrayList<Publication>();
            throw new ResourceNotFoundException(" Incorrect Range, Try to supply a good range" );
        }
        
        for(Long year = yearBegin; year <= yearEnd; year++ )
        {
            listPub.addAll(pubDao.findByYear(year));
        }
                
        return listPub;
    }
    
    @GetMapping("/publications/year/{yearBegin}/{yearEnd}")
    public List<Publication> getPulicationsByBetweenYears2(@PathVariable Long yearBegin, @PathVariable Long yearEnd)
    {
        List<Publication> listPub = new ArrayList<Publication>();
        
        // returner une liste vide
        if( yearEnd < yearBegin)
        {
            // returner liste vide
               //return new ArrayList<Publication>();
               throw new ResourceNotFoundException(" <strong>Incorrect Range, Try to supply a good range</strong>" );
        }
        
        for(Long year = yearBegin; year <= yearEnd; year++ )
        {
            listPub.addAll(pubDao.findByYear(year));
        }
        
        
                
        return listPub;
    }
    
    @GetMapping("/publications/{frenchTitle}")
    public List<Publication> getPulicationByFrenchTitle(@PathVariable String frenchTtitle)
    {
        return pubDao.findByFrenchTitle(frenchTtitle);
    }
    
   @PostMapping("/publications")
   public Publication createPublication(@Valid @RequestBody Publication publication)
   {
      return pubDao.save(publication);
   }
    
}
