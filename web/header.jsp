<%-- Document : header Created on : Jul 5, 2023, 1:30:01 AM Author : Hana --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Header -->
<% response.sendRedirect("./");%>
<div id="header">
  <div class="header__logo">
    <a href="">
      <img class="header__logo-img" src="./assets/img/main-logo.png" alt="" />
    </a>
  </div>

  <!-- Nav -->
  <div class="header__nav">
    <ul class="header__nav-container">
      <li><a class="list-item" href="#home">Home</a></li>
      <li><a class="list-item" href="#about">About</a></li>
      <li><a class="list-item" href="#shop">Shop</a></li>
      <li><a class="list-item" href="#contact">Contact</a></li>
    </ul>
    <ul class="header__nav-cart">
      <li id="header__nav-cart">
        <div class="mini-cart">
          <a href="#">
            <c:if test="${sessionScope.CART != null}">
              <c:forEach
                var="product"
                varStatus="counter"
                items="${sessionScope.CART.getCart().values()}"
              >
                <c:set
                  var="total"
                  value="${total + (product.quantity * product.price)}"
                  scope="page"
                />
              </c:forEach>
              <span class="cart-icon">
                <span class="cart-quantity">${sessionScope.CART.size()}</span>
              </span>
              <span class="cart-title"
                >Your cart <br /><strong>${pageScope.total}$</strong></span
              >
            </c:if>
            <c:if test="${sessionScope.CART == null}">
              <span class="cart-icon">
                <span class="cart-quantity">0</span>
              </span>
              <span class="cart-title"
                >Your cart <br /><strong>$0</strong></span
              >
            </c:if>
          </a>
          <!--Cart Dropdown Start-->
          <c:if test="${sessionScope.CART != null}">
            <div
              class="cart-dropdown hidden"
              style="
                padding-top: 30px;
                margin-top: 0px;
                padding-bottom: 15px;
                margin-bottom: 0px;
                display: none;
              "
            >
              <c:forEach
                var="product"
                varStatus="counter"
                items="${sessionScope.CART.getCart().values()}"
              >
                <ul>
                  <li class="single-cart-item">
                    <div class="cart-img">
                      <a
                        href="MainController?action=Detail&productID=${product.productID}"
                        ><img src="${product.image}" alt=""
                      /></a>
                    </div>
                    <div class="cart-content">
                      <h5 class="product-name">
                        <a
                          href="MainController?action=Detail&productID=${product.productID}"
                          >${product.productName}</a
                        >
                      </h5>
                      <span class="cart-price"
                        >${product.quantity} × $${product.price}</span
                      >
                    </div>
                    <div class="cart-remove">
                      <a title="Remove" href="#"><i class="fa fa-times"></i></a>
                    </div>
                  </li>
                </ul>
              </c:forEach>
              <p class="cart-subtotal">
                <strong>Subtotal:</strong>
                <span class="float-right">${pageScope.total}$</span>
              </p>
              <p class="cart-btn">
                <a href="MainController?action=checkout">View cart</a>
                <a href="checkout.html">Checkout</a>
              </p>
            </div>
          </c:if>
          <!--Cart Dropdown End-->
        </div>
      </li>
    </ul>
  </div>
</div>
<!-- End Header -->
