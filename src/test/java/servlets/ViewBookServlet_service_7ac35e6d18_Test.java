package servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ViewBookServlet_service_7ac35e6d18_Test {

    private ViewBookServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        servlet = new ViewBookServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        bookService = mock(BookService.class);
        servlet.setBookService(bookService);
    }

    @Test
    public void testService_WhenUserNotLoggedIn() throws ServletException, IOException {
        when(StoreUtil.isLoggedIn(UserRole.CUSTOMER, request.getSession())).thenReturn(false);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("CustomerLogin.html")).thenReturn(dispatcher);

        servlet.service(request, response);

        verify(dispatcher).include(request, response);
        assertEquals("text/html", response.getContentType());
        assertTrue(response.getContentAsString().contains("Please Login First to Continue!!"));
    }

    @Test
    public void testService_WhenUserLoggedIn() throws ServletException, IOException {
        when(StoreUtil.isLoggedIn(UserRole.CUSTOMER, request.getSession())).thenReturn(true);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(dispatcher);
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookService.getAllBooks()).thenReturn(books);

        servlet.service(request, response);

        verify(dispatcher).include(request, response);
        assertEquals("text/html", response.getContentType());
        assertTrue(response.getContentAsString().contains("Available Books"));
        assertTrue(response.getContentAsString().contains("Proceed to Checkout"));
    }
}
