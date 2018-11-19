package fr.utbm.to52.service.memberServiceImpl;

import fr.utbm.to52.dao.MemberDao;
import fr.utbm.to52.domain.Member;
import fr.utbm.to52.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author to52
 *
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member create(Member pMember) {
        memberDao.save(pMember);
        return pMember;
    }

    @Override
    public void delete(Long id) {
        memberDao.delete(id);
    }

    @Override
    public boolean checkIfMemberNameExist(String pMemberFirstName, String pMemberLastName) {

        Member vMember = memberDao.findByFirstName(pMemberFirstName);

        return vMember != null;
    }
}
