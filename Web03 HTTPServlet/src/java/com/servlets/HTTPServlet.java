package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;


public class HTTPServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servicing");
        
        resp.setContentType("text/html");
        
        PrintWriter out = resp.getWriter();
        out.println("This is doGet method of HTTPSerlvet");
        out.println(new Date().toString());
    }
    
}
