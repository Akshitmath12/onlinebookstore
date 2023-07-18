@Test
public void testServiceWithLoggedInUserAndCartItems() throws IOException, ServletException {
    Book book = new Book();
    Cart cart = new Cart();
    List<Cart> cartItems = new ArrayList<>();
    cartItems.add(cart);
    session.setAttribute("cartItems", cartItems);
    session.setAttribute("loggedInUser", "customer");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    response.setWriter(writer);

    servlet.service(request, response);

    verify(bookService, times(1)).updateBookQtyById(anyString(), anyInt());
    assertEquals(BookStoreConstants.CONTENT_TYPE_TEXT_HTML, response.getContentType());
    assertNull(session.getAttribute("cartItems"));
    assertNull(session.getAttribute("amountToPay"));
    assertNull(session.getAttribute("items"));
    assertNull(session.getAttribute("selectedBookId"));
}

@Test
public void testServiceWithLoggedInUserAndNoCartItems() throws IOException, ServletException {
    session.setAttribute("loggedInUser", "customer");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    response.setWriter(writer);

    servlet.service(request, response);

    verify(bookService, never()).updateBookQtyById(anyString(), anyInt());
    assertEquals(BookStoreConstants.CONTENT_TYPE_TEXT_HTML, response.getContentType());
}

@Test
public void testServiceWithNotLoggedInUserAndCartItems() throws IOException, ServletException {
    Book book = new Book();
    Cart cart = new Cart();
    List<Cart> cartItems = new ArrayList<>();
    cartItems.add(cart);
    session.setAttribute("cartItems", cartItems);

    RequestDispatcher rd = mock(RequestDispatcher.class);
    when(request.getRequestDispatcher(anyString())).thenReturn(rd);

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    response.setWriter(writer);

    servlet.service(request, response);

    verify(rd, times(1)).include(any(), any());
    assertEquals(BookStoreConstants.CONTENT_TYPE_TEXT_HTML, response.getContentType());
}
