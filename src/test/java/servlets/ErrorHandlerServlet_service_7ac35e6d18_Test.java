@Test
public void serviceTest_UnauthenticatedUser() throws Exception {
    MockitoAnnotations.openMocks(this);
    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(writer);
    when(request.getAttribute("javax.servlet.error.status_code")).thenReturn(401);
    when(request.getAttribute("javax.servlet.error.exception")).thenReturn(new StoreException("Unauthorized", 401, "UNAUTHORIZED"));
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("index.html")).thenReturn(requestDispatcher);
    when(session.getAttribute("userRole")).thenReturn(null);
    new ErrorHandlerServlet().service(request, response);
    writer.flush();
    assertEquals(true, stringWriter.toString().contains("Unauthorized"));
}
