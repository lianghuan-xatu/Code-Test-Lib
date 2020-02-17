<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/2/11
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <%
        System.out.println("hello jsp");
          String contextPath1 = request.getContextPath();
          out.print(contextPath1);
      %>
      <h1>hi    JSP</h1>
    <% response.getWriter().write("response...");%>
  Hello Response
  $END$
  </body>
</html>
