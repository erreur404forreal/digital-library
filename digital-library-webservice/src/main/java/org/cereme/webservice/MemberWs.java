package org.cereme.webservice;

import org.cereme.business.services.contracts.MemberService;
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
@WebService(serviceName = "memberWeb",name = "memberWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class MemberWs{

    @Autowired
    MemberService memberService;

    @WebMethod
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @WebMethod
    public Member findByUsername(String username){

        return memberService.findByUsername(username);
    }

    @WebMethod
    public boolean isValidUser(String userName, String password) {
        return memberService.isValidUser(userName, password);
    }

    @WebMethod
    public String updateMember(Member member) {
        return memberService.updateMember(member);
    }



    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
