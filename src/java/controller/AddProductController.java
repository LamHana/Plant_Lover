/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductDAO;
import model.ProductDTO;

/**
 *
 * @author Hana
 */
public class AddProductController extends HttpServlet {

    private static final String ERROR = "viewProduct.jsp";
    private static final String SUCCESS = "viewProduct.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("price"));
            String categoryName = request.getParameter("categoryName");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String image = request.getParameter("image");
            HttpSession session = request.getSession();
            Map<Integer, String> listCategory = (HashMap<Integer, String>) session.getAttribute("LIST_CATEGORY");
            int categoryID = 0;
            for (Integer key : listCategory.keySet()) {
                if (listCategory.get(key).equalsIgnoreCase(categoryName)) {
                    categoryID = key;
                }
            }
            ProductDTO newProduct = new ProductDTO(quantity, productName, description, price, quantity, categoryID, false, image);
            ProductDAO dao = new ProductDAO();
            Boolean check = dao.addProduct(newProduct);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("MESSAGE_ADD", quantity + " - " + productName + " added");
                    session.setAttribute("LIST_PRODUCT", dao.getListProduct(null, null, 1, 12));
                }

        } catch (Exception e) {
            log("Error at AddPoductController: " + e.toString());
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
