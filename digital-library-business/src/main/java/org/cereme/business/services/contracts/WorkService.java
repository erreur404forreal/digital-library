package org.cereme.business.services.contracts;

import org.cereme.model.Book;
import org.cereme.model.Work;

import java.util.List;

public interface WorkService {

   // List<Work> getAllByLibraryId(int libraryid);
    List<Work> getAll();
    Work findWorksById(Integer worksid);
    List<Work> findWorkByAuthor(String author);
    List<Work> findWorkByPublicationYear(Integer publicationYear);
    List<Work> findWorkByLiteraryGenre (String literaryGenre);

    List<Work> findWorkByAuthorContains(String author);
    List<Work> findWorkByAuthorContainsAndTitleContains(String author, String title);

    Work findWorksByTitle(String title);
    String addWorks(Work work);
    String deleteWorks(Work work);
    String updateWorks(Work work);
    List<Book> findByWorksId(Integer worksid);
    public boolean isValidByYear(Integer publicationYear);
    public boolean isValidByAuthor(String author);

    
}
