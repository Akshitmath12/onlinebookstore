package com.bittercode.util;

import java.sql.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.bittercode.constant.ResponseCode;
import com.bittercode.model.StoreException;

@ExtendWith(MockitoExtension.class)
public class DBUtil_getConnection_116bcaf562_Test {

    @InjectMocks
    private DBUtil dbUtil;

    @Mock
    private Connection connection;

    @BeforeEach
    public void setup() {
        dbUtil = new DBUtil();
    }

    @Test
    public void testGetConnection_Success() throws StoreException {
        when(dbUtil.getConnection()).thenReturn(connection);
        Connection result = dbUtil.getConnection();
        assertNotNull(result, "Connection should not be null");
    }

    @Test
    public void testGetConnection_Failure() {
        when(dbUtil.getConnection()).thenThrow(new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE));
        assertThrows(StoreException.class, () -> dbUtil.getConnection(), "StoreException expected");
    }
}
