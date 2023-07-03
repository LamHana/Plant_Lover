/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoryDAO;
import model.ProductDAO;
import model.ProductDTO;

/**
 *
 * @author Hana
 */
public class ProductController extends HttpServlet {

    private static final String LOGIN_PAGE="login.jsp";
    private static final String SUCCESS="home.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            ProductDAO dao = new ProductDAO();
            CategoryDAO cateDao = new CategoryDAO();
            String search = request.getParameter("search");
            String offset = request.getParameter("offset");
            int pageOffset = 1;
            if(offset != null) {
                pageOffset = Integer.parseInt(offset);
            } 
            int pageSize = dao.getTotalProduct()/10;
            if(pageSize % 10 !=0) {
                pageSize++;
            }
            List<ProductDTO> listProduct = dao.getListProduct(search, null, pageOffset, 10);
            Map<Integer, String> listCategory = cateDao.getAllCategory();
            
            if(listProduct.isEmpty()) {
                request.setAttribute("ERROR", "Don't have any product");
            } else {
                    url = SUCCESS;
                    HttpSession session = request.getSession();
                    session.setAttribute("LIST_PRODUCT", listProduct);
                    session.setAttribute("LIST_CATEGORY", listCategory);
                    request.setAttribute("PAGE_SIZE", pageSize);
                }
        } catch (Exception e) {
            log("Error at ProductController: " + e.toString());
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
