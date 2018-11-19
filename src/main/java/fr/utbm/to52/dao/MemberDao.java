package fr.utbm.to52.dao;

import fr.utbm.to52.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author to52
 *
 */
@Repository
public interface MemberDao extends CrudRepository<Member, Long> {

    public Member findByFirstName(String pMemberFirstName);
}
