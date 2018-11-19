package fr.utbm.to52.service;

import fr.utbm.to52.domain.Member;

/**
 * @author to52
 *
 */
public interface MemberService {

    public Member create (Member pMember);
    public void delete (Long id);
    public boolean checkIfMemberNameExist(String pMemberFirstName, String pMemberLastName);
}
