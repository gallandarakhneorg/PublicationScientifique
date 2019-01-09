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
import fr.utbm.to52.dao.MemberDao;
import fr.utbm.to52.domain.Article;
import fr.utbm.to52.domain.Book;
import fr.utbm.to52.domain.*;
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
 * Cette class est un rest controller, elle sert a fournir aux utilisateurs 
 * toutes les services concerné aux  publications and others specific functionalities
 */
@RestController
public class PublicationController<T extends Publication> {
    //object used to make query on the database, extract info 
    // about the authors, and specific publications, 
    @Autowired
    private PublicationDao<T> pubDao;
    @Autowired
    private PublicationDao<Article> pubArtDao;
    @Autowired
    private PublicationDao<Book> pubBookDao;
    @Autowired
    private PublicationDao<InBook> pubInBookDao;
    @Autowired
    private PublicationDao<Conference> pubConfDao;
    @Autowired
    private PublicationDao<Proceeding> pubProcDao;
    @Autowired
    private PublicationDao<TechReport> pubRepDao;
    private MemberDao memberDao;
    
    // service that give all publications on the DB
    @GetMapping("/publications")
    public Page<T> getPublications(Pageable page)
    {
        
        return pubDao.findAll(page);
    }
    
    // service that give a specific publication, by id
    @GetMapping("/publications/id/{publicationId}")
    public T getPulication(@PathVariable Long publicationId)
    {
        return pubDao.findOne(publicationId);
    }
    // service that give publications that matche the specified englishtitle
    @GetMapping("/publications/title/{englishTtitle}")
    public List<T> getPulicationByEnglishTitle(@PathVariable String englishTtitle)
    {
        
        return pubDao.findByEnglishTitleContainingIgnoreCase(englishTtitle);
    }
    // service that give publications with matched type code
    @GetMapping("/publications/type/{code}")
    public List<Publication> getPulicationsByTypeCode(@PathVariable String code)
    {
        //.equalsIgnoreCase(code)
        List<Publication> results = new ArrayList<Publication>();
        for(Publication p : pubDao.findAll())
        {
            if(code.toUpperCase().contains(p.getPublicationType().getCode().toUpperCase()))
                results.add(p);
        }
        return results;
    }
    
    // Service that give all publications made in the specified year
    @GetMapping("/publications/year/{year}")
    public List<T> getPulicationsByYear(@PathVariable Long year)
    {
        
        return pubDao.findByYear(year);
    }
    // 1 option Service that give all publications made in the specified range of year
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
    //2 options Service that give all publications made in the specified range of year
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
    // service that give all publications that match the specified french title
    @GetMapping("/publications/franchtitle/{frenchTitle}")
    public List<T> getPulicationByFrenchTitle(@PathVariable String frenchTtitle)
    {
        return pubDao.findByFrenchTitleContainingIgnoreCase(frenchTtitle);
    }
     // service that allow users to create a general publication
   @PostMapping("/publications")
   public  T createPublication(@Valid @RequestBody T publication)
   {  
        //this.create((Article)publication);
        return pubDao.save(publication);
   }
   // service that allow users to create an article
   @PostMapping("/publications/create/arti/")
   public  Article createPublication(@Valid @RequestBody Article publication)
   {  
        
        return pubArtDao.save(publication);
   }
   // service that allow users to create a book
   @PostMapping("/publications/create/book/")
   public  Book createPublication(@Valid @RequestBody Book publication)
   {  
        
        return pubBookDao.save(publication);
   }
   // service that allow users to create a conference
   @PostMapping("/publications/create/conf/")
   public  Conference createPublicationConf(@Valid @RequestBody Conference publication)
   {  
        
        return pubConfDao.save(publication);
   }
   // service that allow users to create a tech report
   @PostMapping("/publications/create/tech/")
   public  TechReport createPublicationTech(@Valid @RequestBody TechReport publication)
   {  
        
        return pubRepDao.save(publication);
   }
   // service that allow users to create a tech a InBook
   @PostMapping("/publications/create/inbo")
   public  InBook createPublicationInB(@Valid @RequestBody InBook publication)
   {  
        
        return pubInBookDao.save(publication);
   }
    
}
