package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class User_getFirstName_0d799bf2a4_Test {

    private User user;

    @BeforeEach
    public void setUp() {
        user = Mockito.mock(User.class);
        Mockito.when(user.getFirstName()).thenReturn("John");
    }

    @Test
    public void testGetFirstNameSuccess() {
        String firstName = user.getFirstName();
        Assertions.assertEquals("John", firstName);
    }

    @Test
    public void testGetFirstNameFailure() {
        Mockito.when(user.getFirstName()).thenReturn(null);
        String firstName = user.getFirstName();
        Assertions.assertNull(firstName);
    }
}
