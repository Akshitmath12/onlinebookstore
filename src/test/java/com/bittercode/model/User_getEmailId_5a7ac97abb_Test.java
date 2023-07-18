package com.bittercode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class User_getEmailId_5a7ac97abb_Test {

    private User user;

    @Before
    public void setUp() {
        user = Mockito.mock(User.class);
    }

    @Test
    public void testGetEmailIdSuccess() {
        String expectedEmail = "test@example.com";
        Mockito.when(user.getEmailId()).thenReturn(expectedEmail);
        String actualEmail = user.getEmailId();
        Assert.assertEquals("Email should match the expected value", expectedEmail, actualEmail);
    }

    @Test
    public void testGetEmailIdFailure() {
        String unexpectedEmail = "wrong@example.com";
        Mockito.when(user.getEmailId()).thenReturn("test@example.com");
        String actualEmail = user.getEmailId();
        Assert.assertNotEquals("Email should not match the unexpected value", unexpectedEmail, actualEmail);
    }
}
