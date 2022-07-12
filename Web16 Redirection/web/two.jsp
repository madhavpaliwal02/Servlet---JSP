<%-- 
    Document   : two
    Created on : 07-Dec-2021, 3:58:12 pm
    Author     : Nayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is Page Two</h1>
        
        <!--Action tag-->
        <jsp:forward page="three.jsp"/>
        
        
        <!--Redirection-->
        <%
//            response.sendRedirect("https://www.google.com");
//            response.sendRedirect("three.jsp");
        %>
    </body>
</html>
