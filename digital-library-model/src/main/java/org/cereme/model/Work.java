package org.cereme.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Work")
public class Work {
    @Id
    @GeneratedValue(generator="gen_work", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen_work", sequenceName="seq_work", allocationSize=1)
    private Integer worksId;
    private String title;
    private String author;
    private Integer publicationYear;
    private String bookDescription;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;
    private String literaryGenre;
    private String imgUrl;
    private Integer copies;
    @ManyToOne
    private Library library;

    public Work(String title, String author, Integer publicationYear, String bookDescription, List<Book> books, String literaryGenre, String imgUrl, Integer copies, Library library) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.bookDescription = bookDescription;
        this.books = books;
        this.literaryGenre = literaryGenre;
        this.imgUrl = imgUrl;
        this.copies = copies;
        this.library = library;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Work() {
        super();
    }

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLiteraryGenre() {
        return literaryGenre;
    }

    public void setLiteraryGenre(String literaryGenre) {
        this.literaryGenre = literaryGenre;
    }


}
