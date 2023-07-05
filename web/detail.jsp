<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="./assets/js/header.js"></script>
    <title>Plant Lover</title>
  </head>
  <body>
    <!-- Breadcrumb one start -->
    <div class="breadcrumb-one mb-120">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="breadcrumb-img">
              <img src="./assets/img/banner.jpg" alt="" />
            </div>
            <div class="breadcrumb-content">
              <h3>Want more?</h3>
              <h1>Plant Store</h1>
              <ul>
                <li><a href="MainController?action=product">Home</a></li>
                <li class="active">Single Product</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Breadcrumb one end -->
    <c:if test="${requestScope.PRODUCT != null}">
      <!-- Single product start -->
      <div class="single-product-area mb-115">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-lg-5">
              <div class="product-details-img-tab">
                <!--Product Tab Content Start-->
                <div class="tab-content single-product-img">
                  <div class="product-large-thumb">
                    <div class="easyzoom easyzoom--overlay is-ready">
                      <a href="${requestScope.PRODUCT.image}">
                        <img src="${requestScope.PRODUCT.image}" alt="" />
                      </a>
                      <!-- <a
                      href="./assets/img/insta-item-1.jpg"
                      class="popup-img venobox vbox-item"
                      data-gall="myGallery"
                      ><i class="fa fa-search"></i
                    ></a> -->
                    </div>
                  </div>
                </div>
                <!--Product Tab Content End-->
              </div>
            </div>
            <div class="col-md-12 col-lg-7">
              <!--Product Details Content Start-->
              <div class="product-details-content">
                <!--Product Nav Start-->
                <div class="product-nav">
                  <a href="#"><i class="fa fa-angle-left"></i></a>
                  <a href="#"><i class="fa fa-angle-right"></i></a>
                </div>
                <!--Product Nav End-->
                <h2>${requestScope.PRODUCT.productName}</h2>
                <div class="single-product-reviews">
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star-o"></i>
                  <a class="review-link" href="#">(1 customer review)</a>
                </div>
                <fmt:formatNumber
                  value="${requestScope.PRODUCT.price +
                    0.1*requestScope.PRODUCT.price}"
                  pattern="#,##"
                  var="formattedNumber"
                />
                <div class="single-product-price">
                  <span class="price new-price">$${formattedNumber}</span>
                  <span class="regular-price"
                    >$${requestScope.PRODUCT.price}</span
                  >
                </div>
                <div class="product-description">
                  <p>${requestScope.PRODUCT.description}</p>
                </div>
                <p class="stock in-stock">
                  ${requestScope.PRODUCT.quantity} in stock
                </p>
                <div class="single-product-quantity">
                  <form class="add-quantity" action="#">
                    <div class="product-quantity">
                      <input value="1" type="number" />
                    </div>
                    <div class="add-to-link">
                      <button class="product-btn" data-text="add to cart">
                        add to cart
                      </button>
                    </div>
                  </form>
                </div>
                <div class="wishlist-compare-btn">
                  <a href="#" class="wishlist-btn">Add to Wishlist</a>
                  <a href="#" class="add-compare">Compare</a>
                </div>
                <div class="product-meta">
                  <span class="posted-in">
                    Categories:
                    <a href="#">Accessories</a>,
                    <a href="#">Electronics</a>
                  </span>
                </div>
                <div class="single-product-sharing">
                  <h3>Share this product</h3>
                  <ul>
                    <li>
                      <a href="#"><i class="fa fa-facebook"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fa fa-twitter"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fa fa-pinterest"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fa fa-google-plus"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fa fa-linkedin"></i></a>
                    </li>
                  </ul>
                </div>
              </div>
              <!--Product Details Content End-->
            </div>
          </div>
        </div>
      </div>
      <!-- Single product end -->

      <!-- Description and review  -->
      <div class="product-description-review-area mb-100">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="product-review-tab">
                <!--Review And Description Tab Menu Start-->
                <ul class="nav dec-and-review-menu" role="tablist">
                  <li>
                    <a
                      class="active"
                      data-bs-toggle="tab"
                      href="#description"
                      aria-selected="true"
                      role="tab"
                      >Description</a
                    >
                  </li>
                  <li>
                    <a
                      data-bs-toggle="tab"
                      href="#reviews"
                      aria-selected="false"
                      tabindex="-1"
                      role="tab"
                      >Reviews (1)</a
                    >
                  </li>
                </ul>
                <!--Review And Description Tab Menu End-->
                <!--Review And Description Tab Content Start-->
                <div
                  class="tab-content product-review-content-tab"
                  id="myTabContent-4"
                >
                  <div
                    class="tab-pane fade active show"
                    id="description"
                    role="tabpanel"
                  >
                    <div class="single-product-description">
                      <p>${requestScope.PRODUCT.description}</p>
                    </div>
                  </div>
                  <div class="tab-pane fade" id="reviews" role="tabpanel"></div>
                </div>
                <!--Review And Description Tab Content End-->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Description and review end -->
    </c:if>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="./assets/js/easyzoom.js"></script>
    <script>
      // Instantiate EasyZoom instances
      var $easyzoom = $(".easyzoom").easyZoom();
    </script>
  </body>
</html>
