package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.WorkService;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class WorkController {

	@Autowired
	WorkService workService;


	@RequestMapping(value = "/searchwork", method = RequestMethod.GET)
	public ModelAndView View(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("work/searchworks");


		return modelAndView;
	}

	@RequestMapping(value = "/work/workinformations/{worksId}", method = RequestMethod.GET)
	public ModelAndView ViewworkInfo(@PathVariable Integer worksId) {

		ModelAndView modelAndView = new ModelAndView("work/workinformations");
		Work work = workService.findWorksById(worksId);
		modelAndView.addObject("work", work);


		return modelAndView;
	}

	@RequestMapping(value = "/work/{id}", method = RequestMethod.GET)
	public @ResponseBody
    String sayHello(@PathVariable Integer id) {

		System.out.println("work found");
		String title = workService.findWorksById(id).getTitle();
		return "The book is " + title;
	}


	@RequestMapping(value = "/library/author/{author}", method = RequestMethod.GET)
	public @ResponseBody
    List<Work> getWorkByAuthor(@PathVariable String author) {

		List<Work> workList = workService.findWorkByAuthor(author);
		for(Work work : workList)
		{
			System.out.println("Titre : " + work.getTitle());
			System.out.println("Auteur : " + work.getAuthor());
			System.out.println("Description du livre : " + work.getBookDescription());


		}
		return workList;

	}




	@RequestMapping(value = "/work/search", method = RequestMethod.GET)
	public ModelAndView searchbyauthorlikeafter(@RequestParam("author") String author, @RequestParam("title") String title) {
		System.out.println("searching by author");
		List<Work> workList = workService.findWorkByAuthorContainsAndTitleContains(author,title);


			ModelAndView modelAndView = new ModelAndView("work/searchedwork");
				modelAndView.addObject("workList", workList);


		return modelAndView;
	}



	/*@RequestMapping(value = "/work/library/genre/{literarygenre}", method = RequestMethod.GET)
	public @ResponseBody
	List<Work> getWorksbyLiteraryGenre(@PathVariable String literaryGenre) {
		List<Work> workList = workService.findWorkByLiteraryGenre(literaryGenre);
		for(Work work : workList)
		{
			System.out.println("Titre : " + work.getTitle());
			System.out.println("Auteur : " + work.getAuthor());
			System.out.println("Description du livre : " + work.getBookDescription());
		}
        //Retourner page jsp avec modeleandview contenant le worklist
		return workList;

	}*/


	@RequestMapping(value = "/work/year", method = RequestMethod.GET)
	public ModelAndView searchbyyear(@PathVariable Integer publicationYear) {
		boolean verification;
		System.out.println("searching by year");
		ModelAndView modelAndView = null;

		List<Work> workList = workService.findWorkByPublicationYear(publicationYear);
		verification = workService.isValidByYear(publicationYear);
		if(verification)
		{
			if(publicationYear!=null)
			{
				modelAndView = new ModelAndView("work/searchedwork");
				modelAndView.addObject("workList", workList);
			}else{
				modelAndView = new ModelAndView("library/errorpage");
				modelAndView.addObject("msg", "une erreur est survenue lors du traitement de la recherche");

			}
		}else{
			modelAndView = new ModelAndView("library/errorpage");
			modelAndView.addObject("msg", "une erreur est survenue lors du traitement");
		}

		return modelAndView;
	}







}
