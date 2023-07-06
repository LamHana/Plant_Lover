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

    <!-- Success content start -->
    <div class="row">
      <div class="col-md-4">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay1.png" alt="" />
        </div>
      </div>
      <div class="col-md-4">
        <div class="section-title text-center mb-35">
          <h2>Thank you</h2>
        </div>
        <div class="success-content__message text-center">
          We're grateful for your trust in us and can't wait for your new green
          companions to bring joy and beauty to your space
        </div>
        <div class="success-content__image">
          <img src="./assets/img/single-image.png" alt="" />
        </div>
      </div>
      <div class="col-md-4">
        <div class="success-content__image">
          <img src="./assets/img/pattern-overlay3.png" alt="" />
        </div>
      </div>
    </div>
    <!-- Success content end -->
  </body>
</html>
