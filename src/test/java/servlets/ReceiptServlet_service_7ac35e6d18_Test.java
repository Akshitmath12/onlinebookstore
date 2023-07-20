@Test
public void testService_WhenUserQuantityExceedsBookQuantity() throws IOException, ServletException {
    when(request.getSession()).thenReturn(session);
    when(StoreUtil.isLoggedIn(UserRole.CUSTOMER, session)).thenReturn(true);
    when(response.getWriter()).thenReturn(writer);
    when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(dispatcher);

    Book book = new Book();
    book.setBarcode("123");
    book.setName("Java Programming");
    book.setAuthor("John Doe");
    book.setPrice(100.0);
    book.setQuantity(10);

    when(bookService.getAllBooks()).thenReturn(Arrays.asList(book));
    when(request.getParameter("qty1")).thenReturn("15");
    when(request.getParameter("checked1")).thenReturn("pay");

    new ReceiptServlet_service_7ac35e6d18_Test().service(request, response);

    verify(dispatcher, times(1)).include(request, response);
    verify(writer, times(1)).println("</table><div class=\"tab\" style='color:red;'>Please Select the Qty less than Available Books Quantity</div>");
}

@Test
public void testService_WhenUserQuantityLessThanBookQuantity() throws IOException, ServletException {
    when(request.getSession()).thenReturn(session);
    when(StoreUtil.isLoggedIn(UserRole.CUSTOMER, session)).thenReturn(true);
    when(response.getWriter()).thenReturn(writer);
    when(request.getRequestDispatcher("CustomerHome.html")).thenReturn(dispatcher);

    Book book = new Book();
    book.setBarcode("123");
    book.setName("Java Programming");
    book.setAuthor("John Doe");
    book.setPrice(100.0);
    book.setQuantity(10);

    when(bookService.getAllBooks()).thenReturn(Arrays.asList(book));
    when(request.getParameter("qty1")).thenReturn("5");
    when(request.getParameter("checked1")).thenReturn("pay");

    new ReceiptServlet_service_7ac35e6d18_Test().service(request, response);

    verify(dispatcher, times(1)).include(request, response);
    verify(writer, times(1)).println("<tr><td>" + book.getBarcode() + "</td>");
    verify(writer, times(1)).println("<td>" + book.getName() + "</td>");
    verify(writer, times(1)).println("<td>" + book.getAuthor() + "</td>");
    verify(writer, times(1)).println("<td>" + book.getPrice() + "</td>");
    verify(writer, times(1)).println("<td>" + 5 + "</td>");
    verify(writer, times(1)).println("<td>" + book.getPrice() * 5 + "</td></tr>");
    verify(writer, times(1)).println("</table><br/><div class='tab'>Total Paid Amount: " + book.getPrice() * 5 + "</div>");
    verify(bookService, times(1)).updateBookQtyById(book.getBarcode(), book.getQuantity() - 5);
}
