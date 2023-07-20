package com.bittercode.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bittercode.constant.ResponseCode;
import com.bittercode.model.Book;
import com.bittercode.util.DBUtil;

public class BookServiceImpl_updateBook_66db75c6be_Test {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        bookService = new BookServiceImpl();
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(DBUtil.getConnection()).thenReturn(connection);
    }

    @Test
    public void testUpdateBookSuccess() throws Exception {
        Book book = new Book();
        when(preparedStatement.executeUpdate()).thenReturn(1);
        String response = bookService.updateBook(book);
        assertEquals(ResponseCode.SUCCESS.name(), response);
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testUpdateBookFailure() throws Exception {
        Book book = new Book();
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException("Update failed"));
        String response = bookService.updateBook(book);
        assertEquals(ResponseCode.FAILURE.name() + " : Update failed", response);
        verify(preparedStatement, times(1)).executeUpdate();
    }
}
