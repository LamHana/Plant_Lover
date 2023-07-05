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
                                <li><a href="index.html">Home</a></li>
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
                                        </tr>
                                    </thead>
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
                                        <tbody>
                                        <form action="MainController">
                                            <tr>
                                                <td class="plantmore-product-remove">
                                                    <a href="#"><i class="fa fa-times"></i></a>
                                                </td>
                                                <td class="plantmore-product-thumbnail">
                                                    <a href="#"
                                                       ><img src="${product.image}" alt=""
                                                          /></a>
                                                </td>
                                                <td class="plantmore-product-name">
                                                    <a href="#">${product.productName}</a>
                                                </td>
                                                <td class="plantmore-product-price">
                                                    <span class="amount">$${product.price}</span>
                                                </td>
                                                <td class="plantmore-product-quantity">
                                                    <input value="1" type="number" />
                                                </td>
                                                <td class="product-subtotal">
                                                    <span class="amount">$${product.price*product.quantity}</span>
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="coupon-all">
                                        <div class="coupon">
                                            <input
                                                id="coupon_code"
                                                class="input-text"
                                                name="coupon_code"
                                                value=""
                                                placeholder="Coupon code"
                                                type="text"
                                                />
                                            <input
                                                class="button"
                                                name="apply_coupon"
                                                value="Apply coupon"
                                                type="submit"
                                                />
                                        </div>
                                        <div class="coupon2">
                                            <input
                                                class="button"
                                                name="update_cart"
                                                value="Update cart"
                                                type="submit"
                                                />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5 ml-auto">
                                    <div class="cart-page-total">
                                        <h2>Cart totals</h2>
                                        <ul>
                                            <li>Subtotal <span>${pageScope.total}$</span></li>
                                            <li>Total <span>${pageScope.total}$</span></li>
                                        </ul>
                                        <a href="#">Proceed to checkout</a>
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
