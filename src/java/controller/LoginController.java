/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountDAO;
import model.AccountDTO;
import model.Cart;
import model.UserDTO;
/**
 *
 * @author Hana
 */
public class LoginController extends HttpServlet {
    private static final String LOGIN_PAGE="login.jsp";
    private static final String SUCCESS="MainController?action=product";
    private static final String VIEW_CART="cart.jsp";
    private static final String USER="US";
    private static final String ADMIN="AD";
    private static final String ADMIN_PAGE="ProductController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccountDAO dao = new AccountDAO();
            AccountDTO userAccount = dao.checkLogin(email, password);
            HttpSession session = request.getSession();
            if(userAccount == null ) {
                request.setAttribute("ERROR", "Incorrect userID or password");
            } else {
                UserDTO user = dao.getUserByAccountID(userAccount.getAccountID());
                String roleID = user.getRoleID();
                Cart cart = (Cart) session.getAttribute("CART");
                if(cart != null) {
                    url = VIEW_CART;
                    session.setAttribute("LOGIN_ACCOUNT", userAccount); 
                    session.setAttribute("LOGIN_USER", user);
                    request.getRequestDispatcher(url).forward(request, response);
                    return;
                } else if(ADMIN.equals(roleID)) {
                    url = ADMIN_PAGE;
                    session.setAttribute("LOGIN_ACCOUNT", userAccount);
                    session.setAttribute("LOGIN_USER", user);
                } else if(USER.equals(roleID)) {
                    url=SUCCESS;
                    session.setAttribute("LOGIN_ACCOUNT", userAccount);
                    session.setAttribute("LOGIN_USER", user);
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
