/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.controller;

import fr.utbm.to52.dao.AuthorDao;
import fr.utbm.to52.dao.MemberDao;
import fr.utbm.to52.dao.PublicationDao;
import fr.utbm.to52.domain.Author;
import fr.utbm.to52.domain.AuthorId;
import fr.utbm.to52.domain.Member;
import fr.utbm.to52.domain.Publication;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author adilsoncapaia
 *
 */

@RestController
public class AuthorController {
    
    @Autowired
    private AuthorDao autDao;
    @Autowired
    private PublicationDao pubDao;
    @Autowired
    private MemberDao membDao;
    
    @GetMapping("/authors")
    public Page<Author> getPublications(Pageable page)
    {
        return autDao.findAll(page);
    }
    
    @GetMapping("/authors/publications/{publicationId}/")
    public Publication getPublications(@PathVariable Long publicationId)
    {
        return   pubDao.findOne(publicationId)  ;
                //autDao.findByPublicationIdPublication(publicationId);
    }
    /*
    @GetMapping("/authors/{authorId}/publications")
    public List<Publication> getPublicationsPerAuthorId(@PathVariable Long authorId)
    {
        List<Publication> results = new ArrayList<Publication>();
        for( Author aut : autDao.findAll())
        {
            if(aut.getId().getIdMember() == authorId)
            {
                List<Publication> listPub = pubDao.findAll();
                //Long idPub = pub.getIdPublication();
                
                for( Publication p : listPub )
                {
                   Set<Author> listAut = p.getAuthors();
                   
                   for(Author a : listAut)
                   {
                       if(a.getId().getIdMember() == authorId)
                       {
                            results.add(p);
                            break;
                       }
                   }
                   
                }
            }
        }
        
        return results;
                
    } */
    
    @GetMapping("/authors/{authorLastName}/publications")
    public List<Publication> getPublicationsPerAuthorName(@PathVariable String authorLastName)
    {
        List<Publication> results = new ArrayList<Publication>();
        for( Author aut : autDao.findAll())
        {
            if(aut.getMember().getLastName().equalsIgnoreCase(authorLastName))
            {
                List<Publication> listPub = pubDao.findAll();
                //Long idPub = pub.getIdPublication();
                
                for( Publication p : listPub )
                {
                   Set<Author> listAut = p.getAuthors();
                   
                   for(Author a : listAut)
                   {
                       if(aut.getMember().getLastName().equalsIgnoreCase(authorLastName))      
                       {
                           
                            results.add(p);
                            break;
                       }
                   }
                   
                }
            }
        }
        
        return results;
                
    }
}
