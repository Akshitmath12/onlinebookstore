@Test
public void testDoPost_Exception() throws IOException, ServletException {
    when(request.getParameter(UsersDBConstants.COLUMN_USERNAME)).thenReturn("testUser");
    when(request.getParameter(UsersDBConstants.COLUMN_PASSWORD)).thenReturn("testPassword");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher(anyString())).thenThrow(new ServletException());

    User user = new User();
    user.setFirstName("testUser");
    when(authService.login(UserRole.CUSTOMER, "testUser", "testPassword", session)).thenReturn(user);

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(writer);

    assertThrows(ServletException.class, () -> {
        customerLoginServlet.doPost(request, response);
    });
}
