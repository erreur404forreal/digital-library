package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.MemberService;
import org.cereme.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/member")
	public String home() {
		System.out.println("Member controller passing through to header.jsp outside the web inf");
		// return "/_include/header";
		return "home";
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public String sayHello(@PathVariable int id, Model model) {

		System.out.println("member found");
		String firstname = memberService.findMemberById(id).getFirstName();
		String lastname = memberService.findMemberById(id).getLastName();
		String email = memberService.findMemberById(id).getEmail();
		String username = memberService.findMemberById(id).getUsername();
		String address = memberService.findMemberById(id).getAddress();
		model.addAttribute("lastname", lastname);
		model.addAttribute("firstname", firstname);
		model.addAttribute("username",username);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/profile";
	}

	// TEST with model (to pass values from controller to view)
	@RequestMapping(value = "members/{id}", method = RequestMethod.GET)
	public String members(@PathVariable("id") int id, Model model) {
		System.out.println("try to go home jsp");
		Member member = this.memberService.findMemberById(id);
		String firstname = member.getFirstName();
		String lastname = member.getLastName();
		model.addAttribute("lastname", lastname);
		model.addAttribute("firstname", firstname);
		System.out.println("with model add atribute");
		return "library/home";
	}

	/*
	@RequestMapping(value = "library/login", method = RequestMethod.POST)
	public ModelAndView login(DispatcherServlet request, @ModelAttribute("member") Member member){

		String username = member.getUsername();
		String password = member.getPassword();
		String firstname = memberService.findByUsername(username).getFirstName();
		String lastname = memberService.findByUsername(username).getLastName();
		String email = memberService.findByUsername(username).getEmail();
		String address = memberService.findByUsername(username).getAddress();

		ModelAndView modelAndView = new ModelAndView("member/profile");

		List<String> informations = new ArrayList<>();
		informations.add(firstname);
		informations.add(lastname);
		informations.add(email);
		informations.add(address);

		modelAndView.addObject("informations", informations);
		return modelAndView;
	}*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView View(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("member/login");
		Member member = new Member();
		modelAndView.addObject("member", member);

		return modelAndView;
	}

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
		boolean result;

		ModelAndView modelAndView = null;
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println("Identifiants " + username + " " + password);
		if (username != null && password != null) {
			result = memberService.isValidUser(username, password);
			System.out.println(result);


			if (result == true) {
				modelAndView = new ModelAndView("member/profile");
				Member memberlogged = memberService.findByUsername(username);
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
		return modelAndView;
	}

	@RequestMapping(value = "/library/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request){

		request.getSession().setAttribute("loggedin", false);
		request.getSession().setAttribute("loggedmember", null);
		ModelAndView modelAndView = new ModelAndView("member/login");

		return modelAndView;
	}

    @RequestMapping(value = "/library/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView("library/home");

        return modelAndView;
    }

	@RequestMapping(value = "/member/member/changements", method = RequestMethod.POST)
	public ModelAndView changeinformations(HttpServletRequest request){


		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		Member memberlogged = memberService.findByUsername(username);
		memberlogged.setAddress(address);
		memberlogged.setUsername(username);
		memberlogged.setPassword(password);
		memberService.updateMember(memberlogged);




		ModelAndView modelAndView = new ModelAndView("member/profile");
        modelAndView.addObject("loggedmember", memberlogged);

		return modelAndView;
	}



	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
