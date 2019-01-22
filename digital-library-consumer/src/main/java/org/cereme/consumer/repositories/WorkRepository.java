package org.cereme.consumer.repositories;

import org.cereme.model.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends CrudRepository<Work, Integer> {
	Work findByTitle(String title);
	List<Work> findWorkByAuthor(String author);
	List<Work> findWorkByPublicationYear(Integer publicationYear);
	List<Work> findWorkByLiteraryGenre(String literaryGenre);
	List<Work> findWorkByAuthorContains(String author);
	List<Work> findWorkByAuthorContainsAndTitleContains(String author, String title);
	List<Work> findAll();

}

