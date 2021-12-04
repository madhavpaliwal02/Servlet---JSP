
package com.servlets;
import javax.servlet.*;
import java.io.*;

public class FirstServlets implements Servlet {
    
    // Life cycle method
    
    ServletConfig conf;
    
    public void init (ServletConfig conf){
        this.conf = conf;
        System.out.println("Creating....");
    }
    
    public void service(ServletRequest req, ServletResponse resp) throws ServletException , IOException{
        System.out.println("Servicing.....");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello Everyone");
    }
    
    public void destroy(){
        System.out.println("Destroying....");
    }
    
    // Non Life cycle method
    
    public ServletConfig getServletConfig(){
        return conf;
    }
    
    public String getServletInfo(){
        return "This is my first Servlet";
    }
   
}
