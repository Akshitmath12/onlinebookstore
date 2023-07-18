package servlets;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ErrorHandlerServlet_service_7ac35e6d18_Test {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private HttpSession session;

    @Test
    public void serviceTest_CustomerRole() throws Exception {
        MockitoAnnotations.openMocks(this);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getAttribute("javax.servlet.error.status_code")).thenReturn(404);
        when(request.getAttribute("javax.servlet.error.exception")).thenReturn(null);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(requestDispatcher);
        when(session.getAttribute("userRole")).thenReturn(UserRole.CUSTOMER);
        new ErrorHandlerServlet().service(request, response);
        writer.flush();
        assertEquals(true, stringWriter.toString().contains("Not Found"));
    }

    @Test
    public void serviceTest_SellerRole() throws Exception {
        MockitoAnnotations.openMocks(this);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getAttribute("javax.servlet.error.status_code")).thenReturn(500);
        when(request.getAttribute("javax.servlet.error.exception")).thenReturn(new StoreException("Internal Server Error", 500, "INTERNAL_SERVER_ERROR"));
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("SellerHome.html")).thenReturn(requestDispatcher);
        when(session.getAttribute("userRole")).thenReturn(UserRole.SELLER);
        new ErrorHandlerServlet().service(request, response);
        writer.flush();
        assertEquals(true, stringWriter.toString().contains("Internal Server Error"));
    }
}
