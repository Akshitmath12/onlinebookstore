package com.bittercode.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bittercode.model.UserRole;

public class StoreUtil_isLoggedIn_2d8f8ed1de_Test {

    @Mock
    private HttpSession session;

    private UserRole role;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        role = UserRole.ADMIN; // TODO: Change this value based on the user role you want to test
    }

    @Test
    public void testIsLoggedInSuccess() {
        when(session.getAttribute(role.toString())).thenReturn(new Object());

        boolean result = StoreUtil.isLoggedIn(role, session);

        assertTrue(result, "Expected true when attribute is present in the session");
    }

    @Test
    public void testIsLoggedInFailure() {
        when(session.getAttribute(role.toString())).thenReturn(null);

        boolean result = StoreUtil.isLoggedIn(role, session);

        assertFalse(result, "Expected false when attribute is not present in the session");
    }
}
