<%-- 
    Document   : admin
    Created on : Jun 13, 2023, 12:25:01 AM
    Author     : Hana
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        Admin's information:
        <%
           UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
           if(loginUser == null || !"AD".equals(loginUser.getRoleID())) {
               response.sendRedirect("login.html");
               return;
           }
         %>
         User ID: <%= loginUser.getUserID() %> <br>
         Full Name: <%= loginUser.getUserName()  %> <br>
         Role ID: <%= loginUser.getRoleID()%> <br>
         Address: <%= loginUser.getAddress() %> <br>
    </body>
</html>
