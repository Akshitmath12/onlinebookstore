package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Book_getQuantity_2dd1a62113_Test {

    private Book book;

    @BeforeEach
    public void setup() {
        book = Mockito.mock(Book.class);
        Mockito.when(book.getQuantity()).thenReturn(5);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(5, book.getQuantity(), "Quantity should be 5");
    }

    @Test
    public void testGetQuantityFailure() {
        Mockito.when(book.getQuantity()).thenReturn(10);
        assertEquals(5, book.getQuantity(), "Quantity should be 5 but found 10");
    }
}
