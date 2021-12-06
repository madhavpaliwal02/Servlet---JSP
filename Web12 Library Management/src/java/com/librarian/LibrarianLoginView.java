package com.librarian;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class LibrarianLoginView extends HttpServlet {

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
            out.println("<title>Servlet LibrarianLoginView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("");
            
            out.println("<table> <td>");
            
            out.println("<br>"
                    + "<form action='addBookForm.html'>"
                    + "<input type='submit' value='Add Books'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='viewBooks'>"
                    + "<input type='submit' value='View Books'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='removeBooks'>"
                    + "<input type='submit' value='Remove Books'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='issueBooks'>"
                    + "<input type='submit' value='View Issued Books'>"
                    + "</form>");
            
            out.println("</td> <td>");
            
            out.println("<br>"
                    + "<form action='addStudentForm.html'>"
                    + "<input type='submit' value='Add Students'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='viewStudent'>"
                    + "<input type='submit' value='View Students'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='removeStudent'>"
                    + "<input type='submit' value='Remove Students'>"
                    + "</form>");
            
            out.println("<br>"
                    + "<form action='login.html'>"
                    + "<input type='submit' value='Log-out'>"
                    + "</form>");
            
            out.println("</td> </table>");
            
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
