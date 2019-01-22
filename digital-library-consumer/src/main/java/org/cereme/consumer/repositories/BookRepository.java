package org.cereme.consumer.repositories;

import org.cereme.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    
	List<Book> findAll();
}
