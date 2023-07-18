package servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SellerLoginServlet_doPost_00789f8804_Test {

    @Mock
    UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoPost_SuccessfulLogin() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        RequestDispatcher rd = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("SellerHome.html")).thenReturn(rd);
        when(request.getParameter(UsersDBConstants.COLUMN_USERNAME)).thenReturn("testUser");
        when(request.getParameter(UsersDBConstants.COLUMN_PASSWORD)).thenReturn("testPassword");

        User mockUser = new User();
        mockUser.setFirstName("Test");

        when(userService.login(UserRole.SELLER, "testUser", "testPassword", request.getSession()))
                .thenReturn(mockUser);

        new SellerLoginServlet().doPost(request, response);

        assertEquals(BookStoreConstants.CONTENT_TYPE_TEXT_HTML, response.getContentType());
    }

    @Test
    public void testDoPost_UnsuccessfulLogin() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        RequestDispatcher rd = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("SellerLogin.html")).thenReturn(rd);
        when(request.getParameter(UsersDBConstants.COLUMN_USERNAME)).thenReturn("testUser");
        when(request.getParameter(UsersDBConstants.COLUMN_PASSWORD)).thenReturn("testPassword");

        when(userService.login(UserRole.SELLER, "testUser", "testPassword", request.getSession()))
                .thenReturn(null);

        new SellerLoginServlet().doPost(request, response);

        assertEquals(BookStoreConstants.CONTENT_TYPE_TEXT_HTML, response.getContentType());
    }
}
