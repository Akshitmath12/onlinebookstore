package com.bittercode.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class StoreException_getStatusCode_54b1f92322_Test {

    @InjectMocks
    private StoreException storeException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        storeException = new StoreException();
    }

    @Test
    public void testGetStatusCode_Success() {
        int expectedStatusCode = 200;
        storeException.setStatusCode(expectedStatusCode);
        int actualStatusCode = storeException.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "Expected and actual status codes do not match");
    }

    @Test
    public void testGetStatusCode_Failure() {
        int unexpectedStatusCode = 404;
        storeException.setStatusCode(200);
        int actualStatusCode = storeException.getStatusCode();
        assertEquals(false, unexpectedStatusCode == actualStatusCode, "Unexpected status code was found");
    }
}
