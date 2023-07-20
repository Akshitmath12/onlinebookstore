package com.bittercode.constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseCode_getCode_a7033c7442_Test {

    @Test
    public void testGetCodeSuccess() {
        ResponseCode responseCode = ResponseCode.SUCCESS; // Assuming SUCCESS is an enum constant
        int expected = 200; // Assuming the code for SUCCESS is 200
        int actual = responseCode.getCode();
        assertEquals(expected, actual, "The expected code should match the actual code");
    }

    @Test
    public void testGetCodeFailure() {
        ResponseCode responseCode = ResponseCode.FAILURE; // Assuming FAILURE is an enum constant
        int expected = 500; // Assuming the code for FAILURE is 500
        int actual = responseCode.getCode();
        assertEquals(expected, actual, "The expected code should match the actual code");
    }
}
