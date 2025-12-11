package com.library.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssuedBook {
    private Book book;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    public IssuedBook(Book book, LocalDate issueDate, LocalDate dueDate) {
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.fine = 0;
    }

    public String getStatus() {
        if (returnDate != null) {
            return "Returned on " + returnDate;
        } else {
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            if (daysOverdue > 0) {
                this.fine = daysOverdue * 5.0;
                return "Overdue by " + daysOverdue + " days. Fine: Rs" + fine;
            }
            return "Active";
        }
    }

    // Getters and Setters
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
