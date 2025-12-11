package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String phone;
    private List<IssuedBook> issuedBooks;

    public Student(String studentId, String name, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.issuedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + phone + ")";
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void addIssuedBook(IssuedBook book) {
        this.issuedBooks.add(book);
    }

    public void removeIssuedBook(IssuedBook book) {
        this.issuedBooks.remove(book);
    }
}
