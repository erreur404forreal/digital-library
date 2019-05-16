
package org.cereme.digital.library.clientws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.cereme.digital.library.clientws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckBorrowingsStatus_QNAME = new QName("http://webservice.cereme.org/", "checkBorrowingsStatus");
    private final static QName _Init_QNAME = new QName("http://webservice.cereme.org/", "init");
    private final static QName _InitResponse_QNAME = new QName("http://webservice.cereme.org/", "initResponse");
    private final static QName _CheckBorrowingsStatusResponse_QNAME = new QName("http://webservice.cereme.org/", "checkBorrowingsStatusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.cereme.digital.library.clientws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link CheckBorrowingsStatusResponse }
     * 
     */
    public CheckBorrowingsStatusResponse createCheckBorrowingsStatusResponse() {
        return new CheckBorrowingsStatusResponse();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link CheckBorrowingsStatus }
     * 
     */
    public CheckBorrowingsStatus createCheckBorrowingsStatus() {
        return new CheckBorrowingsStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBorrowingsStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cereme.org/", name = "checkBorrowingsStatus")
    public JAXBElement<CheckBorrowingsStatus> createCheckBorrowingsStatus(CheckBorrowingsStatus value) {
        return new JAXBElement<CheckBorrowingsStatus>(_CheckBorrowingsStatus_QNAME, CheckBorrowingsStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cereme.org/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cereme.org/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBorrowingsStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cereme.org/", name = "checkBorrowingsStatusResponse")
    public JAXBElement<CheckBorrowingsStatusResponse> createCheckBorrowingsStatusResponse(CheckBorrowingsStatusResponse value) {
        return new JAXBElement<CheckBorrowingsStatusResponse>(_CheckBorrowingsStatusResponse_QNAME, CheckBorrowingsStatusResponse.class, null, value);
    }

}
