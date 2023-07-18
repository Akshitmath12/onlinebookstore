package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StoreExceptionTest {

    private StoreException storeException;

    @BeforeEach
    public void setUp() {
        storeException = new StoreException();
        storeException.setErrorCode(ResponseCode.ERROR);
        storeException.setErrorMessage("An error occurred");
        storeException.setStatusCode(422);
    }

    @Test
    public void testStoreExceptionErrorCode() {
        assertEquals(ResponseCode.ERROR, storeException.getErrorCode());
    }

    @Test
    public void testStoreExceptionErrorMessage() {
        assertEquals("An error occurred", storeException.getErrorMessage());
    }

    @Test
    public void testStoreExceptionStatusCode() {
        assertEquals(422, storeException.getStatusCode());
    }
}
