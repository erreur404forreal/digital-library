package org.cereme.business.services.implementations;

import org.cereme.business.services.contracts.WorkService;
import org.cereme.consumer.repositories.WorkRepository;
import org.cereme.model.Book;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
    WorkRepository workRepository;

	public List<Work> getAll(){
		return workRepository.findAll();
	}
    public Work findWorksById(Integer worksid) {
        return workRepository.findById(worksid).get();
    }

    /**
     * Return all books from one author
     * @param author
     * @return
     */

    public boolean isValidWorkByAuthor(String author) {
        boolean retVal= false;
        /*Work work = WorkRepository.find
        if(member != null){
            retVal=true;
        }*/
        return retVal;
    }


    public List<Work> findWorkByAuthor(String author) {

        return workRepository.findWorkByAuthor(author);
    }

    public List<Work> findWorkByAuthorContains(String author){
        return workRepository.findWorkByAuthorContains(author);
    }

    public boolean isValidByYear(Integer publicationYear) {
        boolean retVal= false;
        List<Work> work = workRepository.findWorkByPublicationYear(publicationYear);
        if(work != null){
            retVal=true;
        }
        return retVal;
    }
    public boolean isValidByAuthor(String author) {
        boolean retVal= false;
        List<Work> work = workRepository.findWorkByAuthorContains(author);
        if(work != null){
            retVal=true;
        }
        return retVal;
    }
    @Override
    public List<Work> findWorkByPublicationYear(Integer publicationYear) {
        return workRepository.findWorkByPublicationYear(publicationYear);
    }



    @Override
    public List<Work> findWorkByLiteraryGenre(String literaryGenre) {
        return workRepository.findWorkByLiteraryGenre(literaryGenre);
    }

   public Work findWorksByTitle(String title) {
        return workRepository.findByTitle(title);
    }

    public String addWorks(Work work) {
        workRepository.save(work);
        return "save work";
    }

    public String deleteWorks(Work work) {
    	workRepository.delete(work);
        return work.getTitle() + " is deleted.";
    }

    public String updateWorks(Work work) {
    	workRepository.save(work);
        return "work is updated!";
    }
    public List<Book> findByWorksId(Integer worksid){
    	return workRepository.findById(worksid).get().getBooks();
    }

    public List<Work> findWorkByAuthorContainsAndTitleContains(String author, String title){
        List<Work> workList = workRepository.findWorkByAuthorContainsAndTitleContains(author, title);
        return workList;
    }



}
