package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bittercode.constant.BookStoreConstants;
import com.bittercode.model.Book;
import com.bittercode.model.UserRole;
import com.bittercode.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class BuyBooksServlet_doPost_00789f8804_Test {

    @InjectMocks
    BuyBooksServlet buyBooksServlet;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    PrintWriter printWriter;

    @Mock
    RequestDispatcher requestDispatcher;

    @Mock
    BookService bookService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoPost_NotLoggedIn() throws IOException, ServletException {
        when(request.getSession()).thenReturn(null);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getRequestDispatcher("CustomerLogin.html")).thenReturn(requestDispatcher);

        buyBooksServlet.doPost(request, response);

        verify(response).setContentType(BookStoreConstants.CONTENT_TYPE_TEXT_HTML);
        verify(requestDispatcher).include(request, response);
        verify(printWriter).println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
    }

    @Test
    public void testDoPost_LoggedIn() throws IOException, ServletException {
        when(request.getSession()).thenReturn(mock(HttpSession.class));
        when(request.getSession().getAttribute("role")).thenReturn(UserRole.CUSTOMER);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(requestDispatcher);
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(new Book()));

        buyBooksServlet.doPost(request, response);

        verify(response).setContentType(BookStoreConstants.CONTENT_TYPE_TEXT_HTML);
        verify(requestDispatcher).include(request, response);
        verify(printWriter, times(2)).println(anyString());
    }
}
