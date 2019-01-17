package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.BorrowingService;
import org.cereme.business.services.contracts.MemberService;
import org.cereme.business.services.contracts.WorkService;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
    @Autowired
    WorkService workService;
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value="/borrowings/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Borrowing sayHello(@PathVariable int id){

        System.out.println("borrowing found");
        return this.borrowingService.findByBorrowingId(id);
    }




    @RequestMapping(value = "/borrowing/list", method = RequestMethod.GET)
    public ModelAndView searchbymember(HttpServletRequest request){
        String username = request.getParameter("login");
        Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");
        List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
        ModelAndView modelAndView = new ModelAndView("borrowing/borrowings");
        modelAndView.addObject("borrowingList", borrowingList);
        return modelAndView;
    }

    //extend borrowing
    @RequestMapping(value = "/borrowing/extend/{idborrow}", method = RequestMethod.GET)
    public ModelAndView Extendborrow(HttpServletRequest request, @PathVariable("idborrow") Integer idborrow) {

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre plus longtemps");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {
            Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");

            Borrowing borrowingextended = borrowingService.extendAborrowing(idborrow);
            List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
            modelAndView = new ModelAndView("borrowing/borrowings");
            modelAndView.addObject("loggedmember", loggedmember);
            modelAndView.addObject("borrowingextented", borrowingextended);
            modelAndView.addObject("borrowingList", borrowingList);

        }

        return modelAndView;
    }




    @RequestMapping(value = "/e-library/borrow/{worksId}", method = RequestMethod.GET)
    public ModelAndView borrowbook(HttpServletRequest request, @PathVariable("worksId") Integer worksId) {

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {

            Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");
            Work borrowed = workService.findWorksById(worksId);

                Borrowing borrowingmade = borrowingService.makeAborrowing(worksId, loggedmember);
                modelAndView = new ModelAndView("borrowing/succeeded");
                modelAndView.addObject("loggedmember", loggedmember);
                modelAndView.addObject("borrowedbook", borrowed);
                modelAndView.addObject("borrowingmade",borrowingmade);
        }


        return modelAndView;
    }

    //terminate borrowing
    @RequestMapping(value = "/borrowing/handover/{idborrow}", method = RequestMethod.GET)
    public ModelAndView Terminate(HttpServletRequest request, @PathVariable("idborrow") Integer idborrow) {

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre plus longtemps");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {
            Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");


            Borrowing borrowingended = borrowingService.endAborrowing(idborrow);
            //Récuperer la liste des emprunts de l'utilisatateur
            List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
            modelAndView = new ModelAndView("borrowing/borrowings");
            modelAndView.addObject("loggedmember", loggedmember);
            modelAndView.addObject("borrowingextented", borrowingended);
            modelAndView.addObject("borrowingList", borrowingList);

        }

        return modelAndView;
    }

}
