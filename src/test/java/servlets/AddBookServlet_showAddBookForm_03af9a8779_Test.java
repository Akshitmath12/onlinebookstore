package servlets;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddBookServlet_showAddBookForm_03af9a8779_Test {

    @MockBean
    private PrintWriter printWriter;

    @Test
    public void testShowAddBookForm_Success() {
        StringWriter stringWriter = new StringWriter();
        Mockito.when(printWriter.append(Mockito.anyString())).thenReturn(new PrintWriter(stringWriter));

        AddBookServlet.showAddBookForm(printWriter);

        String formOutput = stringWriter.toString();
        assertTrue(formOutput.contains("<table class=\"tab my-5\" style=\"width:40%;\">"));
        assertTrue(formOutput.contains("<form action=\"addbook\" method=\"post\">"));
        assertTrue(formOutput.contains("<input class=\"btn btn-success my-2\" type=\"submit\" value=\" Add Book \">"));
    }

    @Test
    public void testShowAddBookForm_Failure() {
        StringWriter stringWriter = new StringWriter();
        Mockito.when(printWriter.append(Mockito.anyString())).thenReturn(new PrintWriter(stringWriter));

        AddBookServlet.showAddBookForm(printWriter);

        String formOutput = stringWriter.toString();
        assertTrue(!formOutput.contains("<form action=\"addbook\" method=\"get\">"));
    }
}
