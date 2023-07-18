package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Cart_setQuantity_b95da82df2_Test {

    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testSetQuantityPositive() {
        int quantity = 10;
        cart.setQuantity(quantity);
        assertEquals(quantity, cart.getQuantity(), "Quantity should be set to " + quantity);
    }

    @Test
    public void testSetQuantityZero() {
        int quantity = 0;
        cart.setQuantity(quantity);
        assertEquals(quantity, cart.getQuantity(), "Quantity should be set to " + quantity);
    }

    @Test
    public void testSetQuantityNegative() {
        int quantity = -5;
        cart.setQuantity(quantity);
        assertEquals(quantity, cart.getQuantity(), "Quantity should be set to " + quantity);
    }
}
