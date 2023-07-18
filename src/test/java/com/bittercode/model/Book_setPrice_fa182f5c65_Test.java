package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Book_setPrice_fa182f5c65_Test {
    private Book book;

    @BeforeEach
    public void setup() {
        book = new Book();
    }

    @Test
    public void testSetPrice_PositiveValue() {
        double price = 50.0;
        book.setPrice(price);
        assertEquals(price, book.getPrice(), "The price should be set correctly");
    }

    @Test
    public void testSetPrice_ZeroValue() {
        double price = 0.0;
        book.setPrice(price);
        assertEquals(price, book.getPrice(), "The price should be set correctly even if it's zero");
    }

    // TODO: The following test case is for negative price. If your business logic allows negative price, enable this test case
    /*
    @Test
    public void testSetPrice_NegativeValue() {
        double price = -10.0;
        book.setPrice(price);
        assertEquals(price, book.getPrice(), "The price should be set correctly even if it's negative");
    }
    */
}
