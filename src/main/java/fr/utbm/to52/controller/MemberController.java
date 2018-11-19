package fr.utbm.to52.controller;

import fr.utbm.to52.domain.Member;
import fr.utbm.to52.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    /**
     * Create Member
     * @param pMember
     * @return
     */
    @GetMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Member> create(@RequestBody Member pMember){

        if(memberService.checkIfMemberNameExist(pMember.getFirstName(),pMember.getLastName())){

            return new ResponseEntity<>(HttpStatus.FOUND);
        }else{

           return new ResponseEntity<Member>(memberService.create(pMember), HttpStatus.OK);
           // return new ResponseEntity<String>("Hello World", HttpStatus.OK);
        }

    }

}
