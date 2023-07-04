<%-- 
    Document   : header
    Created on : Jul 5, 2023, 1:30:01 AM
    Author     : Hana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Header -->
<% response.sendRedirect("./");%>
<div id="header">
    <div class="header__logo">
        <a href="">
            <img
                class="header__logo-img"
                src="./assets/img/main-logo.png"
                alt=""
                />
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
                <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="24"
                    height="24"
                    fill="currentColor"
                    class="bi bi-cart3 mr-2"
                    viewBox="0 0 16 16"
                    >
                    <path
                        d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
                        />
                </svg>
                <div class="header__nav-cart-info">
                    <a href="#">Your cart</a>
                    <p>$190.0</p>
                </div>
            </li>
        </ul>
    </div>
</div>
<!-- End Header -->

