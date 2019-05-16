package org.cereme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(generator="gen_borrow", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen_borrow", sequenceName="seq_borrow", allocationSize=1)
    private Integer idborrow;
    @ManyToOne
    private Member member;
    @OneToOne
    private Book book;
    private Date issueDate;
    private Date returnDate;
    private String status;
    private boolean isExtended;
    private String Titleofbook;


    public Borrowing(){

    }

    public String getTitleofbook() {
        return Titleofbook;
    }

    public void setTitleofbook(String titleofbook) {
        Titleofbook = titleofbook;
    }

    public Borrowing(Member member, Book book, Date issueDate, Date returnDate, String status, boolean isExtended, String titleofbook) {
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.isExtended = isExtended;
        Titleofbook = titleofbook;
    }

    public Integer getIdborrow() {
        return idborrow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdborrow(Integer idborrow) {
        this.idborrow = idborrow;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExtended() {
        return isExtended;
    }


    public void setExtended(boolean extended) {
        isExtended = extended;
    }
}
