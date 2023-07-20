package com.bittercode.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class Book_getPrice_d97185b3e6_Test {

    private Book book;

    @Before
    public void setUp() {
        book = Mockito.mock(Book.class);
    }

    @Test
    public void testGetPriceSuccess() {
        double expectedPrice = 19.99;
        Mockito.when(book.getPrice()).thenReturn(expectedPrice);

        double actualPrice = book.getPrice();
        assertEquals("Price should match the expected value", expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void testGetPriceFailure() {
        double unexpectedPrice = 29.99;
        Mockito.when(book.getPrice()).thenReturn(unexpectedPrice);

        double actualPrice = book.getPrice();
        double expectedPrice = 19.99;
        assertNotEquals("Price should not match the unexpected value", unexpectedPrice, actualPrice, 0.01);
    }
}
