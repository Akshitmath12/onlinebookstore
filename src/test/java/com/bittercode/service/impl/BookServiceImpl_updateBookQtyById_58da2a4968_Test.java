package com.bittercode.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bittercode.constant.ResponseCode;
import com.bittercode.model.StoreException;
import com.bittercode.util.DBUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceImpl_updateBookQtyById_58da2a4968_Test {

    @Mock
    private Connection con;

    @Mock
    private PreparedStatement ps;

    private BookServiceImpl bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookServiceImpl();
    }

    @Test
    public void testUpdateBookQtyById_success() throws SQLException, StoreException {
        String bookId = "123";
        int quantity = 10;

        when(DBUtil.getConnection()).thenReturn(con);
        when(con.prepareStatement(Mockito.anyString())).thenReturn(ps);

        String result = bookService.updateBookQtyById(bookId, quantity);

        assertEquals(ResponseCode.SUCCESS.name(), result);
    }

    @Test
    public void testUpdateBookQtyById_failure() throws SQLException, StoreException {
        String bookId = "123";
        int quantity = 10;

        when(DBUtil.getConnection()).thenReturn(con);
        when(con.prepareStatement(Mockito.anyString())).thenThrow(SQLException.class);

        String result = bookService.updateBookQtyById(bookId, quantity);

        assertEquals(ResponseCode.FAILURE.name(), result);
    }
}
