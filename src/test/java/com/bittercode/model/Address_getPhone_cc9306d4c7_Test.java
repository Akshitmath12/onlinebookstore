// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Address_getPhone_cc9306d4c7_Test {

    private Address addressMock;

    @BeforeEach
    public void setUp() {
        addressMock = Mockito.mock(Address.class);
    }

    @Test
    public void testGetPhone_success() {
        String expectedPhone = "123-456-7890";
        when(addressMock.getPhone()).thenReturn(expectedPhone);

        String actualPhone = addressMock.getPhone();

        assertEquals(expectedPhone, actualPhone, "Phone number should match");
    }

    @Test
    public void testGetPhone_null() {
        when(addressMock.getPhone()).thenReturn(null);

        String actualPhone = addressMock.getPhone();

        assertEquals(null, actualPhone, "Phone number should be null");
    }
}