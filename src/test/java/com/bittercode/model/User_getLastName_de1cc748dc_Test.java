package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_getLastName_de1cc748dc_Test {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetLastNameWhenLastNameIsSet() {
        String expectedLastName = "Smith";
        user.setLastName(expectedLastName);

        String actualLastName = user.getLastName();

        assertEquals(expectedLastName, actualLastName, "The last name should be Smith");
    }

    @Test
    public void testGetLastNameWhenLastNameIsNotSet() {
        String expectedLastName = null;

        String actualLastName = user.getLastName();

        assertEquals(expectedLastName, actualLastName, "The last name should be null as it is not set");
    }
}
