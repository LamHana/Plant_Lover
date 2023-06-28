<%-- 
    Document   : login
    Created on : Jun 13, 2023, 12:25:28 AM
    Author     : Hana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        Input your information:
        <form action="MainController" method="POST">
            User ID<input type="text" name="email" required=""/> </br>
            Password<input type="password" name="password" required=""/> </br>
            <input type="submit" name="action" value="Login"/> </br>
            <a href="MainController?action=RegisterPage"/> Register </br>
            <input type="reset" value="Reset"/> </br>
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8084/LoginGoogleController&response_type=code
           &client_id=385356228676-m07i7cq0e5vhor5rh33inhdu65j1e0iq.apps.googleusercontent.com&approval_prompt=force">Login with Google</a>
        <!--<a href="MainController?action=CreatePage">Create new user</a>-->
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <%= error%>
    </body>
</html>
