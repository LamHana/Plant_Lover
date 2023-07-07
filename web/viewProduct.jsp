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
    <!-- Header -->
    <c:import url="./header.jsp" />
    <!-- End Header -->
    <!-- breadcrumb two start -->
    <div class="breadcrumb-tow mb-100">
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

    <c:if test="${requestScope.MESSAGE_ADD != null}">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h3 class="message-success">Add Successful</h3>
          </div>
        </div>
      </div>
    </c:if>
    <!-- Search start -->
    <div class="container">
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
            <button type="submit" name="action" value="SearchProduct">
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
    </div>
    <!-- Search end -->
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
              <form action="MainController">
                <input
                  class="button"
                  name="action"
                  value="Management User"
                  type="submit"
                />
              </form>
            </div>
            <div class="add-product">
              <form action="MainController">
                <input
                  class="button"
                  name="action"
                  value="Add Product"
                  type="submit"
                />
              </form>
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
              <a href="ProductController?offset=${i}&search=${param.search}"
                >${i}</a
              >
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
