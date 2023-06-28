<%-- 
    Document   : register
    Created on : Jun 14, 2023, 2:18:51 PM
    Author     : Hana
--%>

<%@page import="model.UserGoogleDTO"%>
<%@page import="model.AccountDTO"%>
<%@page import="model.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }

            UserGoogleDTO accountGoogle = (UserGoogleDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (accountGoogle == null) {
                accountGoogle = new UserGoogleDTO();
            }
        %>
        REGISTER :
        <form action="MainController">
            <%
                if (accountGoogle.getEmail() != null) {
            %>
            Email <input type="email" name="email" value="<%= accountGoogle.getEmail()%>" required="" readonly=""/>  <%= userError.getEmailError()%>
            <br>Full Name <input type="text" name="fullname" value="<%= accountGoogle.getName()%>" required="" readonly=""/>  <%= userError.getFullNameError()%>  
            <%
            } else {
            %>
            Email <input type="email" name="email"  required=""/>  <%= userError.getEmailError()%>
            <br>Full Name <input type="text" name="fullname" required=""/>  <%= userError.getFullNameError()%>  
            <%
                }
            %>
            <br>Phone Number <input type="text" name="phoneNumber" required=""/>  <%= userError.getFullNameError()%>
            <br>Address <input type="text" name="address" required=""/>  <%= userError.getFullNameError()%>
            <br>Role ID <input type="text" name="roleID" value="US" readonly=""/>
            <br>Password <input type="password" name="password" required=""/>
            <br>Confirm <input type="password" name="confirm" required=""/>  <%= userError.getConfirmError()%>    
            <br><input type="submit" name="action" value="register"/>
            <input type="reset" value="Reset"/>
            <%= userError.getError()%>       
        </form>

    </body>
</html>
