package com.bittercode.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

public class BookServiceImpl_getAllBooks_6771521e1d_Test {
    @Mock
    private DBUtil dbUtil;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookServiceImpl();
    }

    @Test
    public void testGetAllBooksSuccess() throws SQLException, StoreException {
        when(dbUtil.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(BooksDBConstants.GET_ALL_BOOKS)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);

        when(resultSet.getString(1)).thenReturn("bCode");
        when(resultSet.getString(2)).thenReturn("bName");
        when(resultSet.getString(3)).thenReturn("bAuthor");
        when(resultSet.getInt(4)).thenReturn(100);
        when(resultSet.getInt(5)).thenReturn(10);

        List<Book> books = bookService.getAllBooks();

        assertEquals(1, books.size());
        assertEquals("bCode", books.get(0).getBookCode());
        assertEquals("bName", books.get(0).getBookName());
        assertEquals("bAuthor", books.get(0).getBookAuthor());
        assertEquals(100, books.get(0).getBookPrice());
        assertEquals(10, books.get(0).getBookQuantity());
    }

    @Test(expected = StoreException.class)
    public void testGetAllBooksFailure() throws SQLException, StoreException {
        when(dbUtil.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(BooksDBConstants.GET_ALL_BOOKS)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenThrow(SQLException.class);

        bookService.getAllBooks();
    }
}
