package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.LibraryService;
import org.cereme.business.services.contracts.WorkService;
import org.cereme.digital.library.clientws.LibraryWeb;
import org.cereme.digital.library.clientws.LibraryWs;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LibraryController {

   @Autowired
    LibraryService libraryService;
	WorkService workService;





	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(){

		ModelAndView modelAndView = new ModelAndView("member/login");

		return modelAndView;
	}





	 @RequestMapping(value="/connection")
	    public String login() {
	    	System.out.println("we are in librarycontroller");
	    	//libraryService.getWorkList(works)
	    	return "member/login";
	    }

	@RequestMapping(value="/registration")
	public String registration() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "member/registration";
	}

	@RequestMapping(value="/information")
	public String information() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "library/information";
	}

	@RequestMapping(value="/condition")
	public String condition() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "library/condition";
	}

	@RequestMapping(value="/batch")
	public String launchBatch() {

		LibraryWeb libraryWeb = new LibraryWeb();
		LibraryWs libraryWs = libraryWeb.getLibraryWsPort();
		libraryWs.init();

		System.out.println("we are sending the fbi if you're not sending our book back");
		//libraryService.checkBorrowingsStatus();
		libraryWs.checkBorrowingsStatus();
		return "home";
	}

}
