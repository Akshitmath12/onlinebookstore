package com.bittercode.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class User_retrieveFromHttpServletRequest_721d3af333_Test {

    @InjectMocks
    MockHttpServletRequest request;

    @Mock
    User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveFromHttpServletRequestSuccess() {
        when(request.getParameter("password")).thenReturn("12345");
        when(request.getParameter("firstName")).thenReturn("John");
        when(request.getParameter("lastName")).thenReturn("Doe");
        when(request.getParameter("address")).thenReturn("123 Street");
        when(request.getParameter("phone")).thenReturn("1234567890");
        when(request.getParameter("mailId")).thenReturn("john.doe@example.com");

        User user = User.retrieveFromHttpServletRequest(request);

        assertEquals("12345", user.getPassword());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("123 Street", user.getAddress());
        assertEquals(Long.valueOf("1234567890"), user.getPhone());
        assertEquals("john.doe@example.com", user.getEmailId());
    }

    @Test(expected = NumberFormatException.class)
    public void testRetrieveFromHttpServletRequestFailure() {
        when(request.getParameter("phone")).thenReturn("not a number");

        User user = User.retrieveFromHttpServletRequest(request);
    }
}
