package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_setLastName_815ee71c38_Test {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
    }

    @Test
    public void testSetLastName() {
        String lastName = "Smith";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName(), "The last name should be set correctly");
    }

    @Test
    public void testSetLastNameWithEmptyString() {
        String lastName = "";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName(), "The last name should be set correctly even if it is an empty string");
    }

    @Test
    public void testSetLastNameWithNull() {
        String lastName = null;
        // TODO: Change the value of lastName if needed
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName(), "The last name should be set correctly even if it is null");
    }
}
