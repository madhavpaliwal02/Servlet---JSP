package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Intro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try{
            PrintWriter out = resp.getWriter();
            
            String name = req.getParameter("uname");
            int age = Integer.parseInt(req.getParameter("uage"));
            
            out.println("Hello Boss! " + name);
            out.println("<br>You are " + age + " years old");
            
//            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
