package org.cereme.webservice;


import org.cereme.business.services.contracts.BorrowingService;
import org.cereme.model.Borrowing;
import org.cereme.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "borrowingWeb",name = "borrowingWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class BorrowingWs{

    @Autowired
    BorrowingService borrowingService;


    @WebMethod
    public Borrowing endAborrowing(Integer idborrow) {
        return borrowingService.endAborrowing(idborrow);
    }

    @WebMethod
    public Borrowing extendAborrowing(Integer idborrow) {
        return borrowingService.extendAborrowing(idborrow);
    }

    @WebMethod
    public Borrowing findByBorrowingId(Integer idborrow) {
        return borrowingService.findByBorrowingId(idborrow);
    }

    @WebMethod
    public List<Borrowing> findByMember(Member member) {
    	List<Borrowing> list = borrowingService.findByMember(member);
    	System.out.println(list);
    	return list;
//        return borrowingService.findByMember(member);
    }

    @WebMethod
    public Borrowing makeAborrowing(Integer workId, Member member) {
        return borrowingService.makeAborrowing(workId, member);
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
