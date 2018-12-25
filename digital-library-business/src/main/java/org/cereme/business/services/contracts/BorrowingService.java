package org.cereme.business.services.contracts;

import org.cereme.model.Borrowing;
import org.cereme.model.Member;

import java.util.Date;
import java.util.List;

public interface BorrowingService {

    //boolean addBorrowing(List<String> booksid);
    String deleteBorrowing(Borrowing borrowing);
    String updateBorrowing(Borrowing borrowing);
    Borrowing findByMemberId(Integer iduser);
    Borrowing findByBookId(String booksid);
    Borrowing findByBorrowingId(Integer idborrow);
    List<Borrowing> findByReturnDate(Date returnDate);
    List<Borrowing> findByStatus(String status);
    List<Borrowing> findByMember(Member member);
    String borrowingStatus(Borrowing borrowing, Integer idborrow);
    String isExtended(Borrowing borrowing, Integer idborrow);

    Borrowing makeAborrowing(Integer workId, Member member);
    Borrowing extendAborrowing(Integer idborrow);
    Borrowing endAborrowing(Integer idborrow);

}
