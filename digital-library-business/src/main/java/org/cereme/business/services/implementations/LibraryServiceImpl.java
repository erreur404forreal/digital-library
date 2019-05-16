package org.cereme.business.services.implementations;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.cereme.business.services.contracts.LibraryService;
import org.cereme.consumer.repositories.BorrowingRepository;
import org.cereme.consumer.repositories.LibraryRepository;
import org.cereme.model.Borrowing;
import org.cereme.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

   @Autowired
   LibraryRepository libraryRepository;

    @Autowired
    BorrowingRepository borrowingRepository;


    /*public Library getByWorkList(Work work) {
    	return libraryRepository.findByWorks(work);
    }*/

    /*public Library getLibraryByName(String libraryName) {
        return libraryRepository.findByLibraryName(libraryName);
    }*/

    public Library getLibraryById(int id) {
        return libraryRepository.findById(id).get();
    }

    public Library getLibraryByCity(String city) {
    	return libraryRepository.findByCity(city);
    }

    public boolean checkBorrowingsStatus() {

    	List<Borrowing> borrowingList = borrowingRepository.findAll();
        Date now = new java.util.Date();

    	for( Borrowing borrowinglist : borrowingList)
        {
            System.out.println(borrowingList);
            String status = borrowinglist.getStatus();
            //Si la date de retour est passée et le status du livre est différent de Prêt terminé
            if(borrowinglist.getReturnDate().before(now) && (!status.equals("Prêt terminé")))
            {
                String PersonToMail = borrowinglist.getMember().getEmail();
                System.out.println(PersonToMail + " We got you !");
                System.out.println("Give that book back : " + borrowinglist.getTitleofbook());

                HtmlEmail email = new HtmlEmail();

                email.setHostName("smtp.googlemail.com");
                email.setSmtpPort(587);
                email.setAuthenticator(new DefaultAuthenticator("docledger@gmail.com", "994986ledger"));
                email.setSSLOnConnect(true);
                try {
                    email.addTo(PersonToMail, "");
                    email.setFrom("docledger@gmail.com", "The E-library");
                    email.setSubject("Ouvrage non retourné : (" + borrowinglist.getTitleofbook()+")");

                    // Html message

                    String message = "<html>Cher lecteur, ";
                    message+="<br><br>Nous espérons que vous appréciez les livres empruntés à notre bibliothèque";
                    message+="<br>Vous recevez cet email car nous avons constaté qu'un des livres que vous avez  emprunté est encore en votre possession alors que la date de sa restitution est dépassée.";
                    message+="<br>Vous pouvez obtenir des informations complémentaires en vous connectant à votre espace personnel.";
                    message+="<br>Merci de restituer au plus vite cet ouvrage : " + borrowinglist.getTitleofbook() + "<br>";
                    message+="<br>Si vous pensez que c'est une erreur veuillez nous écrire dès que possible à cette adresse : bibliogestion@biblo.com <br>";
                    message+="<br>Au plaisir de vous retrouver dans une nos bibliothèque !<br>";

                    email.setHtmlMsg(message);

                    // set the alternative message
                    email.setTextMsg("Your email client does not support HTML messages");

                    // send the email
                    email.send();
                    System.out.println("Mail has been sent successfully");
                }
                catch (EmailException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Unable to send an email" + e.getMessage());
                }

            }
            else { System.out.println("It's all goood"); }
        }




        return true;
    }
}
