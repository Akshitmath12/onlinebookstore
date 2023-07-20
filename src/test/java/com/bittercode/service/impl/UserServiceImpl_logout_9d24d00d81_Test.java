// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bittercode.model.UserRole;

public class UserServiceImpl_logout_9d24d00d81_Test {

    @Mock
    private HttpSession session;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogoutSuccess() {
        doNothing().when(session).removeAttribute(UserRole.CUSTOMER.toString());
        doNothing().when(session).removeAttribute(UserRole.SELLER.toString());
        doNothing().when(session).invalidate();

        boolean result = logout(session);
        assertEquals(true, result);

        verify(session).removeAttribute(UserRole.CUSTOMER.toString());
        verify(session).removeAttribute(UserRole.SELLER.toString());
        verify(session).invalidate();
    }

    @Test
    public void testLogoutException() {
        HttpSession session = mock(HttpSession.class);
        when(session.removeAttribute(UserRole.CUSTOMER.toString())).thenThrow(IllegalStateException.class);

        try {
            logout(session);
        } catch (IllegalStateException e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
    }

    public boolean logout(HttpSession session) {
        session.removeAttribute(UserRole.CUSTOMER.toString());
        session.removeAttribute(UserRole.SELLER.toString());
        session.invalidate();
        return true;
    }
}
