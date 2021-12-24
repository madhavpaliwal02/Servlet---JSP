package com.admin;

import com.sql.Librarian;
import com.sql.SqlQuery;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addLibrarian extends HttpServlet {

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
            out.println("<title>Servlet addLibrarian</title>");
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("libname");
            String uname = request.getParameter("libuname");
            String pass = request.getParameter("libpass");

            if (!(name.equals("") || pass.equals("") || uname.equals(""))
                    && !(name == null || uname == null || pass == null)) {
                
//                out.println(name +" "+ uname +" "+ pass);

                Librarian lib = new Librarian();
                lib.setName(name);
                lib.setUname(uname);
                lib.setPass(pass);

                // insert query
                int status = SqlQuery.insertLib(lib);
//                int status = SqlQuery.insert(name, uname, pass);

                if (status > 0) {
                    out.println("<h1>Successfully Submitted...</h1>");
                    RequestDispatcher rd1 = request.getRequestDispatcher("adminLoginView");
                    rd1.include(request, response);
                } else {
                    out.println("<h3>Sorry ! unable to save...</h3>");
                }

            } else {
                out.println("Invalid Input! Please try again");

                RequestDispatcher rd2 = request.getRequestDispatcher("addLibrarianForm.html");
                rd2.include(request, response);
            }

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
