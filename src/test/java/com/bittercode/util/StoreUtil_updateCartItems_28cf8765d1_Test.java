package com.bittercode.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreUtil_updateCartItems_28cf8765d1_Test {

    HttpServletRequest request;
    HttpSession session;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testUpdateCartItems_addToCart() {
        when(request.getParameter("selectedBookId")).thenReturn("book1");
        when(request.getParameter("addToCart")).thenReturn("true");

        StoreUtil.updateCartItems(request);
        
        verify(session).setAttribute("items", "book1");
        verify(session).setAttribute("qty_book1", 1);
    }

    @Test
    public void testUpdateCartItems_removeFromCart() {
        when(request.getParameter("selectedBookId")).thenReturn("book1");
        when(request.getParameter("addToCart")).thenReturn(null);
        when(session.getAttribute("qty_book1")).thenReturn(1);

        StoreUtil.updateCartItems(request);

        verify(session).removeAttribute("qty_book1");
    }
}
