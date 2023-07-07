<%-- Document : register Created on : Jun 14, 2023, 2:18:51 PM Author : Hana
--%> <%@page import="model.UserGoogleDTO"%> <%@page import="model.AccountDTO"%>
<%@page import="model.UserError"%> <%@page contentType="text/html"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
    <!-- <% UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
            UserGoogleDTO accountGoogle = (UserGoogleDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (accountGoogle == null) {
                accountGoogle = new UserGoogleDTO();
            } %> -->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center mb-35 mt-100">
            <h2>Create your account</h2>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-3">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay4.png" alt="" />
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-product">
          <form action="MainController" method="POST">
            <div class="checkbox-form">
              <div class="row">
                <c:if test="${sessionScope.LOGIN_ACCOUNT.getEmail() != null}">
                  <div class="col-md-6">
                    <div class="checkout-form-list">
                      <label>Email<span class="required">*</span></label>
                      <input
                        type="text"
                        name="email"
                        required=""
                        value="${sessionScope.LOGIN_ACCOUNT.getEmail()}"
                        readonly=""
                      />
                    </div>
                  </div>
                </c:if>
                <c:if test="${sessionScope.LOGIN_ACCOUNT.getEmail() == null}">
                  <div class="col-md-6">
                    <div class="checkout-form-list">
                      <label>Email<span class="required">*</span></label>
                      <input type="text" name="email" required="" />
                    </div>
                  </div>
                </c:if>
                <c:if test="${sessionScope.LOGIN_ACCOUNT.getName() != null}">
                  <div class="col-md-6">
                    <div class="checkout-form-list">
                      <label>Full Name<span class="required">*</span></label>
                      <input
                        type="text"
                        name="fullname"
                        required=""
                        value="${sessionScope.LOGIN_ACCOUNT.getName()}"
                        readonly=""
                      />
                    </div>
                  </div>
                </c:if>
                <c:if test="${sessionScope.LOGIN_ACCOUNT.getName() == null}">
                  <div class="col-md-6">
                    <div class="checkout-form-list">
                      <label>Full Name<span class="required">*</span></label>
                      <input type="text" name="fullname" required="" />
                    </div>
                  </div>
                </c:if>
                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Phone<span class="required">*</span></label>
                    <input type="text" name="phoneNumber" required="" />
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="checkout-form-list">
                    <label>Role<span class="required">*</span></label>
                    <input type="text" name="roleID" value="US" readonly="" />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Address<span class="required">*</span></label>
                    <input type="text" name="address" required="" />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Password<span class="required">*</span></label>
                    <input type="password" name="password" required="" />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Confirm<span class="required">*</span></label>
                    <input type="password" name="confirm" required="" />
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="message-error">
                  <p>${requestScope.USER_ERROR.getEmailError()}</p>
                  <p>${requestScope.USER_ERROR.getFullNameError()}</p>
                  <p>${requestScope.USER_ERROR.getPhoneNumberError()}</p>
                  <p>${requestScope.USER_ERROR.getConfirmError()}</p>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 mb-35">
                <div class="add-button">
                  <input
                    type="submit"
                    name="action"
                    value="Register"
                    class="add-product-button"
                  />
                </div>
              </div>
            </div>
            ${requestScope.USER_ERROR.getError()}
          </form>
        </div>
      </div>
      <div class="col-md-3">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay.png" alt="" />
        </div>
      </div>
    </div>
  </body>
</html>
