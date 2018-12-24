package org.cereme.business.services.implementations;


import org.cereme.model.Book;
import org.cereme.model.Borrowing;
import org.cereme.model.Work;
import org.cereme.business.services.contracts.BookService;
import org.cereme.consumer.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
    public Book findBookbyId(String bookid) {
        System.out.println("tout est ok dans le service book ");
        return bookRepository.findById(bookid).get();
    }


	@Override
	public String findBookAvailability(Book book, String bookid) {
		
		
		boolean availability = bookRepository.findById(bookid).get().isAvailable();

        return "Book " + bookid + " is " + availability;
	}


	@Override
	public Work findWorksByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getWork();
	}

	public Borrowing findBorrowingByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getBorrowing();
	}


}
