// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.constant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseCode_getMessage_3d85e9375f_Test {

    @InjectMocks
    private ResponseCode responseCode;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMessageSuccess() {
        String expectedMessage = "Success";
        responseCode.setMessage(expectedMessage);
        String actualMessage = responseCode.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetMessageFailure() {
        String expectedMessage = "";
        responseCode.setMessage(expectedMessage);
        String actualMessage = responseCode.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
