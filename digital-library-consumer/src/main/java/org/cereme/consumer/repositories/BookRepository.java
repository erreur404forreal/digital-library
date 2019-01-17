package org.cereme.consumer.repositories;

import org.cereme.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
	List<Book> findAll();
}
