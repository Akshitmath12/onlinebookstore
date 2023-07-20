package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;

public class RemoveBookServlet_service_7ac35e6d18_Test {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private PrintWriter writer;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testService_ExceptionThrown() throws IOException, ServletException {
        when(request.getSession()).thenReturn(mock(HttpSession.class));
        when(request.getParameter("bookId")).thenReturn("123");
        doThrow(new RuntimeException()).when(bookService).deleteBookById("123");
        new RemoveBookServlet().service(request, response);
        verify(response.getWriter(), times(1)).println("<table class=\"tab\"><tr><td>Failed to Remove Books! Try Again</td></tr></table>");
    }

    @Test
    public void testService_WhenBookIsRemovedSuccessfully() throws IOException, ServletException {
        when(request.getSession()).thenReturn(mock(HttpSession.class));
        when(request.getParameter("bookId")).thenReturn("123");
        new RemoveBookServlet().service(request, response);
        verify(response.getWriter(), times(1)).println("<table class=\"tab my-5\"><tr><td>Book Removed Successfully</td></tr></table>");
        verify(response.getWriter(), times(1)).println("<table class=\"tab\"><tr><td><a href=\"removebook\">Remove more Books</a></td></tr></table>");
    }

    @Test
    public void testService_WhenBookIsNotAvailable() throws IOException, ServletException {
        when(request.getSession()).thenReturn(mock(HttpSession.class));
        when(request.getParameter("bookId")).thenReturn("123");
        new RemoveBookServlet().service(request, response);
        verify(response.getWriter(), times(1)).println("<table class=\"tab my-5\"><tr><td>Book Not Available In The Store</td></tr></table>");
        verify(response.getWriter(), times(1)).println("<table class=\"tab\"><tr><td><a href=\"removebook\">Remove more Books</a></td></tr></table>");
    }
}
