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
 * Cette class est un rest controller, elle sert a fournir aux utilisateurs 
 * toutes les services concerné aux auteurs d'une publications
 */

@RestController
public class AuthorController <T extends Publication> {
    //object used to make query on the database, extract info 
    // about the authors
    @Autowired
    private AuthorDao autDao;
    //object used to make query on the database, extract info about the publications
    @Autowired
	private PublicationDao<T> pubDao;
    //object used to make query on the database, extract info about the members os a publication
    @Autowired
    private MemberDao membDao;
    
    //------Bellow are a few services to extract info about publications and authors -------- \\
   /// service that return all the members that have already made a publication, wich need to be member 
    // in the first place
    @GetMapping("/authors")
    public Page<Author> getPublications(Pageable page)
    {
        return autDao.findAll(page);
    }
    // service that return a specifique publication 
    @GetMapping("/authors/publications/{publicationId}/")
    public Object getPublications(@PathVariable Long publicationId)
    {
        return   pubDao.findOne(publicationId)  ;
                //autDao.findByPublicationIdPublication(publicationId);
    }
    // service that return a all publications of a specific author
    @GetMapping("/authors/{authorId}/publications")
    public List<Publication> getPublicationsPerAuthorId(@PathVariable Long authorId)
    {
        // list that will contains all publications of the specified author
        List<Publication> results = new ArrayList<Publication>();
        // search for all publications of the specified author
        for( Author aut : autDao.findAll())
        {
            if(aut.getId().getIdMember() == authorId)
            {
                List<Publication> listPub = (List<Publication>) pubDao.findAll();
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
        // return all the found publications
        return results;
                
    } 
    // service that return all the publications, of the author with the 
    // last name specified
    @GetMapping("/authors/last/{authorLastName}/publications")
    public List<T> getPublicationsPerAuthorName(@PathVariable String authorLastName)
    {
         // list that will contains all publications of the specified author
        List<T> results = new ArrayList<T>();
        // search for all publications of the specified author
        for( Author aut : autDao.findAll())
        {
            if(aut.getMember().getLastName().equalsIgnoreCase(authorLastName))
            {
                List<T> listPub = pubDao.findAll();
                //Long idPub = pub.getIdPublication();
                
                for( Publication p : listPub )
                {
                   Set<Author> listAut = p.getAuthors();
                   
                   for(Author a : listAut)
                   {
                       if(a.getMember().getLastName().equalsIgnoreCase(authorLastName))      
                       {
                           
                            if(!results.contains(p))
                                results.add((T) p);
                            break;
                       }
                   }
                   
                }
            }
        }
        // return all the found publications
        return results;
                
    }
    // service that return all the publications, of the author with the 
    // specified email
    @GetMapping("/authors/email/{email}/publications")
    public List<T> getPublicationsPerAuthorEmail(@PathVariable String email)
    {
        // list that will contains the results
        List<T> results = new ArrayList<T>();
        // search for all publications of the specified author
        for( Author aut : autDao.findAll())
        {
            if(aut.getMember().getEmail().equalsIgnoreCase(email))
            {
                List<T> listPub = pubDao.findAll();
                //Long idPub = pub.getIdPublication();
                
                for( Publication p : listPub )
                {
                   Set<Author> listAut = p.getAuthors();
                   
                   for(Author a : listAut)
                   {
                       if(a.getMember().getEmail().equalsIgnoreCase(email))      
                       {
                           if(!results.contains(p))
                            results.add((T) p);
                            break;
                       }
                   }
                   
                }
            }
        }
        // return the publications found
        return results;
                
    }
    // service that return all the publications, of the author with the 
    //  specified login
    @GetMapping("/authors/login/{login}/publications")
    public List<T> getPublicationsPerAuthorLogin(@PathVariable String login)
    {
        // list that will contains all publications of the specified author
        List<T> results = new ArrayList<T>();
        for( Author aut : autDao.findAll())
        {
            if(aut.getMember().getLogin().equalsIgnoreCase(login))
            {
                List<T> listPub = pubDao.findAll();
                //Long idPub = pub.getIdPublication();
                
                for( Publication p : listPub )
                {
                   Set<Author> listAut = p.getAuthors();
                   
                   for(Author a : listAut)
                   {
                       if(a.getMember().getLogin().equalsIgnoreCase(login))      
                       {
                           if(!results.contains(p))
                                results.add((T) p);
                            break;
                       }
                   }
                   
                }
            }
        }
        // return all publications found
        return results;          
    }
    
   
    
}
