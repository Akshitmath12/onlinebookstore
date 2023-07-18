package servlets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessPaymentServlet_addBookToCard_aa090dc9f0_Test {

    @Test
    public void testAddBookToCard_ValidInput() {
        ProcessPaymentServlet servlet = new ProcessPaymentServlet();
        String result = servlet.addBookToCard("123", "Test Book", "Test Author", 100.0, 1);
        String expected = "<div class=\"card\">\r\n"
                + "                <div class=\"row card-body\">\r\n"
                + "                    <img class=\"col-sm-6\" src=\"logo.png\" alt=\"Card image cap\">\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <h5 class=\"card-title text-success\">Test Book</h5>\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        Author: <span class=\"text-primary\" style=\"font-weight:bold;\"> Test Author"
                + "</span><br>\r\n"
                + "                        </p>\r\n"
                + "                        \r\n"
                + "                    </div>\r\n"
                + "                </div>\r\n"
                + "                <div class=\"row card-body\">\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        <span style='color:blue;'>Order Id: ORD123TM </span>\r\n"
                + "                        <br><span class=\"text-danger\">Item Yet to be Delivered</span>\r\n"
                + "                        </p>\r\n"
                + "                    </div>\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        Amout Paid: <span style=\"font-weight:bold; color:green\"> &#8377; 100.0 </span>\r\n"
                + "                        </p>\r\n"
                + "<a href=\"#\" class=\"btn btn-info\">Order Placed</a>\r\n"
                + "                    </div>\r\n"
                + "                </div>\r\n"
                + "            </div>";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAddBookToCard_EmptyInput() {
        ProcessPaymentServlet servlet = new ProcessPaymentServlet();
        String result = servlet.addBookToCard("", "", "", 0.0, 0);
        String expected = "<div class=\"card\">\r\n"
                + "                <div class=\"row card-body\">\r\n"
                + "                    <img class=\"col-sm-6\" src=\"logo.png\" alt=\"Card image cap\">\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <h5 class=\"card-title text-success\"></h5>\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        Author: <span class=\"text-primary\" style=\"font-weight:bold;\"> "
                + "</span><br>\r\n"
                + "                        </p>\r\n"
                + "                        \r\n"
                + "                    </div>\r\n"
                + "                </div>\r\n"
                + "                <div class=\"row card-body\">\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        <span style='color:blue;'>Order Id: ORDTM </span>\r\n"
                + "                        <br><span class=\"text-danger\">Item Yet to be Delivered</span>\r\n"
                + "                        </p>\r\n"
                + "                    </div>\r\n"
                + "                    <div class=\"col-sm-6\">\r\n"
                + "                        <p class=\"card-text\">\r\n"
                + "                        Amout Paid: <span style=\"font-weight:bold; color:green\"> &#8377; 0.0 </span>\r\n"
                + "                        </p>\r\n"
                + "<a href=\"#\" class=\"btn btn-info\">Order Placed</a>\r\n"
                + "                    </div>\r\n"
                + "                </div>\r\n"
                + "            </div>";
        Assertions.assertEquals(expected, result);
    }
}
