package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreException_setErrorMessage_6c20efa15d_Test {

    private StoreException storeException;

    @BeforeEach
    public void setUp() {
        storeException = new StoreException();
    }

    @Test
    public void testSetErrorMessage_Success() {
        String errorMessage = "An error occurred";
        storeException.setErrorMessage(errorMessage);
        assertEquals(errorMessage, storeException.getErrorMessage());
    }

    @Test
    public void testSetErrorMessage_Null() {
        String errorMessage = null;
        storeException.setErrorMessage(errorMessage);
        assertEquals(errorMessage, storeException.getErrorMessage());
    }
}
