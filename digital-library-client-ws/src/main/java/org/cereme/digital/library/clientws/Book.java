
package org.cereme.digital.library.clientws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="borrowing" type="{http://webservice.cereme.org/}borrowing" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "available",
    "bookId",
    "borrowing"
})
public class Book {

    protected boolean available;
    protected int bookId;
    protected Borrowing borrowing;

    /**
     * Obtient la valeur de la propriété available.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Définit la valeur de la propriété available.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Obtient la valeur de la propriété bookId.
     * 
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Définit la valeur de la propriété bookId.
     * 
     */
    public void setBookId(int value) {
        this.bookId = value;
    }

    /**
     * Obtient la valeur de la propriété borrowing.
     * 
     * @return
     *     possible object is
     *     {@link Borrowing }
     *     
     */
    public Borrowing getBorrowing() {
        return borrowing;
    }

    /**
     * Définit la valeur de la propriété borrowing.
     * 
     * @param value
     *     allowed object is
     *     {@link Borrowing }
     *     
     */
    public void setBorrowing(Borrowing value) {
        this.borrowing = value;
    }

}
