package org.cereme.business.services.contracts;

import org.cereme.model.Book;
import org.cereme.model.Borrowing;
import org.cereme.model.Work;

public interface BookService {

   Book findBookbyId(String bookid);

   String findBookAvailability(Book book, String bookid);

   Work findWorksByBookId(String bookid);
  
   Borrowing findBorrowingByBookId(String bookid);
}
