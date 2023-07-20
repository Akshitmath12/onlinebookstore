package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class User_getAddress_a51bc89946_Test {

    @InjectMocks
    User user = new User();

    @Mock
    AddressService addressService = new AddressService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAddress_Success() {
        String expectedAddress = "123 Main St";
        when(addressService.getAddress()).thenReturn(expectedAddress);

        String actualAddress = user.getAddress();
        assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testGetAddress_Failure() {
        String expectedAddress = null;
        when(addressService.getAddress()).thenReturn(expectedAddress);

        String actualAddress = user.getAddress();
        assertEquals(expectedAddress, actualAddress);
    }
}
