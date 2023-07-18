package servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CartServlet_service_7ac35e6d18_Test {

    @Mock
    private BookService bookService;

    @Mock
    private RequestDispatcher requestDispatcher;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private MockHttpSession session;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
    }

    @Test
    public void testService_WhenCustomerIsNotLoggedIn() throws IOException, ServletException {
        request.setSession(session);
        when(request.getRequestDispatcher("CustomerLogin.html")).thenReturn(requestDispatcher);

        new CartServlet().service(request, response);

        verify(requestDispatcher, times(1)).include(request, response);
    }

    @Test
    public void testService_WhenCustomerIsLoggedInAndCartIsEmpty() throws IOException, ServletException {
        request.setSession(session);
        session.setAttribute("role", UserRole.CUSTOMER);
        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(requestDispatcher);
        when(bookService.getBooksByCommaSeperatedBookIds(anyString())).thenReturn(null);

        new CartServlet().service(request, response);

        verify(requestDispatcher, times(1)).include(request, response);
    }

    @Test
    public void testService_WhenCustomerIsLoggedInAndCartIsNotEmpty() throws IOException, ServletException {
        request.setSession(session);
        session.setAttribute("role", UserRole.CUSTOMER);
        session.setAttribute("items", "1,2");
        session.setAttribute("qty_1", 1);
        session.setAttribute("qty_2", 2);

        Book book1 = new Book();
        book1.setBarcode("1");
        book1.setPrice(100);

        Book book2 = new Book();
        book2.setBarcode("2");
        book2.setPrice(200);

        List<Book> books = Arrays.asList(book1, book2);

        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(requestDispatcher);
        when(bookService.getBooksByCommaSeperatedBookIds(anyString())).thenReturn(books);

        new CartServlet().service(request, response);

        verify(requestDispatcher, times(1)).include(request, response);
    }
}
