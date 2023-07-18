import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BookServletTest {

    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
    BookService bookService = Mockito.mock(BookService.class);
    AddBookServlet addBookServlet = new AddBookServlet();

    @Test
    public void testServiceWithEmptyBookName() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(BookStoreConstants.KEY_USER_ROLE)).thenReturn("SELLER");
        when(request.getParameter(BooksDBConstants.COLUMN_NAME)).thenReturn("");
        when(request.getParameter(BooksDBConstants.COLUMN_AUTHOR)).thenReturn("AuthorName");
        when(request.getParameter(BooksDBConstants.COLUMN_PRICE)).thenReturn("100");
        when(request.getParameter(BooksDBConstants.COLUMN_QUANTITY)).thenReturn("10");
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        addBookServlet.service(request, response);

        assertTrue(stringWriter.toString().contains("Add More Books"));
    }

    @Test
    public void testServiceWithException() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(BookStoreConstants.KEY_USER_ROLE)).thenReturn("SELLER");
        when(request.getParameter(BooksDBConstants.COLUMN_NAME)).thenReturn("BookName");
        when(request.getParameter(BooksDBConstants.COLUMN_AUTHOR)).thenReturn("AuthorName");
        when(request.getParameter(BooksDBConstants.COLUMN_PRICE)).thenReturn("100");
        when(request.getParameter(BooksDBConstants.COLUMN_QUANTITY)).thenReturn("10");
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        when(bookService.addBook(any(Book.class))).thenThrow(new RuntimeException("Test Exception"));

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        addBookServlet.service(request, response);

        assertTrue(stringWriter.toString().contains("Failed to Add Books! Fill up CareFully"));
    }
}
