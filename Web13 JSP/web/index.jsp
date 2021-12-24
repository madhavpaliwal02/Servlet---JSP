<%-- 
    Document   : index
    Created on : 06-Dec-2021, 3:02:50 pm
    Author     : Nayan
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page info="Madhav Paliwa" %>
<%@page isErrorPage="true" %>

<%@include file="index.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <!--Declarative tag-->
        <%!
           int a = 110;
           int b = 202;
           int sum(int a, int b){
            return a+b;
            }   
        %>
        
        <!--Scriptlet tag-->
        <%
//            int a=10, b=200;
            out.println("Sum is " + sum(a, b));
        %>
        
        <!--Expression tag-->
        <%=
            "The sum is  " + sum(a, b)
        %>
        <%=
            new Date().toString() 
        %>
        
        
    </body>
</html>
