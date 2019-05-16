package org.cereme.webapp.controller;

import org.cereme.digital.library.clientws.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;



@Controller
public class WorkController {

	/*@Autowired
	WorkService workService;*/



	@RequestMapping(value = "/searchwork", method = RequestMethod.GET)
	public ModelAndView View(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("work/searchworks");


		return modelAndView;
	}

	@RequestMapping(value = "/work/workinformations/{worksId}", method = RequestMethod.GET)
	public ModelAndView ViewworkInfo(@PathVariable Integer worksId) {

		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		//workWs.init();

		ModelAndView modelAndView = new ModelAndView("work/workinformations");
		//Work work = workService.findWorksById(worksId);
		org.cereme.digital.library.clientws.Work work = workWs.findWorksById(worksId);
		modelAndView.addObject("work", work);


		return modelAndView;
	}



	@RequestMapping(value = "/library/author/{author}", method = RequestMethod.GET)
	public @ResponseBody
    List<org.cereme.digital.library.clientws.Work> getWorkByAuthor(@PathVariable String author) {

		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		//workWs.init();

		//List<Work> workList = workService.findWorkByAuthor(author);
		List<org.cereme.digital.library.clientws.Work> workList = workWs.findWorkByAuthor(author);
		for(org.cereme.digital.library.clientws.Work work : workList)
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


		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		//workWs.init();
		//List<Work> workList = workService.findWorkByAuthorContainsAndTitleContains(author,title);
		List<org.cereme.digital.library.clientws.Work> workList = workWs.findWorkByAuthorContainsAndTitleContains(author,title);


			ModelAndView modelAndView = new ModelAndView("work/searchedwork");
				modelAndView.addObject("workList", workList);


		return modelAndView;
	}


	/*@RequestMapping(value = "/work/year", method = RequestMethod.GET)
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
	}*/


}
