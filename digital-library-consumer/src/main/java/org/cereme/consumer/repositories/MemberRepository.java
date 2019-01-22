package org.cereme.consumer.repositories;

import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member,Integer> {

	Member findByLastName(String lastname);
	Member findByFirstName(String firstname);
	Member findByUsername(String username);
	Member findByUsernameAndPassword(String username, String password);
	Member findByEmail(String email);
	List<Borrowing> findByBorrowing(Borrowing borrowing);
	//List<Borrowing> findById(int memberid);
	List<Member> findAll();
}
