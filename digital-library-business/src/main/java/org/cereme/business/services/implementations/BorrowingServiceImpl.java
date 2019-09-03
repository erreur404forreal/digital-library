package org.cereme.business.services.implementations;


import org.cereme.business.services.contracts.BorrowingService;
import org.cereme.consumer.repositories.BookRepository;
import org.cereme.consumer.repositories.BorrowingRepository;
import org.cereme.consumer.repositories.WorkRepository;
import org.cereme.model.Book;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BorrowingRepository borrowingRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	WorkRepository workRepository;

	public String addBorrowing(Borrowing borrowing) {
		borrowingRepository.save(borrowing);

		return "borrowing is saved";
	}


	public String deleteBorrowing(Borrowing borrowing) {
		borrowingRepository.delete(borrowing);
		return "borrowing is deleted";
	}

	public String updateBorrowing(Borrowing borrowing) {
		borrowingRepository.save(borrowing);

		return "borrowing is updated";
	}

	/*public Borrowing findByMember(Member member) {
		return borrowingRepository.findByMember(member);
	}*/

	public List<Borrowing> borrowingList(Borrowing borrowing) {
		return borrowingRepository.findAll();
	}

	public Borrowing findByBorrowingId(Integer idborrow) {
		return borrowingRepository.findById(idborrow).get();
	}


	public String borrowingStatus(Borrowing borrowing, Integer idborrow) {


		String borrowStatus = borrowingRepository.findById(idborrow).get().getStatus();
		return "your borrowing status is " + borrowStatus;
	}

	public String isExtended(Borrowing borrowing, Integer idborrow) {
		boolean status = borrowingRepository.findById(idborrow).get().isExtended();
		if (status == true) {
			return "Your borrowing is extended ";
		} else {
			return "Your borrowing is not extended";
		}

	}

	public List<Borrowing> findByStatus(String status) {
		return borrowingRepository.findByStatus(status);
	}


	public List<Borrowing> findByReturnDate(Date returnDate) {
		return borrowingRepository.findByReturnDate(returnDate);
	}

	public List<Borrowing> findByMember(Member member) {

		return borrowingRepository.findByMember(member);
	}


	public Borrowing findByMemberId(Integer iduser) {
		// TODO Auto-generated method stub
		return null;
	}


	public Borrowing findByBookId(String bookid) {
		// TODO Auto-generated method stub
		return null;
	}



	/*public boolean addBorrowing (List<String> booksid){
		boolean toReturn;
		for ( String bookid : booksid )
		{
			Book bookToBorrow = bookRepository.findById(bookid).get();
			Borrowing borrowToSave = new Borrowing();
			borrowToSave.setBook(bookToBorrow);

			//to do replace by connected member
			Member m1 = new Member ();
			m1.setIduser(1);
			m1.setFirstName("Lukas");
			m1.setLastName("George");
			borrowToSave.setMember(m1);

			borrowToSave.setIssueDate(new Date());
			// calculate the return date!

			//save the newest borrowing
			borrowingRepository.save(borrowToSave);
		}

		toReturn = true;
		return toReturn;
	}*/

	/**
	 * Create a borrowing list from work
	 * @param workId
	 * @return
	 */
	public Borrowing makeAborrowing(Integer workId, Member member){
		Borrowing borrowToReturn = null;
		Work workGot = workRepository.findById(workId).get();//Récuperer l'oeuvre, --> workGot
		List<Book> books= workGot.getBooks();

		for (Book book : books)
		{

			//Parcourir liste book de workGot
			//pour chaque book
			//si book Is Available
			if (book.isAvailable() == true)
			{
				Borrowing borrowingToSave = new Borrowing();
				borrowingToSave.setBook(book);
				borrowingToSave.setMember(member);
				//borrowingToSave.setIssueDate(LocalDate.now());
				Date now = new java.util.Date();
				borrowingToSave.setIssueDate(now);
				//add 4 week to the Issue date
				//LocalDate next4Week = borrowingToSave.getIssueDate().plus(4, ChronoUnit.WEEKS);

				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR,28);
				Date next4Week = calendar.getTime();
				borrowingToSave.setReturnDate(next4Week);

				borrowingToSave.setStatus("En Cours");
				borrowingToSave.getBook().setAvailable(false);
				borrowingToSave.setExtended(false);
				borrowingToSave.setTitleofbook(workGot.getTitle());
				//save borrowToSave, mettre dans un variable borrowToReturn le resultat de save
				borrowToReturn = borrowingRepository.save(borrowingToSave);
				break;

			}
		}
		//on ne fait rien(pas de else)


		return borrowToReturn;
	}

	public Borrowing extendAborrowing(Integer idborrow){
		Borrowing borrowToReturn = borrowingRepository.findBorrowingByIdborrow(idborrow);


		Date date = new Date(borrowToReturn.getIssueDate().getTime());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_YEAR,28);
		Date next4Week = calendar.getTime();

		//LocalDate next4Week = borrowToReturn.getReturnDate().plus(4, ChronoUnit.WEEKS);
		borrowToReturn.setReturnDate(next4Week);
		borrowToReturn.setStatus("En Cours et Prolongé");

		borrowToReturn.setExtended(true);
		borrowToReturn = borrowingRepository.save(borrowToReturn);


		return borrowToReturn;
	}

	public Borrowing endAborrowing(Integer idborrow){
		Borrowing borrowToReturn = borrowingRepository.findBorrowingByIdborrow(idborrow);

		Date now = new java.util.Date();
		borrowToReturn.setIssueDate(now);
		//borrowToReturn.setReturnDate(LocalDate.now());
		borrowToReturn.setStatus("Prêt terminé");
		borrowToReturn.getBook().setAvailable(true);
		borrowToReturn = borrowingRepository.save(borrowToReturn);


		return borrowToReturn;
	}



}
