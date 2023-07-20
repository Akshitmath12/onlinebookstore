// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Book_Book_dd4baab93e_Test {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("1234567890", "Test Book", "Test Author", 10.0, 5);
    }

    @Test
    public void testBookBarcode() {
        assertEquals("1234567890", book.getBarcode(), "Barcode should be 1234567890");
    }

    @Test
    public void testBookName() {
        assertEquals("Test Book", book.getName(), "Name should be Test Book");
    }

    @Test
    public void testBookAuthor() {
        assertEquals("Test Author", book.getAuthor(), "Author should be Test Author");
    }

    @Test
    public void testBookPrice() {
        assertEquals(10.0, book.getPrice(), "Price should be 10.0");
    }

    @Test
    public void testBookQuantity() {
        assertEquals(5, book.getQuantity(), "Quantity should be 5");
    }

    @Test
    public void testBookWithInvalidPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("1234567890", "Test Book", "Test Author", -10.0, 5);
        });

        String expectedMessage = "Price cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testBookWithInvalidQuantity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("1234567890", "Test Book", "Test Author", 10.0, -5);
        });

        String expectedMessage = "Quantity cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
