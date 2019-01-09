/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.to52.controller;

import fr.utbm.to52.dao.MemberDao;
import fr.utbm.to52.dao.StatusDao;
import fr.utbm.to52.domain.Member;
import fr.utbm.to52.domain.Status;
import java.util.List;
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
 * 
 * Cette class est un rest controller, elle sert a fournir aux utilisateurs 
 * toutes les services concerné aux membres
 */
@RestController
public class MemberController {
    
    //object used to make query on the database, extract info 
    // about the members
    @Autowired
    private MemberDao membDao; 

    // service that give all the members, with or without publications
    @GetMapping("/members")
    public Page<Member> getMembers(Pageable pageable)
    {
        return membDao.findAll(pageable) ;
    } 
    
    // Service that informations about the member/s with the matched last name
    @GetMapping("/members/last/{last}")
    public List<Member> getMembersByLast(@PathVariable String last)
    {
        return membDao.findByLastNameIgnoreCase(last) ;
    } 
    // Service that informations about the member/s with the matched email
    @GetMapping("/members/email/{email}")
    public Member getMemberByEmail(@PathVariable String email)
    {
        return membDao.findByEmailIgnoreCase(email) ;
    } 
    // Service allow user to create members 
   @PostMapping("/members")
   public Member createMember(@Valid @RequestBody Member member)
   {
      return membDao.save(member);
   }
    
}
