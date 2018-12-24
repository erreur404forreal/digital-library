package org.cereme.business.services.implementations;

import org.cereme.business.services.contracts.MemberService;
import org.cereme.consumer.repositories.MemberRepository;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;


	public boolean isValidUser(String userName, String password) {
		boolean retVal= false;
		Member member = memberRepository.findByUsernameAndPassword(userName, password);
		if(member != null){
			retVal=true;
		}
		return retVal;
	}
	public Member findMemberById(Integer iduser) {
    	return memberRepository.findById(iduser).get();
    }
    public List<Member> findAll() {
    	//System.out.println("we are in member repository");
    	return memberRepository.findAll();
    }

    public Member findMemberByLastName(String lastname) {
        return memberRepository.findByLastName(lastname);
    }


    public Member findMemberByFirstName(String firstname) {
        return memberRepository.findByFirstName(firstname);
    }
    
    public Member findMemberByEmail (String email) {
    	return memberRepository.findByEmail(email);
    }

	@Override
	public String addMember(Member member) {
		memberRepository.save(member);
		return member.getFirstName() + " one of our loyal member. Welcome!";
	}

	@Override
	public String deleteMember(Member member) {
		memberRepository.delete(member);
		return "Member with id " + member.getIduser()  + " is deleted";
	}

	@Override
	public String updateMember(Member member) {
		memberRepository.save(member);
		return "Member with id " + member.getIduser() + " is updated";
	}
	
	public List<Borrowing> findByMemberId(Integer iduser){
		List<Borrowing> borrowlist = memberRepository.findById(iduser).get().getBorrowing();
		return borrowlist;
	}
	
	@Override
	public Member findByUsername(String username) {
		
		return memberRepository.findByUsername(username);
	}

    public Member updateMemberInfos(Member memberUpdated, Member memberUpdating )
    {
        return memberUpdated;
    }
	/*
	@Transactional 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		return null;
	}
	*/

    
}
