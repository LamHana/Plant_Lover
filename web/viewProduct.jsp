<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- breadcrumb two start -->
    <div class="breadcrumb-tow mb-120">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="breadcrumb-title">
              <h1>Management Product</h1>
            </div>
            <div class="breadcrumb-content breadcrumb-content-tow">
              <ul>
                <li><a href="home.jsp">Home</a></li>
                <li class="active">Management Product</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- breadcrumb two end -->

    <!-- Shopping cart start -->
    <div class="Shopping-cart-area mb-35">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <form action="#">
              <div class="table-content table-responsive">
                <table class="table">
                  <thead>
                    <tr>
                      <th class="plantmore-product-remove">remove</th>
                      <th class="plantmore-product-no">No</th>
                      <th class="plantmore-product-id">Product ID</th>
                      <th class="plantmore-product-thumbnail">images</th>
                      <th class="cart-product-name">Product</th>
                      <th class="product-name">Category</th>
                      <th class="plantmore-product-price">Unit Price</th>
                      <th class="plantmore-product-quantity">Quantity</th>
                      <th class="plantmore-product-update">Update</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach
                      var="product"
                      varStatus="counter"
                      items="${sessionScope.LIST_PRODUCT}"
                    >
                      <c:if test="${product.isDeleted == false}">
                        <form action="MainController">
                          <tr>
                            <td class="plantmore-product-remove">
                              <a
                                href="MainController?action=RemoveProduct&productID=${product.productID}"
                                ><i class="fa fa-times"></i
                              ></a>
                            </td>
                            <td>${counter.count}</td>
                            <td>
                              <span>${product.productID}</span>
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
                            <td>
                              ${sessionScope.LIST_CATEGORY.get(product.categoryID)}
                            </td>
                            <td class="product-price">
                              <input
                                class="amount"
                                type="text"
                                name="price"
                                value="${product.price}"
                                required=""
                              />
                            </td>
                            <td class="plantmore-product-quantity">
                              <input
                                value="${product.quantity}"
                                type="number"
                                name="quantity"
                                min="1"
                              />
                            </td>
                            <td>
                              <div class="product-update">
                                <input
                                  value="${product.productID}"
                                  type="hidden"
                                  name="productID"
                                />
                                <input
                                  value="${product.productName}"
                                  type="hidden"
                                  name="productName"
                                />
                                <input
                                  value="${product.image}"
                                  type="hidden"
                                  name="image"
                                />
                                <input
                                  class="button"
                                  name="action"
                                  value="Update Product"
                                  type="submit"
                                />
                              </div>
                            </td>
                          </tr>
                        </form>
                      </c:if>
                    </c:forEach>
                    <c:if test="${sessionScope.LIST_PRODUCT.size() == 0}">
                      <tr class="empty-row">
                        <td>You don't have any product</td>
                      </tr>
                    </c:if>
                  </tbody>
                </table>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Shopping cart end -->

    <!-- Add product start -->
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="mt-50">
            <div class="management-user">
              <input
                class="button"
                name="action"
                value="Management User"
                type="submit"
              />
            </div>
            <div class="add-product">
              <input
                class="button"
                name="update_cart"
                value="Add Product"
                type="submit"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Add product end -->

    <!--Pagination Start-->
    <div class="container">
      <div class="product-pagination">
        <ul>
          <c:forEach begin="1" end="${requestScope.PAGE_SIZE}" var="i">
            <li class="product-pagination__page">
              <a href="ProductController?offset=${i}">${i}</a>
            </li>
          </c:forEach>
          <li>
            <a href="#"><i class="fa fa-angle-double-right"></i></a>
          </li>
        </ul>
      </div>
    </div>
    <!--Pagination End-->
  </body>
</html>
