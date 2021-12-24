package com.student;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.librarian.*;
import com.sql.*;
import java.util.ArrayList;

public class issueBook extends HttpServlet {

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
            out.println("<title>Servlet issueBook</title>");            
            out.println("</head>");
            out.println("<body>");
            
             ArrayList<Book> book = SqlQuery.selectAllBook();
            
            out.print("<h1>Available Books</h1>");
            out.println("<table border='1' width='100%'>");

            out.print("<tr>"
                    + "<th>Name</th>"
                    + "<th>Description</th>"
                    + "<th>Author Name</th>"
                    + "<th>Edition</th>"
                    + "</tr>");
            
            for(Book b : book){
                out.print("<tr>"
                        + "<td>"+ b.getName() +"</td>"
                        + "<td>"+ b.getDesc() +"</td>"
                        + "<td>"+ b.getAuth() +"</td>"
                        + "<td>"+ b.getEdition() +"</td>"
                        + "</tr>");
            }
            
            out.println("</table>");
            
            
            out.println("<br><br><br><br>"
                    + "<form action='issuedBook' >"
                    + "Enter Book Name: <input type='text' name='bname'/><br>"
                    + "Enter Book Edition: <input type='text' name='bedition'/><br>"
                    + "<input type='submit' value='Selected'>"
                    + "</form>");
            
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
