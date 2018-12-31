package org.cereme.model;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    private String bookId;
    private boolean isAvailable;
    @ManyToOne
    private Work work;
    @OneToOne
    private Borrowing borrowing;

    public Book(){

    }
    public Book(String bookId, boolean isAvailable, Work work, Borrowing borrowing) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.work = work;
        this.borrowing = borrowing;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Borrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }
}