package com.bittercode.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class User_getPhone_fffa7360d6_Test {

    @Mock
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPhoneSuccess() {
        Long expectedPhone = 1234567890L;
        when(user.getPhone()).thenReturn(expectedPhone);
        Long actualPhone = user.getPhone();
        assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void testGetPhoneFailure() {
        Long unexpectedPhone = 1234567890L;
        when(user.getPhone()).thenReturn(null);
        Long actualPhone = user.getPhone();
        assertEquals(unexpectedPhone, actualPhone, "Phone number should be null");
    }
}
