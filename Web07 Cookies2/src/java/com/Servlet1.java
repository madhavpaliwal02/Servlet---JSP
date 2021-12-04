package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("uname");
            String pass = request.getParameter("upass");
            String email = request.getParameter("uemail");
            
            out.print(name);
            out.print(pass);
            out.print(email);
            
            out.println("<a href='s2'> GO TO SERVLET2 <a/>");
            
            Cookie cname = new Cookie("uname", name);
            response.addCookie(cname);
            
            Cookie cpass = new Cookie("upass", pass);
            response.addCookie(cpass);
            
            Cookie cemail = new Cookie("uemail", email);
            response.addCookie(cemail);
            
//            out.println("<form action='s2'>");
//            out.println("Name : <input type='text' value='+name+' ");
//            out.println("Password : <input type='text' value='+pass+'>");
//            out.println("Email : <input type='email' value=+email+ ");
//            out.println("<input type='s2' value='GO TO SERVLET2'/>");
//            out.println("</form>");
//            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
