package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreException_StoreException_82df32fae4_Test {

    private StoreException storeException;

    @BeforeEach
    public void setUp() {
        storeException = new StoreException();
        storeException.setStatusCode(404);
        storeException.setErrorCode("NOT_FOUND");
        storeException.setErrorMessage("Resource not found");
    }

    @Test
    public void testStoreExceptionStatusCode() {
        assertEquals(404, storeException.getStatusCode());
    }

    @Test
    public void testStoreExceptionErrorCode() {
        assertEquals("NOT_FOUND", storeException.getErrorCode());
    }

    @Test
    public void testStoreExceptionErrorMessage() {
        assertEquals("Resource not found", storeException.getErrorMessage());
    }
}
