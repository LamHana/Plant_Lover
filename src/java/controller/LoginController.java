/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountDAO;
import model.AccountDTO;
import model.UserDAO;
import model.UserDTO;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author Hana
 */
public class LoginController extends HttpServlet {
    private static final String LOGIN_PAGE="login.jsp";
    private static final String SUCCESS="admin.jsp";
    private static final String AD="AD";
    private static final String US="US";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccountDAO dao = new AccountDAO();
            AccountDTO userAccount = dao.checkLogin(email, password);
            UserDTO user = dao.getUserByAccountID(userAccount.getAccountID());
            if(userAccount == null ) {
                request.setAttribute("ERROR", "Incorrect userID or password");
            } else {
                HttpSession session = request.getSession();
                    url = SUCCESS;
                    session.setAttribute("LOGIN_ACCOUNT", userAccount);
                    session.setAttribute("LOGIN_USER", user);
                }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
