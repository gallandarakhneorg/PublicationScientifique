package fr.utbm.to52.service;

import fr.utbm.to52.domain.Member;

/**
 * @author to52
 *
 */
public interface MemberService {

    public Member create (Member pmember);
    public Member delete (Long id);
}
