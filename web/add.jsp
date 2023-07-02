<%-- 
    Document   : add
    Created on : Jul 2, 2023, 4:20:25 PM
    Author     : Hana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <form action="MainController">
            Product Name <input type="text" name="productName" required=""/> 
            <br>Price <input type="text" name="price" required=""/>  
            <br>Category <input type="text" name="categoryName" required=""/>
            <br>Description <input type="text" name="description" required=""/>
            <br>Quantity <input type="number" name="quantity" required="" min=""/>     
            <br><input type="submit" name="action" value="Add"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
