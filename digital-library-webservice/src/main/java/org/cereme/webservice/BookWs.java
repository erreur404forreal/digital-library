package org.cereme.webservice;


import org.cereme.business.services.contracts.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Service
@WebService(serviceName = "bookWeb",name = "bookWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class BookWs{

    @Autowired
    BookService bookService;

    /*@WebMethod
    public void updateBook(Book book) {
        bookService.updateBook(book);
    }

    @WebMethod
    public List<Book> findAvailableBooksFromWork(Integer worksid) {
        return bookService.findAvailableBooksFromWork(worksid);
    }

    @WebMethod
    public Book findBookbyId(String bookid){
        return bookService.findBookbyId(bookid);
    }*/

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
