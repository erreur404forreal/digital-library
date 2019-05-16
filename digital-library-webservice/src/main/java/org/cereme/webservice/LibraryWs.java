package org.cereme.webservice;


import org.cereme.business.services.contracts.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Service
@WebService(serviceName = "libraryWeb",name = "libraryWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

public class LibraryWs {

    @Autowired
    LibraryService libraryService;

    @WebMethod
    public boolean checkBorrowingsStatus()
    {
        return libraryService.checkBorrowingsStatus();
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
