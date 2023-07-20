// Test generated by RoostGPT for test onlineBookStore using AI Type Open AI and AI Model gpt-4

package com.bittercode.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bittercode.constant.ResponseCode;
import com.bittercode.model.StoreException;
import com.bittercode.util.DBUtil;

public class BookServiceImpl_deleteBookById_bdaaa3ffdb_Test {

    @InjectMocks
    BookServiceImpl bookService;
    
    @Mock
    DBUtil dbUtil;
    
    @Mock
    Connection con;
    
    @Mock
    PreparedStatement ps;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testDeleteBookById_Success() throws SQLException, StoreException {
        when(dbUtil.getConnection()).thenReturn(con);
        when(con.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeUpdate()).thenReturn(1);
        
        String response = bookService.deleteBookById("1");
        assertEquals(ResponseCode.SUCCESS.name(), response);
    }
    
    @Test
    public void testDeleteBookById_Failure() throws SQLException, StoreException {
        when(dbUtil.getConnection()).thenReturn(con);
        when(con.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeUpdate()).thenReturn(0);
        
        String response = bookService.deleteBookById("1");
        assertEquals(ResponseCode.FAILURE.name(), response);
    }
    
    @Test(expected = StoreException.class)
    public void testDeleteBookById_Exception() throws SQLException, StoreException {
        when(dbUtil.getConnection()).thenThrow(SQLException.class);
        
        bookService.deleteBookById("1");
    }
}
