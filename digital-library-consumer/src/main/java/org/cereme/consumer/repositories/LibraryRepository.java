package org.cereme.consumer.repositories;

import org.cereme.model.Library;
import org.cereme.model.Work;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {

	Library findByWorks(Work work);
	//Library findByLibraryName(String libraryname);
	Library findByCity(String city);  

}
