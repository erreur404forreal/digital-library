package org.cereme.model;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    private int bookId;
    private boolean isAvailable;
    @OneToOne
    private Borrowing borrowing;

    public Book(){

    }

    public Book(int bookId, boolean isAvailable, Borrowing borrowing) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.borrowing = borrowing;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Borrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }
}
