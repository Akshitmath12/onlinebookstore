package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Book_setAuthor_265b2849fd_Test {
  
    @InjectMocks
    private Book book;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAuthor() {
        String expectedAuthor = "John Doe";
        book.setAuthor(expectedAuthor);
        assertEquals(expectedAuthor, book.getAuthor(), "The author should be set correctly");
    }

    @Test
    public void testSetAuthorWithNull() {
        // TODO: Change the value of expectedAuthor to the default value when author is null
        String expectedAuthor = ""; 
        book.setAuthor(null);
        assertEquals(expectedAuthor, book.getAuthor(), "The author should be set to default when null is provided");
    }
}
