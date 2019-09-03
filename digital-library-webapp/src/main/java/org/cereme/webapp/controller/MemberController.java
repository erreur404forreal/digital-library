package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.MemberService;
import org.cereme.digital.library.clientws.Member;
import org.cereme.digital.library.clientws.MemberWeb;
import org.cereme.digital.library.clientws.MemberWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;


	@RequestMapping(value = "/member/profile", method = RequestMethod.GET)
	public ModelAndView Viewprofile(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("member/profile");

		return modelAndView;
	}

	@RequestMapping(value = "/member/changeinfos", method = RequestMethod.GET)
	public ModelAndView changeprofile(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("member/changeinf");

		return modelAndView;
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request) {




		MemberWeb memberWeb = new MemberWeb();
		MemberWs memberWs = memberWeb.getMemberWsPort();
		memberWs.init();
		boolean result;

		ModelAndView modelAndView = null;

		try {

		String username = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println("Identifiants utilisés : " + username + " " + password);
		if (username != null && password != null) {
//			result = memberService.isValidUser(username, password);
			result = memberWs.isValidUser(username, password);
			System.out.println("Utilisateur valide");


			if (result) {
				modelAndView = new ModelAndView("member/profile");
				Member memberlogged = memberWs.findByUsername(username);
				System.out.println("Step_1");
//				org.cereme.digital.library.clientws.Member memberlogged = memberWs.findByUsername(username);
				System.out.println("Utilisateur trouvé : " + username);
						request.getSession().setAttribute("loggedin", true);
				request.getSession().setAttribute("loggedmember", memberlogged);
				modelAndView.addObject("loggedmember", memberlogged);
			} else {
				modelAndView = new ModelAndView("member/login");
				modelAndView.addObject("msg", "L'utilisateur ou le mot de passe est incorrect");
			}
		} else {
			modelAndView = new ModelAndView("member/login");
			modelAndView.addObject("msg", "une erreur est survenue lors du traitement");
		}
		}catch (Exception e){
			System.out.println(e.toString());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/library/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request){

		request.getSession().setAttribute("loggedin", false);
		request.getSession().setAttribute("loggedmember", null);
		ModelAndView modelAndView = new ModelAndView("member/login");
		modelAndView.addObject("msg", "Vous vous êtes bien déconnecté");

		return modelAndView;
	}


	@RequestMapping(value = "/member/member/changements", method = RequestMethod.POST)
	public ModelAndView changeinformations(HttpServletRequest request){
		MemberWeb memberWeb = new MemberWeb();
		MemberWs memberWs = memberWeb.getMemberWsPort();
		memberWs.init();

		String username = request.getParameter("username");

		String email = request.getParameter("email");
		String address = request.getParameter("address");

		Member memberlogged = memberWs.findByUsername(username);
		//org.cereme.digital.library.clientws.Member memberlogged = memberWs.findByUsername(username);
		memberlogged.setAddress(address);
		memberlogged.setEmail(email);
//		memberService.updateMember(memberlogged);
		memberWs.updateMember(memberlogged);

		ModelAndView modelAndView = new ModelAndView("member/profile");
        modelAndView.addObject("loggedmember", memberlogged);

		return modelAndView;
	}

}
