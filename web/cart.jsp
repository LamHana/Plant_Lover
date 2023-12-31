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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
    <!-- Header -->
    <c:import url="./header.jsp" />
    <!-- End Header -->
    <!-- breadcrumb two start -->
    <div class="breadcrumb-tow mb-120">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="breadcrumb-title">
              <h1>Shopping Cart</h1>
            </div>
            <div class="breadcrumb-content breadcrumb-content-tow">
              <ul>
                <li><a href="home.jsp">Home</a></li>
                <li class="active">Shopping Cart</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- breadcrumb two end -->

    <!-- Shopping cart start -->
    <div class="Shopping-cart-area mb-110">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <form action="#">
              <div class="table-content table-responsive">
                <table class="table">
                  <thead>
                    <tr>
                      <th class="plantmore-product-remove">remove</th>
                      <th class="plantmore-product-thumbnail">images</th>
                      <th class="cart-product-name">Product</th>
                      <th class="plantmore-product-price">Unit Price</th>
                      <th class="plantmore-product-quantity">Quantity</th>
                      <th class="plantmore-product-subtotal">Total</th>
                      <th class="plantmore-product-update">Update</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:if test="${sessionScope.CART.size() > 0}">
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
                        <form action="MainController">
                          <tr>
                            <td class="plantmore-product-remove">
                              <a
                                href="MainController?action=RemoveCart&productID=${product.productID}"
                                ><i class="fa fa-times"></i
                              ></a>
                            </td>
                            <td class="plantmore-product-thumbnail">
                              <a
                                href="MainController?action=Detail&productID=${product.productID}"
                                ><img src="${product.image}" alt=""
                              /></a>
                            </td>
                            <td class="plantmore-product-name">
                              <a
                                href="MainController?action=Detail&productID=${product.productID}"
                                >${product.productName}</a
                              >
                            </td>
                            <td class="plantmore-product-price">
                              <span class="amount">$${product.price}</span>
                            </td>
                            <td class="plantmore-product-quantity">
                              <input
                                value="${product.quantity}"
                                type="number"
                                name="quantity"
                                min="1"
                              />
                            </td>
                            <td class="product-subtotal">
                              <span class="amount"
                                >$${product.price*product.quantity}</span
                              >
                            </td>
                            <td>
                              <div class="product-update">
                                <input
                                  value="${product.productID}"
                                  type="hidden"
                                  name="productID"
                                />
                                <input
                                  class="button"
                                  name="action"
                                  value="Update"
                                  type="submit"
                                />
                              </div>
                            </td>
                          </tr>
                        </form>
                      </c:forEach>
                    </c:if>
                    <c:if test="${sessionScope.CART.size() == 0}">
                      <tr class="empty-row">
                        <td>You don't have any product</td>
                      </tr>
                    </c:if>
                  </tbody>
                </table>
              </div>
              <div class="row">
                <div class="col-md-5 ml-auto">
                  <div class="cart-page-total">
                    <h2>Cart totals</h2>
                    <ul>
                      <li>Subtotal <span>${pageScope.total}$</span></li>
                      <li>Total <span>${pageScope.total}$</span></li>
                    </ul>
                    <c:if test="${sessionScope.CART.size() > 0}">
                      <a href="MainController?action=Order"
                        >Proceed to checkout</a
                      >
                    </c:if>
                    <c:if test="${sessionScope.CART.size() == 0}">
                      <a href="/" onclick="return false;"
                        >Proceed to checkout</a
                      >
                    </c:if>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Shopping cart end -->
  </body>
</html>
