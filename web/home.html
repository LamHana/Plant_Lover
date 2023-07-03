<!-- <%-- 
    Document   : home
    Created on : Jun 28, 2023, 5:38:25 PM
    Author     : Hana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
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
        
         <form action="MainController">
            Search <input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="Search" />
        </form>
            
        <c:if test="${sessionScope.LIST_PRODUCT != null}">
            <c:if test="${sessionScope.LIST_CATEGORY != null}">
                <table border= '1'>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" varStatus="counter" items="${sessionScope.LIST_PRODUCT}">
                            <c:if test="${product.isDeleted == false}">
                                <form action="MainController">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>
                                            <input type="text" name="productName" value="${product.productName}" required=""/>
                                            <input type="hidden" name="productID" value="${product.productID}" required=""/>
                                        </td>
                                        <td>
                                            <input type="text" name="price" value="${product.price}" required=""/>
                                        </td>
                                        <td>${sessionScope.LIST_CATEGORY.get(product.categoryID)}</td>
                                        <td>${product.description}</td>
                                        <td>
                                            <input type="text" name="quantity" value="${product.quantity}" required="" min=""/>
                                        </td>
                                        <!--Update day ne-->
                                        <td>
                                            <input type="submit" name="action" value="Update" />
                                            <input type="hidden" name="search" value="${param.search}"/>
                                        </td>
                                        <!-- delete day ne-->
                                        <td>
                                            <c:url var="remove" value="MainController">
                                                <c:param name="action" value="RemoveProduct"></c:param>
                                                <c:param name="productID" value="${product.productID}"></c:param>
                                                <c:param name="search" value="${param.search}"></c:param>
                                            </c:url>
                                            <a href="${remove}">Delete</a>
                                        </td>
                                    </tr>
                                </form>
                            </c:if>
                        </c:forEach>
                    <tbody>
                </table>
            </c:if>
        </c:if>
        <c:forEach begin="1" end="${requestScope.PAGE_SIZE}" var="i">
            <a href="ProductController?offset=${i}">${i}</a>
        </c:forEach>
            <a href="MainController?action=AddPage">add</a>
        ${requestScope.ERROR}
    </body>
</html>
