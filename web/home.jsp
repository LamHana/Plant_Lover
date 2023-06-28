<%-- 
    Document   : home
    Created on : Jun 28, 2023, 5:38:25 PM
    Author     : Hana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LIST_PRODUCT == null}">
            <c:redirect url = "login.html"></c:redirect>
        </c:if>
        
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <c:if test="${sessionScope.LIST_PRODUCT != null}">
            <table border= '1'>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" varStatus="counter" items="${sessionScope.LIST_PRODUCT}">
                    <form action="MainController">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                <input type="text" name="userID" value="${product.productID}" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="fullname" value="${product.productName}" required=""/>
                            </td>
                            <td>
                                <input type="text" name="roleID" value="${product.price}" required=""/>
                            </td>
                            <td>${product.categoryID}</td>
                            <td>${product.description}</td>
                            <td>${product.quantity}</td>
                            <!--Update day ne-->
                            <td>
                                <input type="submit" name="action" value="Update" />
                                <!--<input type="hidden" name="search" value="${param.search}"/>-->
                            </td>
                            <!-- delete day ne-->
<!--                            <td>
                                
                            </td>-->
                        </tr>
                    </form>
                </c:forEach>
                <tbody>
            </table>
        </c:if>
        <!--${requestScope.ERROR}-->
    </body>
</html>
