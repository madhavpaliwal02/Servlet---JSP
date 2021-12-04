
package com.servlets;
import javax.servlet.*;
import java.io.*;


public class SecondServlets extends GenericServlet {
    
    public void service(ServletRequest req, ServletResponse resp)throws ServletException, IOException{
        System.out.println("This is my Generic Servlet");
        resp.setContentType("text/html");
        
        PrintWriter out = resp.getWriter();
        out.println("<h2>This is my second servlet</h2>");
    }
}
