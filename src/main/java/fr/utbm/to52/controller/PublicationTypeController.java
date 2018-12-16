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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adilsoncapaia
 */
@RestController
public class PublicationTypeController {
    
    @Autowired
    private PublicationTypeDao pubDao;
    
    @GetMapping("/types")
    public Page<PublicationType> getPublicationTypes(Pageable pageable)
    {
        return pubDao.findAll(pageable);
    }
    
   @PostMapping("/types")
   public PublicationType createPublicationType(@Valid @RequestBody PublicationType publicationType)
   {
      return pubDao.save(publicationType);
   }
    
    /*
    @PostMapping("/question/{questionId}/answers")
    public Answer addAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer)
    {
        return questionRepo.findById(questionId)
                .map( question -> {
                  answer.setQuestion(question);
                  return answerRepo.save(answer);
                    
                }).orElseThrow( () -> new ResourceNotFoundException("question not found with id" + questionId));
        
    }
    
    */
}
