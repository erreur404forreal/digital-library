package org.cereme.consumer.repositories;

import org.cereme.model.Book;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {


	List<Borrowing> findAll();
	List<Borrowing> findByMember(Member member);
	Borrowing findByBook(Book book);
	List<Borrowing> findByReturnDate(Date returnDate);
	List<Borrowing> findByStatus(String status);
	Borrowing findBorrowingByIdborrow(Integer idborrow);

	//boolean findBo
	
}
