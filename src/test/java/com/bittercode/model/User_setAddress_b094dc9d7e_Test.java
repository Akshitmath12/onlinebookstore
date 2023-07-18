// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_setAddress_b094dc9d7e_Test {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main St";
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    public void testSetAddress_EmptyString() {
        String address = "";
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    public void testSetAddress_Null() {
        String address = null;
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }
}
