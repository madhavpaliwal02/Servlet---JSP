package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        HttpServletRequest req = (HttpServletRequest)request;
        String name = req.getParameter("uname");
        
        out.println("<br>Invoked before<br>");
        
        if(!name.equals("") &&  !name.equals(null)){
             chain.doFilter(request, response);
        }
        else{
            out.println("chal be chutiye...<br>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        
        out.println("<br>Invoked after<br>");
    }
    
}
