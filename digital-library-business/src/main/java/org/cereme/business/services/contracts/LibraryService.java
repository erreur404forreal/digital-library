package org.cereme.business.services.contracts;

import org.cereme.model.Library;

public interface LibraryService {

	//Library getByWorkList(Work work);

	/*Library getLibraryByName(String libraryName);*/

	Library getLibraryById(int id);
	
	Library getLibraryByCity(String city);

	public boolean checkBorrowingsStatus();

	//List<Work> findByLibraryId(int libraryid);
}
