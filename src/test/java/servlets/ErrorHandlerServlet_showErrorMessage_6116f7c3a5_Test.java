package servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlerServlet_showErrorMessage_6116f7c3a5_Test {

    @Mock
    private ErrorHandlerServlet errorHandlerServlet;

    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
    }

    @Test
    public void testShowErrorMessage_Success() {
        String errorCode = "200";
        String errorMessage = "Success";
        String expectedOutput = "<div class='container my-5'><div class=\"alert alert-success\" role=\"alert\" style='max-width:450px; text-align:center; margin:auto;'>\r\n"
                + "  <h4 class=\"alert-heading\">"
                + errorCode
                + "</h4>\r\n"
                + "  <hr>\r\n"
                + "  <p class=\"mb-0\">"
                + errorMessage
                + "</p>\r\n"
                + "</div>"
                + "</div>";
        errorHandlerServlet.showErrorMessage(printWriter, errorCode, errorMessage);
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @Test
    public void testShowErrorMessage_Failure() {
        String errorCode = "404";
        String errorMessage = "Page not found";
        String expectedOutput = "<div class='container my-5'><div class=\"alert alert-danger\" role=\"alert\" style='max-width:450px; text-align:center; margin:auto;'>\r\n"
                + "  <h4 class=\"alert-heading\">"
                + errorCode
                + "</h4>\r\n"
                + "  <hr>\r\n"
                + "  <p class=\"mb-0\">"
                + errorMessage
                + "</p>\r\n"
                + "</div>"
                + "</div>";
        errorHandlerServlet.showErrorMessage(printWriter, errorCode, errorMessage);
        assertEquals(expectedOutput, stringWriter.toString());
    }
}
