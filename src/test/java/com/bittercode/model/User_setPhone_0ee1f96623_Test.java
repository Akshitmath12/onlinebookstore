package com.bittercode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_setPhone_0ee1f96623_Test {

    private User user;

    @BeforeEach
    public void setUp() {
        user = Mockito.mock(User.class);
    }

    @Test
    public void testSetPhoneSuccess() {
        Long phone = 1234567890L;
        Mockito.doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            assertEquals(phone, arg0);
            return null;
        }).when(user).setPhone(Mockito.anyLong());

        user.setPhone(phone);
    }

    @Test
    public void testSetPhoneNull() {
        Long phone = null;
        Mockito.doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            assertEquals(phone, arg0);
            return null;
        }).when(user).setPhone(Mockito.anyLong());

        user.setPhone(phone);
    }
}
