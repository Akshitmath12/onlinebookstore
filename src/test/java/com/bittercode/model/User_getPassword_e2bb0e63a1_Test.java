package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_getPassword_e2bb0e63a1_Test {

    @InjectMocks
    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPasswordSuccess() {
        String expectedPassword = "password123";
        user.setPassword(expectedPassword);

        String actualPassword = user.getPassword();

        assertEquals(expectedPassword, actualPassword, "Password should match the set value");
    }

    @Test
    public void testGetPasswordFailure() {
        String expectedPassword = "password123";
        user.setPassword("differentPassword");

        String actualPassword = user.getPassword();

        assertEquals(expectedPassword, actualPassword, "Password should not match the set value");
    }
}
