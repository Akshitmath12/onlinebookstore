package com.bittercode.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.bittercode.constant.ResponseCode;

public class StoreException_getErrorCode_043a99c432_Test {

    @Mock
    private StoreException storeException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetErrorCode_Success() {
        String expectedErrorCode = ResponseCode.SUCCESS.getCode();
        Mockito.when(storeException.getErrorCode()).thenReturn(expectedErrorCode);
        String actualErrorCode = storeException.getErrorCode();
        assertEquals(expectedErrorCode, actualErrorCode, "Error codes should match");
    }

    @Test
    public void testGetErrorCode_Failure() {
        String expectedErrorCode = ResponseCode.FAILURE.getCode();
        Mockito.when(storeException.getErrorCode()).thenReturn(expectedErrorCode);
        String actualErrorCode = storeException.getErrorCode();
        assertEquals(expectedErrorCode, actualErrorCode, "Error codes should match");
    }
}
