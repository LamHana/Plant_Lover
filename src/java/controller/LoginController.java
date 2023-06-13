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

/**
 *
 * @author Hana
 */
public class LoginController extends HttpServlet {
    private static final String LOGIN_PAGE="login.jsp";
    private static final String ADMIN_PAGE="admin.jsp";
    private static final String USER_PAGE="user.jsp";
    private static final String AD="AD";
    private static final String US="US";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccountDTO dao = new AccountDTO();
            AccountDAO userAccount = dao.checkLogin(email, password);
            UserDTO user = userAccount.getUserByAccountID(dao.getAccountID());
            if(userAccount == null ) {
                request.setAttribute("ERROR", "Incorrect userID or password");
            } else {
                String roleID = user.getRoleID();
                HttpSession session = request.getSession();
                if(AD.equals(roleID)) {
                    url = ADMIN_PAGE;
                    session.setAttribute("LOGIN_USER", userAccount); //?????
                } else if(US.equals(roleID)) {
                    url=USER_PAGE;
                    session.setAttribute("LOGIN_USER", userAccount);

                } else {
                    request.setAttribute("ERROR", "Your role is not support!");
                }
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
