package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Cart_Cart_49d2fb7651_Test {

    private Book book;
    private Cart cart;

    @BeforeEach
    public void setUp() {
        book = mock(Book.class);
        cart = new Cart();
    }

    @Test
    public void testCartConstructorWithValidQuantity() {
        int quantity = 5;
        cart.setBook(book);
        cart.setQuantity(quantity);
        assertEquals(book, cart.getBook());
        assertEquals(quantity, cart.getQuantity());
    }

    @Test
    public void testCartConstructorWithZeroQuantity() {
        int quantity = 0;
        cart.setBook(book);
        cart.setQuantity(quantity);
        assertEquals(book, cart.getBook());
        assertEquals(quantity, cart.getQuantity());
    }

    @Test
    public void testCartConstructorWithNegativeQuantity() {
        int quantity = -1;
        cart.setBook(book);
        cart.setQuantity(quantity);
        assertEquals(book, cart.getBook());
        assertEquals(quantity, cart.getQuantity());
    }
}
