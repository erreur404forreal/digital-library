
package org.cereme.digital.library.clientws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour work complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="work">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="books" type="{http://webservice.cereme.org/}book" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="copies" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="library" type="{http://webservice.cereme.org/}library" minOccurs="0"/>
 *         &lt;element name="literaryGenre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicationYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="worksId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "work", propOrder = {
    "author",
    "bookDescription",
    "books",
    "copies",
    "imgUrl",
    "library",
    "literaryGenre",
    "publicationYear",
    "title",
    "worksId"
})
public class Work {

    protected String author;
    protected String bookDescription;
    @XmlElement(nillable = true)
    protected List<Book> books;
    protected Integer copies;
    protected String imgUrl;
    protected Library library;
    protected String literaryGenre;
    protected int publicationYear;
    protected String title;
    protected Integer worksId;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété bookDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Définit la valeur de la propriété bookDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookDescription(String value) {
        this.bookDescription = value;
    }

    /**
     * Gets the value of the books property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the books property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Book }
     * 
     * 
     */
    public List<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<Book>();
        }
        return this.books;
    }

    /**
     * Obtient la valeur de la propriété copies.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * Définit la valeur de la propriété copies.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCopies(Integer value) {
        this.copies = value;
    }

    /**
     * Obtient la valeur de la propriété imgUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Définit la valeur de la propriété imgUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgUrl(String value) {
        this.imgUrl = value;
    }

    /**
     * Obtient la valeur de la propriété library.
     * 
     * @return
     *     possible object is
     *     {@link Library }
     *     
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Définit la valeur de la propriété library.
     * 
     * @param value
     *     allowed object is
     *     {@link Library }
     *     
     */
    public void setLibrary(Library value) {
        this.library = value;
    }

    /**
     * Obtient la valeur de la propriété literaryGenre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiteraryGenre() {
        return literaryGenre;
    }

    /**
     * Définit la valeur de la propriété literaryGenre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiteraryGenre(String value) {
        this.literaryGenre = value;
    }

    /**
     * Obtient la valeur de la propriété publicationYear.
     * 
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Définit la valeur de la propriété publicationYear.
     * 
     */
    public void setPublicationYear(int value) {
        this.publicationYear = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtient la valeur de la propriété worksId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWorksId() {
        return worksId;
    }

    /**
     * Définit la valeur de la propriété worksId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWorksId(Integer value) {
        this.worksId = value;
    }

}
