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

    <!-- Checkout start -->

    <div class="checkout-area mb-80">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-12">
            <form action="#">
              <div class="checkbox-form">
                <h3>Billing Details</h3>
                <c:if test="${sessionScope.LOGIN_USER != null}">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="checkout-form-list">
                        <label>Full Name <span class="required">*</span></label>
                        <input
                          placeholder=""
                          type="text"
                          value="${sessionScope.LOGIN_USER.userName}"
                        />
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="checkout-form-list">
                        <label>Phone <span class="required">*</span></label>
                        <input
                          type="text"
                          value="${sessionScope.LOGIN_USER.getPhoneNumber()}"
                        />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="checkout-form-list">
                        <label>Company Name</label>
                        <input placeholder="" type="text" />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="checkout-form-list">
                        <label>Address <span class="required">*</span></label>
                        <input
                          placeholder="Street address"
                          type="text"
                          value="${sessionScope.LOGIN_USER.address}"
                        />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="checkout-form-list">
                        <label>Town / City</label>
                        <input type="text" />
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="checkout-form-list">
                        <label
                          >State / County <span class="required">*</span></label
                        >
                        <input placeholder="Vietnam" type="text" />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="checkout-form-list">
                        <label
                          >Email Address <span class="required">*</span></label
                        >
                        <input
                          placeholder=""
                          type="email"
                          value="${sessionScope.LOGIN_ACCOUNT.getEmail()}"
                        />
                      </div>
                    </div>
                  </div>
                </c:if>
              </div>
            </form>
          </div>
          <div class="col-lg-6 col-12">
            <div class="your-order">
              <h3>Your order</h3>
              <div class="your-order-table table-responsive">
                <table class="table">
                  <thead>
                    <tr>
                      <th class="cart-product-name">Product</th>
                      <th class="cart-product-total">Total</th>
                    </tr>
                  </thead>
                  <tbody>
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
                      <tr class="cart_item">
                        <td class="cart-product-name">
                          ${product.productName}<strong
                            class="product-quantity"
                          >
                            x ${product.quantity}</strong
                          >
                        </td>
                        <td class="cart-product-total">
                          <span class="amount"
                            >$${product.price*product.quantity}</span
                          >
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                  <tfoot>
                    <tr class="cart-subtotal">
                      <th>Cart Subtotal</th>
                      <td><span class="amount">$${pageScope.total}</span></td>
                    </tr>
                    <tr class="order-total">
                      <th>Order Total</th>
                      <td>
                        <strong
                          ><span class="amount"
                            >$${pageScope.total}</span
                          ></strong
                        >
                      </td>
                    </tr>
                  </tfoot>
                </table>
              </div>
              <div class="payment-method">
                <div class="payment-accordion">
                  <div id="accordion">
                    <div class="card">
                      <div class="card-header" id="#payment-1">
                        <h5 class="panel-title">
                          <a
                            class=""
                            data-bs-toggle="collapse"
                            data-bs-target="#collapseOne"
                            aria-expanded="true"
                            aria-controls="collapseOne"
                          >
                            Direct Bank Transfer.
                          </a>
                        </h5>
                      </div>
                      <div
                        id="collapseOne"
                        class="collapse show"
                        data-bs-parent="#accordion"
                      >
                        <div class="card-body">
                          <p>
                            Make your payment directly into our bank account.
                            Please use your Order ID as the payment reference.
                            Your order won't be shipped until the funds have
                            cleared in our account.
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-header" id="#payment-2">
                        <h5 class="panel-title">
                          <a
                            class="collapsed"
                            data-bs-toggle="collapse"
                            data-bs-target="#collapseTwo"
                            aria-expanded="false"
                            aria-controls="collapseTwo"
                          >
                            Cheque Payment
                          </a>
                        </h5>
                      </div>
                      <div
                        id="collapseTwo"
                        class="collapse"
                        data-bs-parent="#accordion"
                      >
                        <div class="card-body">
                          <p>
                            Make your payment directly into our bank account.
                            Please use your Order ID as the payment reference.
                            Your order won't be shipped until the funds have
                            cleared in our account.
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="card">
                      <div class="card-header" id="#payment-3">
                        <h5 class="panel-title">
                          <a
                            class="collapsed"
                            data-bs-toggle="collapse"
                            data-bs-target="#collapseThree"
                            aria-expanded="false"
                            aria-controls="collapseThree"
                          >
                            PayPal
                          </a>
                        </h5>
                      </div>
                      <div
                        id="collapseThree"
                        class="collapse"
                        data-bs-parent="#accordion"
                      >
                        <div class="card-body">
                          <p>
                            Make your payment directly into our bank account.
                            Please use your Order ID as the payment reference.
                            Your order won't be shipped until the funds have
                            cleared in our account.
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="order-button-payment">
                    <form action="MainController">
                      <input value="Place order" type="submit" name="action" />
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Checkout end -->
  </body>
</html>
