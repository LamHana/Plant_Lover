<%-- Document : login Created on : Jun 13, 2023, 12:25:28 AM Author : Hana --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center mb-35 mt-100">
            <h2>Welcome to Plant Lover</h2>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay4.png" alt="" />
        </div>
      </div>
      <div class="col-md-4">
        <div class="form-product">
          <form action="MainController" method="POST">
            <div class="checkbox-form">
              <div class="row">
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>User Name<span class="required">*</span></label>
                    <input type="text" name="email" required="" />
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="checkout-form-list">
                    <label>Password<span class="required">*</span></label>
                    <input type="password" name="password" required="" />
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="message-error">
                  <p>${requestScope.ERROR}</p>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 mb-35">
                <div class="add-button">
                  <input
                    type="submit"
                    name="action"
                    value="Login"
                    class="add-product-button"
                  />
                </div>
              </div>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-md-12 mb-35">
                  <div class="or">or</div>
                </div>
              </div>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-md-12 mb-35">
                  <div class="login-google">
                    <div class="google-btn">
                      <div class="google-icon-wrapper">
                        <img
                          class="google-icon"
                          src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"
                        />
                      </div>
                      <a
                        href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:8084/PLANT_LOVER/LoginGoogleController&response_type=code
    &client_id=385356228676-m07i7cq0e5vhor5rh33inhdu65j1e0iq.apps.googleusercontent.com&approval_prompt=force"
                        class="btn-text"
                        >Sign in with google</a
                      >
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="container">
              <div class="row justify-content-between align-items-center">
                <div class="col-md-6">Don't have any account?</div>
                <div class="col-md-4">
                  <div class="register-button btn--primary">
                    <a href="MainController?action=RegisterPage"
                      >Create an account</a
                    >
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="col-md-4">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay2.png" alt="" />
        </div>
      </div>
    </div>
    <!-- Input your information:
        <form action="MainController" method="POST">
            User ID<input type="text" name="email" required=""/> </br>
            Password<input type="password" name="password" required=""/> </br>
            <input type="submit" name="action" value="Login"/> </br>
            <a href="MainController?action=RegisterPage"/> Register </br>
            <input type="reset" value="Reset"/> </br>
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8084/LoginGoogleController&response_type=code
           &client_id=385356228676-m07i7cq0e5vhor5rh33inhdu65j1e0iq.apps.googleusercontent.com&approval_prompt=force">Login with Google</a> -->
    <!--<a href="MainController?action=CreatePage">Create new user</a>-->
    <% String error = (String) request.getAttribute("ERROR"); if (error == null)
    { error = ""; } %> <%= error%>
  </body>
</html>
