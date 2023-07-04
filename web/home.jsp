<%@page import="java.util.Map"%> <%@page import="model.CategoryDTO"%> <%@page
import="java.util.List"%> <%@page import="model.ProductDTO"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" href="./assets/css/main.css" />
    <link
      rel="stylesheet"
      href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css"
    />
    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"
    ></script>
    <title>Plant Lover</title>
  </head>
  <body>
    <!-- Header -->
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

    <!-- Home section -->
    <section id="Home">
      <div class="home">
        <div class="container">
          <h1 class="home__heading">
            Perfect Plant
            <br />
            Sale In LookBook
          </h1>
          <div class="home__border"></div>
          <p class="home__content">
            Welcome to our plant paradise, where green dreams
            <br />
            come true. Explore our stunning collection and
            <br />
            bring nature's beauty into your space with ease.
          </p>
          <div class="btn btn--primary home__button">
            <a href="#">Shop Collection</a>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="22"
              height="22"
              fill="currentColor"
              class="bi bi-arrow-right-circle ml-2"
              viewBox="0 0 16 16"
            >
              <path
                fill-rule="evenodd"
                d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"
              />
            </svg>
          </div>
        </div>
      </div>
    </section>
    <!-- End Hero section -->

    <!-- Feature section -->
    <section id="feature">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <!--Single Feature Start-->
            <div class="single-feature mb-35">
              <div class="feature-icon">
                <span class="lnr lnr-rocket"></span>
              </div>
              <div class="feature-content">
                <h3>FREE SHIPPING</h3>
                <p>ALL ORDER OVER $100</p>
              </div>
            </div>
            <!--Single Feature End-->
          </div>
          <div class="col-lg-4 col-md-6">
            <!--Single Feature Start-->
            <div class="single-feature mb-35">
              <div class="feature-icon">
                <span class="lnr lnr-phone"></span>
              </div>
              <div class="feature-content">
                <h3>24/7 DEDICATED SUPPORT</h3>
                <p>0786 981 691</p>
              </div>
            </div>
            <!--Single Feature End-->
          </div>
          <div class="col-lg-4 col-md-6">
            <!--Single Feature Start-->
            <div class="single-feature mb-35">
              <div class="feature-icon">
                <span class="lnr lnr-redo"></span>
              </div>
              <div class="feature-content">
                <h3>MONEY BACK</h3>
                <p>IF THE ITEM DIDN’T SUIT YOU</p>
              </div>
            </div>
            <!--Single Feature End-->
          </div>
        </div>
      </div>
    </section>
    <!-- End Feature section -->

    <!-- History section -->
    <section id="history">
      <div class="our-history-area mt-85">
        <div class="container">
          <div class="row">
            <!--Section Title Start-->
            <div class="col-12">
              <div class="section-title text-center mb-35">
                <h2>Our History</h2>
                <span>A little story about us</span>
              </div>
            </div>
            <!--Section Title End-->
          </div>
          <div class="row">
            <div class="col-lg-12 ms-auto me-auto">
              <div class="history-area-content text-center">
                <p class="text-center">
                  <strong
                    >Welcome to our flourishing online plant emporium, where
                    nature meets convenience!</strong
                  >
                </p>
                <p class="text-center">
                  We are passionate about fostering a deep connection between
                  people and plants. Our carefully curated selection showcases a
                  wide variety of plants, ranging from lush indoor foliage to
                  enchanting outdoor blooms, catering to every gardening
                  enthusiast's desires and preferences. Customer satisfaction is
                  at the core of our values, and we strive to provide an
                  exceptional shopping experience. Our dedicated team of plant
                  experts is readily available to answer any questions, offer
                  guidance on plant care, and provide personalized
                  recommendations, making your journey with us as enjoyable as
                  tending to your beloved plants.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End History section -->

    <!-- Shop section -->
    <section id="Shop">
      <div class="product-area mt-85">
        <div class="container">
          <div class="row">
            <!--Section Title Start-->
            <div class="col-12">
              <div class="section-title text-center mb-35">
                <span>Our Special Product</span>
                <h3>Featured Products</h3>
              </div>
            </div>
            <!--Section Title End-->
          </div>
          <div class="row mb-3 justify-content-between align-items-center">
            <div class="col-md-4 search-dropdown">
              <form action="MainController">
                <input
                  name="search"
                  id="search"
                  placeholder="Search"
                  value="${param.search}"
                  type="text"
                />
                <input
                  type="hidden"
                  name="category"
                  value="${param.category}"
                />
                <button type="submit" name="action" value="Search">
                  <i class="fa fa-search"></i>
                </button>
              </form>
            </div>
            <div class="col-md-2">
              <div class="dropdown">
                <button
                  class="btn btn-secondary dropdown-toggle d-flex align-items-center justify-content-center"
                  type="button"
                  id="dropdownMenuButton"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  <c:if test="${not empty param.category}">
                    ${param.category}
                  </c:if>
                  <c:if test="${empty param.category}"> Category </c:if>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                  <a
                    class="dropdown-item"
                    href="ProductController?category=&search=${param.search}"
                    >All plants</a
                  >
                  <c:forEach
                    var="categoryKey"
                    varStatus="counter"
                    items="${sessionScope.LIST_CATEGORY.keySet()}"
                  >
                    <a
                      class="dropdown-item"
                      href="ProductController?category=${sessionScope.LIST_CATEGORY.get(categoryKey)}&search=${param.search}"
                      >${sessionScope.LIST_CATEGORY.get(categoryKey)}</a
                    >
                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <c:if test="${sessionScope.LIST_PRODUCT != null}">
            <c:if test="${sessionScope.LIST_CATEGORY != null}">
              <div class="row">
                <c:forEach
                  var="product"
                  varStatus="counter"
                  items="${sessionScope.LIST_PRODUCT}"
                >
                  <c:if test="${product.isDeleted == false}">
                    <div class="col-md-3">
                      <form action="MainController">
                        <!-- Single Product Start -->
                        <div class="single-product mb-25">
                          <div class="product-img img-full">
                            <a href="single-product.html">
                              <img src="${product.image}" alt="" />
                            </a>
                            <span class="onsale">Sale!</span>
                            <div class="product-action">
                              <ul>
                                <li>
                                  <a
                                    href="#open-modal"
                                    data-bs-toggle="modal"
                                    title="Quick view"
                                    ><i class="fa fa-search"></i
                                  ></a>
                                </li>
                                <li>
                                  <a href="#" title="Whishlist"
                                    ><i class="fa fa-heart-o"></i
                                  ></a>
                                </li>
                                <li>
                                  <a href="#" title="Compare"
                                    ><i class="fa fa-refresh"></i
                                  ></a>
                                </li>
                              </ul>
                            </div>
                          </div>
                          <div class="product-content">
                            <h2>
                              <a href="single-product.html"
                                >${product.productName}</a
                              >
                            </h2>
                            <div class="product-price">
                              <div class="price-box">
                                <span class="regular-price"
                                  >${product.price}</span
                                >
                              </div>
                              <div>
                                ${sessionScope.LIST_CATEGORY.get(product.categoryID)}
                              </div>
                              <div class="add-to-cart">
                                <a href="#">Add To Cart</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!--Single Product End-->
                      </form>
                    </div>
                  </c:if>
                </c:forEach>
              </div>
            </c:if>
          </c:if>
          <c:if test="${sessionScope.LIST_PRODUCT == null}">
            <div>Empty</div>
          </c:if>
          <!--Pagination Start-->
          <div class="product-pagination">
            <ul>
              <c:forEach begin="1" end="${requestScope.PAGE_SIZE}" var="i">
                  <c:if test="${param.offset != null}">
                    <c:if test="${param.offset == i}">
                      <li class="product-pagination__page active">
                        <a
                          href="ProductController?offset=${i}&search=${param.search}&category=${param.category}"
                          >${i}</a
                        >
                      </li>
                    </c:if>
                      <c:if test="${param.offset != i}">
                      <li class="product-pagination__page">
                        <a
                          href="ProductController?offset=${i}&search=${param.search}&category=${param.category}"
                          >${i}</a
                        >
                      </li>
                    </c:if>
                  </c:if>
                    <c:if test="${param.offset == null}">
                        <c:if test="${i == 1}">
                            <li class="product-pagination__page active">
                            <a
                              href="ProductController?offset=${i}&search=${param.search}&category=${param.category}"
                              >${i}</a
                            >
                          </li>
                        </c:if>
                           <c:if test="${i != 1}">
                            <li class="product-pagination__page">
                            <a
                              href="ProductController?offset=${i}&search=${param.search}&category=${param.category}"
                              >${i}</a
                            >
                          </li>
                        </c:if>
                    </c:if>
              </c:forEach>
              <li>
                <a href="ProductController?offset=${param.offset != null ? (param.offset == requestScope.PAGE_SIZE ? 1: param.offset+1) : 2}&search=${param.search}&category=${param.category}"><i class="fa fa-angle-double-right"></i></a>
              </li>
            </ul>
          </div>
          <!--Pagination End-->
          ${requestScope.ERROR}
        </div>
      </div>
    </section>
    <!-- ENd Shop section -->

    <!-- Footer section -->
    <footer>
      <div class="footer-container">
        <!--Footer Middle Area Start-->
        <div class="footer-middle-area black-bg">
          <div class="container">
            <div class="row">
              <div class="col-lg-3 col-md-6">
                <!--Single Footer Widget Start-->
                <div class="single-footer-widget mb-30">
                  <div class="footer-logo">
                    <a href="index.html"
                      ><img src="./assets/img/main-logo.png" alt=""
                    /></a>
                  </div>
                </div>
                <!--Single Footer Widget End-->
              </div>
              <div class="col-lg-3 col-md-6">
                <!--Single Footer Widget Start-->
                <div class="single-footer-widget mb-30">
                  <div class="footer-info">
                    <div class="icon">
                      <i class="fa fa-home"></i>
                    </div>
                    <p>Address : S10.06 Vinhome Grand Park, HCM City.</p>
                  </div>
                </div>
                <!--Single Footer Widget End-->
              </div>
              <div class="col-lg-3 col-md-6">
                <!--Single Footer Widget Start-->
                <div class="single-footer-widget mb-30">
                  <div class="footer-info">
                    <div class="icon">
                      <i class="fa fa-envelope-open-o"></i>
                    </div>
                    <p>Email: <br />lamtngochan@gmail.com</p>
                  </div>
                </div>
                <!--Single Footer Widget End-->
              </div>
              <div class="col-lg-3 col-md-6">
                <!--Single Footer Widget Start-->
                <div class="single-footer-widget mb-30">
                  <div class="footer-info">
                    <div class="icon">
                      <i class="fa fa-mobile"></i>
                    </div>
                    <p>Phone: <br />(+84) 786 981 691</p>
                  </div>
                </div>
                <!--Single Footer Widget End-->
              </div>
            </div>
          </div>
        </div>
        <!--Footer Middle Area End-->
      </div>
    </footer>
    <!-- Footer section end -->
  </body>
  <script src="./assets/js/header.js"></script>
</html>
