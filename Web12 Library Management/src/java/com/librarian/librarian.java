package com.librarian;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.sql.SqlQuery;
import java.util.regex.Pattern;

public class librarian extends HttpServlet {

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
            out.println("<title>Servlet librarian</title>");
            out.println("</head>");
            out.println("<body>");

            
            // Getting responses from html form
            String uname = request.getParameter("libuname");
            String pass = request.getParameter("libpass");
            out.println(uname);
            out.println(pass);

            
            // Checking whether the password is correct or not
//            Pattern p;
//            boolean bool = false;
            
            
            if (!(uname.equals("") && uname == null) && !(pass.equals("") && pass == null)) {
                // Database query fetching details
                // Password matcher (regex)
                
//                String cpass = SqlQuery.matchLib(uname);
////                bool = p.matches(pass, cpass);
//                out.println(cpass);

//                if (cpass.equals(pass)) {
                    RequestDispatcher rd = request.getRequestDispatcher("librarianLoginView");
                    rd.forward(request, response);
                /*} 
                else {
                    out.println("Librarian Doesn't Exist !!!");

                    RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
                    rd.include(request, response);
                    
                    out.print("<br><br>");
                    
                    RequestDispatcher rd1 = request.getRequestDispatcher("addLibrarianForm.html");
                    rd1.include(request, response);
                }*/
            } else {
                out.println("<h2>Invalid Input ! Please Try Again</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
                rd.include(request, response);
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
