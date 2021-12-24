<%-- 
    Document   : error
    Created on : 06-Dec-2021, 10:47:20 pm
    Author     : Nayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error Occured</h1>
        
        
        <%= exception %>
    </body>
</html>
