<%-- 
    Document   : errorMessage
    Created on : Aug 26, 2020, 2:15:49 AM
    Author     : Diego Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Message</title>
    </head>
    <%
        String strMessage = 
                (String) request.getSession().getAttribute("message");
    %>
    <body>
        <h1>Error Message</h1>
        <p><%= strMessage %></p>
        <br><br>
        <a href="index.html">Volver al login</a>
    </body>
</html>