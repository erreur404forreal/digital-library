package org.cereme.business.services.contracts;

import org.cereme.model.Library;
import org.cereme.model.Work;

import java.util.List;

public interface LibraryService {

	Library getByWorkList(Work work);

	/*Library getLibraryByName(String libraryName);*/

	Library getLibraryById(int id);
	
	Library getLibraryByCity(String city);

	List<Work> findByLibraryId(int libraryid);
}
