package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import com.bittercode.model.Book;
import com.bittercode.model.UserRole;
import com.bittercode.service.BookService;
import com.bittercode.util.StoreUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StoreBookServlet_service_7ac35e6d18_Test {

    @InjectMocks
    StoreBookServlet storeBookServlet;

    @Mock
    BookService bookService;

    @Mock
    StoreUtil storeUtil;

    @Test
    public void testService_LoggedInAsSeller() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        when(storeUtil.isLoggedIn(UserRole.SELLER, request.getSession())).thenReturn(true);
        when(bookService.getAllBooks()).thenReturn(List.of(new Book()));

        storeBookServlet.service(request, response);

        verify(storeUtil, times(1)).setActiveTab(any(), eq("storebooks"));
        assertEquals("text/html", response.getContentType());
    }

    @Test
    public void testService_NotLoggedIn() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        when(storeUtil.isLoggedIn(UserRole.SELLER, request.getSession())).thenReturn(false);

        storeBookServlet.service(request, response);

        assertEquals("text/html", response.getContentType());
        assertTrue(response.getContentAsString().contains("Please Login First to Continue!!"));
    }

    @Test
    public void testService_NoBooksAvailable() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        when(storeUtil.isLoggedIn(UserRole.SELLER, request.getSession())).thenReturn(true);
        when(bookService.getAllBooks()).thenReturn(List.of());

        storeBookServlet.service(request, response);

        assertEquals("text/html", response.getContentType());
        assertTrue(response.getContentAsString().contains("No Books Available in the store"));
    }
}
