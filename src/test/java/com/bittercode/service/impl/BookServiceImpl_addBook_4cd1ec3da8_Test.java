package com.bittercode.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bittercode.constant.ResponseCode;
import com.bittercode.constant.db.BooksDBConstants;
import com.bittercode.model.Book;
import com.bittercode.model.StoreException;
import com.bittercode.service.BookService;
import com.bittercode.util.DBUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceImpl_addBook_4cd1ec3da8_Test {

    @Mock
    private Connection con;
    
    @Mock
    private PreparedStatement ps;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBookSuccess() throws SQLException, StoreException {
        Book book = new Book();
        book.setISBN("123456");
        book.setName("Test Book");
        book.setAuthor("Test Author");
        book.setPrice(10.0);
        book.setQuantity(5);
        when(con.prepareStatement(BooksDBConstants.ADD_BOOK_QUERY)).thenReturn(ps);
        when(ps.executeUpdate()).thenReturn(1);
        BookService bookService = new BookServiceImpl();
        String response = bookService.addBook(book);
        assertEquals(ResponseCode.SUCCESS.name(), response);
    }

    @Test
    public void testAddBookFailure() throws SQLException, StoreException {
        Book book = new Book();
        book.setISBN("123456");
        book.setName("Test Book");
        book.setAuthor("Test Author");
        book.setPrice(10.0);
        book.setQuantity(5);
        when(con.prepareStatement(BooksDBConstants.ADD_BOOK_QUERY)).thenReturn(ps);
        when(ps.executeUpdate()).thenReturn(0);
        BookService bookService = new BookServiceImpl();
        String response = bookService.addBook(book);
        assertEquals(ResponseCode.FAILURE.name(), response);
    }
}
