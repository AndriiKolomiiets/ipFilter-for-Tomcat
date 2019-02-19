<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019-02-09
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>City Issue</title>
  </head>
  <body>
  <h1 align="center" style="color:#0000cb">City Issue Website</h1>

  <h2 align="center" style="color:#017b00">Access allowed</h2>

  <p align="center">Unfortunately this is the only available page for now.</p>
  <p align="center">Sorry for the inconvenience.</p>
  <%
      java.util.Date date = new java.util.Date();
  %>
  <h3 align="center">
      Current day and time:
      <%=date.toString()%>
  </h3>


  </body>
</html>
