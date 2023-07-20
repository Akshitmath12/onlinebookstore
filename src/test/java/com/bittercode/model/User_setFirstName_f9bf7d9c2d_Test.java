package com.bittercode.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class User_setFirstName_f9bf7d9c2d_Test {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
    }

    @Test
    public void testSetFirstName() {
        String firstName = "John";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testSetFirstName_NullValue() {
        String firstName = null;
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }
}
