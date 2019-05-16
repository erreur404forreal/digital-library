package org.cereme.webservice;

import org.cereme.business.services.contracts.WorkService;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "workWeb",name = "workWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WorkWs {

    @Autowired
    WorkService workService;


    @WebMethod
    public List<Work> findWorkByAuthorContainsAndTitleContains(String author, String title) {
        return workService.findWorkByAuthorContainsAndTitleContains(author, title);
    }

    @WebMethod
    public boolean isValidByAuthor(String author) {
        return workService.isValidByAuthor(author);
    }
    @WebMethod
    public Work findWorksById(Integer worksid) {
        return workService.findWorksById(worksid);
    }

    @WebMethod
    public List<Work> findWorkByAuthor(String author) {
        return workService.findWorkByAuthor(author);
    }

    @WebMethod
    public List<Work> getAll() {

        return  workService.getAll();
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
