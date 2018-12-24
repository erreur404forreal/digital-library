package org.cereme.model;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String status;
    private boolean isExtended;


    public Borrowing(){

    }

    public Borrowing(Member member, Book book, LocalDate issueDate, LocalDate returnDate, String status, boolean isExtended) {
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.isExtended = isExtended;
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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExtended() {
        return isExtended;
    }


    public void setExtended(boolean extended) {
        isExtended = extended;
    }
}
