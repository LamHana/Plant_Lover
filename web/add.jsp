<%-- Document : add Created on : Jul 2, 2023, 4:20:25 PM Author : Hana --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <
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
    <!-- Breadcrumb two start -->
    <div class="breadcrumb-tow mb-120">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="breadcrumb-title">
              <h1>Checkout</h1>
            </div>
            <div class="breadcrumb-content breadcrumb-content-tow">
              <ul>
                <li><a href="home.jsp">Home</a></li>
                <li class="active">Checkout</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Breadcrumb two end -->

    <!-- Form add product start -->
    <div class="row">
      <div class="col-md-3">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay4.png" alt="" />
        </div>
      </div>
      <div class="col-md-6">
        <div class="section-title text-center mb-35">
          <h2>Add New Product</h2>
        </div>
        <div class="form-product">
          <form action="MainController">
            <div class="checkbox-form">
              <div class="row">
                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Product Name <span class="required">*</span></label>
                    <input type="text" name="productName" required="" />
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Price <span class="required">*</span></label>
                    <input type="text" name="price" required="" min="1" />
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Category<span class="required">*</span></label>
                    <select
                      name="categoryName"
                      class="form-select"
                      aria-label="Default select example"
                    >
                      <option selected>Category Name</option>
                      <c:forEach
                        var="categoryKey"
                        varStatus="counter"
                        items="${sessionScope.LIST_CATEGORY.keySet()}"
                      >
                        <option
                          value="${sessionScope.LIST_CATEGORY.get(categoryKey)}"
                        >
                          ${sessionScope.LIST_CATEGORY.get(categoryKey)}
                        </option>
                        >
                      </c:forEach>
                    </select>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Quantity<span class="required">*</span></label>
                    <input
                      type="number"
                      name="quantity"
                      required=""
                      min=""
                      class="add-price"
                    />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Description <span class="required">*</span></label>
                    <input type="text" name="description" required="" />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Image <span class="required">*</span></label>
                    <input type="text" name="image" required="" />
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 mb-35">
                <div class="add-button">
                  <input
                    type="submit"
                    name="action"
                    value="Add"
                    class="add-product-button"
                  />
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="col-md-3">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay2.png" alt="" />
        </div>
      </div>
    </div>
    <!-- Form add product end -->
  </body>
</html>
