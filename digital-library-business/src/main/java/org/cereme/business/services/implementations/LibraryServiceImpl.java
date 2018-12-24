package org.cereme.business.services.implementations;
import org.cereme.model.Work;
import org.cereme.model.Library;
import org.cereme.business.services.contracts.LibraryService;
import org.cereme.consumer.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

   @Autowired
   LibraryRepository libraryRepository;

    public Library getByWorkList(Work work) {
    	return libraryRepository.findByWorks(work);
    }

    /*public Library getLibraryByName(String libraryName) {
        return libraryRepository.findByLibraryName(libraryName);
    }*/

    public Library getLibraryById(int id) {
        return libraryRepository.findById(id).get();
    }

    public Library getLibraryByCity(String city) {
    	return libraryRepository.findByCity(city);
    }
    public List<Work> findByLibraryId(int libraryid) {
    	List<Work> workslist = libraryRepository.findById(libraryid).get().getWorks();
    	return workslist;
    }
}
