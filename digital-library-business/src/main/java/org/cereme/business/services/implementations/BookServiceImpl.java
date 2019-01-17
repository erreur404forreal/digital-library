package org.cereme.business.services.implementations;


import org.cereme.business.services.contracts.BookService;
import org.cereme.consumer.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	


}
