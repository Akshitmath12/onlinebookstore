// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Address_getAddressLine1_cd15f42596_Test {

    @InjectMocks
    private Address address;

    @Mock
    private Serializable addressLine1;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAddressLine1_Success() {
        String expectedAddressLine1 = "123 Main Street";
        address.setAddressLine1(expectedAddressLine1);
        String actualAddressLine1 = address.getAddressLine1();
        Assertions.assertEquals(expectedAddressLine1, actualAddressLine1, "Address Line 1 does not match");
    }

    @Test
    public void testGetAddressLine1_Null() {
        String expectedAddressLine1 = null;
        address.setAddressLine1(expectedAddressLine1);
        String actualAddressLine1 = address.getAddressLine1();
        Assertions.assertNull(actualAddressLine1, "Address Line 1 should be null");
    }
}