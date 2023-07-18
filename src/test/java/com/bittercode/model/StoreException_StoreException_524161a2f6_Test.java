package com.bittercode.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class StoreException_StoreException_524161a2f6_Test {

    private StoreException storeException;

    @Before
    public void setUp() {
        storeException = new StoreException();
        storeException.setMessage("Test error message");
        storeException.setErrorCode("BAD_REQUEST");
        storeException.setStatusCode(400);
    }

    @Test
    public void testStoreExceptionErrorMessage() {
        assertEquals("Test error message", storeException.getMessage());
    }

    @Test
    public void testStoreExceptionErrorCode() {
        assertEquals("BAD_REQUEST", storeException.getErrorCode());
    }

    @Test
    public void testStoreExceptionStatusCode() {
        assertEquals(400, storeException.getStatusCode());
    }

    @Test
    public void testStoreExceptionNotNull() {
        assertNotNull(storeException);
    }
}
