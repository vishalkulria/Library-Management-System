package com.library.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Java Programming", "John Doe", "ISBN-123", "Programming", 5);
    }

    @Test
    public void testBookCreation() {
        assertNotNull(book);
        assertEquals("Java Programming", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals("ISBN-123", book.getIsbn());
        assertEquals("Programming", book.getCategory());
        assertEquals(5, book.getQuantity());
    }

    @Test
    public void testBookUpdate() {
        book.setTitle("Advanced Java");
        book.setQuantity(10);
        assertEquals("Advanced Java", book.getTitle());
        assertEquals(10, book.getQuantity());
    }

    @Test
    public void testToString() {
        String expected = "Java Programming | John Doe | ISBN-123 | Programming | Qty: 5";
        assertEquals(expected, book.toString());
    }
}
