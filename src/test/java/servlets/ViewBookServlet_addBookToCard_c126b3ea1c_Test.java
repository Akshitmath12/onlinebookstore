package servlets;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import com.bittercode.model.Book;

import static org.junit.jupiter.api.Assertions.*;

public class ViewBookServlet_addBookToCard_c126b3ea1c_Test {

    @Test
    public void testAddBookToCard_BookAvailable() {
        ViewBookServlet servlet = new ViewBookServlet();
        MockHttpSession session = new MockHttpSession();
        Book book = new Book();
        book.setBarcode("123");
        book.setQuantity(5);
        String result = servlet.addBookToCard(session, book);
        assertTrue(result.contains("Add To Cart"));
    }

    @Test
    public void testAddBookToCard_BookOutOfStock() {
        ViewBookServlet servlet = new ViewBookServlet();
        MockHttpSession session = new MockHttpSession();
        Book book = new Book();
        book.setBarcode("123");
        book.setQuantity(0);
        String result = servlet.addBookToCard(session, book);
        assertTrue(result.contains("Out Of Stock"));
    }

    @Test
    public void testAddBookToCard_BookInCart() {
        ViewBookServlet servlet = new ViewBookServlet();
        MockHttpSession session = new MockHttpSession();
        Book book = new Book();
        book.setBarcode("123");
        book.setQuantity(5);
        session.setAttribute("qty_123", 1);
        String result = servlet.addBookToCard(session, book);
        assertTrue(result.contains("glyphicon glyphicon-minus btn btn-danger"));
    }

    @Test
    public void testAddBookToCard_BookTrending() {
        ViewBookServlet servlet = new ViewBookServlet();
        MockHttpSession session = new MockHttpSession();
        Book book = new Book();
        book.setBarcode("123");
        book.setQuantity(20);
        String result = servlet.addBookToCard(session, book);
        assertTrue(result.contains("Trending"));
    }
}
