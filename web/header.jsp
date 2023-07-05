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
            <span class="cart-icon">
              <span class="cart-quantity">2</span>
            </span>
            <span class="cart-title"
              >Your cart <br /><strong>$190.00</strong></span
            >
          </a>
          <!--Cart Dropdown Start-->
          <div
            class="cart-dropdown hidden"
            style="
              height: 443.2px;
              padding-top: 30px;
              margin-top: 0px;
              padding-bottom: 15px;
              margin-bottom: 0px;
              display: none;
            "
          >
            <ul>
              <li class="single-cart-item">
                <div class="cart-img">
                  <a href="single-product.html"
                    ><img src="img/cart/cart1.jpg" alt=""
                  /></a>
                </div>
                <div class="cart-content">
                  <h5 class="product-name">
                    <a href="single-product.html">Odio tortor consequat</a>
                  </h5>
                  <span class="cart-price">1 × $90.00</span>
                </div>
                <div class="cart-remove">
                  <a title="Remove" href="#"><i class="fa fa-times"></i></a>
                </div>
              </li>
              <li class="single-cart-item">
                <div class="cart-img">
                  <a href="single-product.html"
                    ><img src="img/cart/cart2.jpg" alt=""
                  /></a>
                </div>
                <div class="cart-content">
                  <h5 class="product-name">
                    <a href="single-product.html">Auctor sem</a>
                  </h5>
                  <span class="cart-price">1 × $100.00</span>
                </div>
                <div class="cart-remove">
                  <a title="Remove" href="#"><i class="fa fa-times"></i></a>
                </div>
              </li>
            </ul>
            <p class="cart-subtotal">
              <strong>Subtotal:</strong>
              <span class="float-right">$190.00</span>
            </p>
            <p class="cart-btn">
              <a href="cart.html">View cart</a>
              <a href="checkout.html">Checkout</a>
            </p>
          </div>
          <!--Cart Dropdown End-->
        </div>
      </li>
    </ul>
  </div>
</div>
<!-- End Header -->
