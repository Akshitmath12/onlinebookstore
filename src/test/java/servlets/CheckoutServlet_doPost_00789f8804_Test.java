package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bittercode.constant.BookStoreConstants;
import com.bittercode.model.UserRole;
import com.bittercode.util.StoreUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class CheckoutServlet_doPost_00789f8804_Test {

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
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoPost_NotLoggedIn() throws IOException, ServletException {
        when(session.getAttribute("userRole")).thenReturn(UserRole.GUEST);
        when(request.getRequestDispatcher("CustomerLogin.html")).thenReturn(dispatcher);

        new CheckoutServlet().doPost(request, response);

        verify(dispatcher).include(request, response);
        verify(writer).println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
    }

    @Test
    public void testDoPost_LoggedIn() throws IOException, ServletException {
        when(session.getAttribute("userRole")).thenReturn(UserRole.CUSTOMER);
        when(request.getRequestDispatcher("payment.html")).thenReturn(dispatcher);
        when(session.getAttribute("amountToPay")).thenReturn(100.0);

        new CheckoutServlet().doPost(request, response);

        verify(dispatcher).include(request, response);
        verify(writer).println("Total Amount<span class=\"price\" style=\"color: black\"><b>&#8377; " + 100.0 + "</b></span>");
        verify(writer).println("<input type=\"submit\" value=\"Pay & Place Order\" class=\"btn\">" + "</form>");
    }
}
