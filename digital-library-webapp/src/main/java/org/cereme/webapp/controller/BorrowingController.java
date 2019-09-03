package org.cereme.webapp.controller;

import org.cereme.business.services.contracts.BorrowingService;
import org.cereme.business.services.contracts.MemberService;
import org.cereme.business.services.contracts.WorkService;
import org.cereme.digital.library.clientws.BorrowingWeb;
import org.cereme.digital.library.clientws.BorrowingWs;
import org.cereme.digital.library.clientws.WorkWeb;
import org.cereme.digital.library.clientws.WorkWs;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        //return this.borrowingWs.findByBorrowingId(id);
    }




    @RequestMapping(value = "/borrowing/list", method = RequestMethod.GET)
    public ModelAndView searchbymember(HttpServletRequest request){

        WorkWeb workWeb = new WorkWeb();
        WorkWs workWs = workWeb.getWorkWsPort();
        workWs.init();

        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        borrowingWs.init();

        String username = request.getParameter("login");
        //Member loggedmember = (Member) request.getSession().getAttribute("loggedmember");
        org.cereme.digital.library.clientws.Member loggedmember;
        loggedmember = (org.cereme.digital.library.clientws.Member)request.getSession().getAttribute("loggedmember");
        //List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
        List<org.cereme.digital.library.clientws.Borrowing> borrowingList = borrowingWs.findByMember(loggedmember);
        ModelAndView modelAndView = new ModelAndView("borrowing/borrowings");
        modelAndView.addObject("borrowingList", borrowingList);
        return modelAndView;
    }

    //extend borrowing
    @RequestMapping(value = "/borrowing/extend/{idborrow}", method = RequestMethod.GET)
    public ModelAndView Extendborrow(HttpServletRequest request, @PathVariable("idborrow") Integer idborrow) {

        WorkWeb workWeb = new WorkWeb();
        WorkWs workWs = workWeb.getWorkWsPort();
        workWs.init();

        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        borrowingWs.init();

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre plus longtemps");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {
            //Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");
            org.cereme.digital.library.clientws.Member loggedmember;
            loggedmember = (org.cereme.digital.library.clientws.Member)request.getSession().getAttribute("loggedmember");
            //Borrowing borrowingextended = borrowingService.extendAborrowing(idborrow);
            org.cereme.digital.library.clientws.Borrowing borrowingextended = borrowingWs.endAborrowing(idborrow);
            //List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
            List<org.cereme.digital.library.clientws.Borrowing> borrowingList = borrowingWs.findByMember(loggedmember);
            modelAndView = new ModelAndView("borrowing/borrowings");
            modelAndView.addObject("loggedmember", loggedmember);
            modelAndView.addObject("borrowingextented", borrowingextended);
            modelAndView.addObject("borrowingList", borrowingList);

        }

        return modelAndView;
    }




    @RequestMapping(value = "/e-library/borrow/{worksId}", method = RequestMethod.GET)
    public ModelAndView borrowbook(HttpServletRequest request, @PathVariable("worksId") Integer worksId) {

        WorkWeb workWeb = new WorkWeb();
        WorkWs workWs = workWeb.getWorkWsPort();
        workWs.init();

        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        borrowingWs.init();

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {

            //Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");
            org.cereme.digital.library.clientws.Member loggedmember ;
            loggedmember = (org.cereme.digital.library.clientws.Member)request.getSession().getAttribute("loggedmember");
            //Work borrowed = workService.findWorksById(worksId);
            org.cereme.digital.library.clientws.Work borrowed = workWs.findWorksById(worksId);

                //Borrowing borrowingmade = borrowingService.makeAborrowing(worksId, loggedmember);
                org.cereme.digital.library.clientws.Borrowing borrowingmade = borrowingWs.makeAborrowing(worksId, loggedmember);
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

        WorkWeb workWeb = new WorkWeb();
        WorkWs workWs = workWeb.getWorkWsPort();
        workWs.init();

        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        borrowingWs.init();

        ModelAndView modelAndView = null;
        if (request != null && request.getSession().getAttribute("loggedin") == null) {
            modelAndView = new ModelAndView("member/login");
            modelAndView.addObject("msg", "Connectez vous pour emprunter un livre plus longtemps");
        }else if(request != null && request.getSession().getAttribute("loggedin") != null)
        {
            //Member loggedmember = (Member)request.getSession().getAttribute("loggedmember");
            org.cereme.digital.library.clientws.Member loggedmember;
            loggedmember = (org.cereme.digital.library.clientws.Member)request.getSession().getAttribute("loggedmember");

           //Borrowing borrowingended = borrowingService.endAborrowing(idborrow);
            org.cereme.digital.library.clientws.Borrowing borrowingended = borrowingWs.endAborrowing(idborrow);
            //Récuperer la liste des emprunts de l'utilisatateur
            //List<Borrowing> borrowingList =  borrowingService.findByMember(loggedmember);
            List<org.cereme.digital.library.clientws.Borrowing> borrowingList = borrowingWs.findByMember(loggedmember);
            modelAndView = new ModelAndView("borrowing/borrowings");
            modelAndView.addObject("loggedmember", loggedmember);
            modelAndView.addObject("borrowingextented", borrowingended);
            modelAndView.addObject("borrowingList", borrowingList);

        }

        return modelAndView;
    }

}
