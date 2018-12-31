package org.cereme.business.services.contracts;

import org.cereme.model.Borrowing;
import org.cereme.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findMemberByLastName(String lastname);

    Member findMemberById(Integer iduser);

    Member findMemberByFirstName(String firstname);
    
    Member findMemberByEmail(String email);
    
    String addMember(Member member);
    
    String deleteMember(Member member);

    String updateMember(Member member);
    
    List<Borrowing> findByMemberId(Integer iduser);
    Member findByUsername(String username);

    public boolean isValidUser(String userName, String password);

    Member updateMemberInfos(Member memberlogged);


}
