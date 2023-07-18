package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class AboutServlet_service_7ac35e6d18_Test {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    PrintWriter writer;

    @Mock
    RequestDispatcher dispatcher;

    @Mock
    HttpSession session;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testService_CustomerRole() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(writer);
        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(dispatcher);
        when(session.getAttribute("role")).thenReturn("CUSTOMER");

        new AboutServlet().service(request, response);

        verify(dispatcher).include(request, response);
        verify(writer).println(anyString());
    }

    @Test
    public void testService_SellerRole() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(writer);
        when(request.getRequestDispatcher("SellerHome.html")).thenReturn(dispatcher);
        when(session.getAttribute("role")).thenReturn("SELLER");

        new AboutServlet().service(request, response);

        verify(dispatcher).include(request, response);
        verify(writer).println(anyString());
    }

    @Test
    public void testService_NotLoggedIn() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(writer);
        when(request.getRequestDispatcher("login.html")).thenReturn(dispatcher);
        when(session.getAttribute("role")).thenReturn(null);

        new AboutServlet().service(request, response);

        verify(dispatcher).include(request, response);
        verify(writer).println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
    }
}
