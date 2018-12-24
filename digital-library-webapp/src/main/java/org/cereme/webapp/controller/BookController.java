package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.BookService;
import org.cereme.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

   @Autowired
    BookService bookService;


    @RequestMapping(value="/book/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Book sayHello(@PathVariable String id){

        System.out.println("book found");
        return this.bookService.findBookbyId(id);
    }


    /*
     public String searchBook(ModelMap modelMap) {
     
       bookService.findBookbyId("nar1");

        modelMap.addAttribute("message", "mvc");
    System.out.println("helo");
        return "hello";
    }*/
}
