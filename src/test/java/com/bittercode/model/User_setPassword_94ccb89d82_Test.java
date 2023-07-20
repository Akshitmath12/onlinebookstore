package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_setPassword_94ccb89d82_Test {

    @InjectMocks
    private User user;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetPassword_Success() {
        String expectedPassword = "TestPassword123";
        user.setPassword(expectedPassword);
        assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    public void testSetPassword_Null() {
        String expectedPassword = null;
        user.setPassword(expectedPassword);
        assertEquals(expectedPassword, user.getPassword());
    }
}
