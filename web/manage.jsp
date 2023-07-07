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
              <h1>Management User</h1>
            </div>
            <div class="breadcrumb-content breadcrumb-content-tow">
              <ul>
                <li><a href="home.jsp">Home</a></li>
                <li class="active">Management User</li>
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
      <div class="row mb-35">
        <div class="col-md-4 search-dropdown">
          <form action="MainController">
            <input
              name="searchUser"
              id="search"
              placeholder="Search"
              value="${param.search}"
              type="text"
            />
            <button type="submit" name="action" value="SearchUser">
              <i class="fa fa-search"></i>
            </button>
          </form>
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
                      <th class="user-remove">remove</th>
                      <th class="user-no">No</th>
                      <th class="user-id">User ID</th>
                      <th class="user-name">User Name</th>
                      <th class="user-role">US</th>
                      <th class="user-phone">Phone</th>
                      <th class="user-address">Address</th>
                      <th class="user-update">Update</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach
                      var="user"
                      varStatus="counter"
                      items="${sessionScope.LIST_USER}"
                    >
                      <c:if test="${user.isDeleted == false}">
                        <form action="MainController">
                          <tr>
                            <td class="user-remove">
                              <a
                                href="MainController?action=RemoveUser&userID=${user.userID}"
                                ><i class="fa fa-times"></i
                              ></a>
                            </td>
                            <td>${counter.count}</td>
                            <td>
                              <span>${user.userID}</span>
                            </td>
                            <td class="user-name">
                              <input
                                class="amount"
                                type="text"
                                name="userName"
                                value="${user.userName}"
                                required=""
                              />
                            </td>
                            <td class="user-roleID">
                              <input
                                class="amount"
                                type="text"
                                name="roleID"
                                value="${user.roleID}"
                                required=""
                              />
                            </td>
                            <td class="user-phone">
                              <input
                                class="amount"
                                type="text"
                                name="phoneNumber"
                                value="${user.phoneNumber}"
                                required=""
                              />
                            </td>

                            <td class="user-address">
                              <input
                                class="amount"
                                type="text"
                                name="address"
                                value="${user.address}"
                                required=""
                              />
                            </td>
                            <td>
                              <div class="user-update">
                                <input
                                  value="${user.userID}"
                                  type="hidden"
                                  name="userID"
                                />
                                <input
                                  class="button"
                                  name="action"
                                  value="Update User"
                                  type="submit"
                                />
                              </div>
                            </td>
                          </tr>
                        </form>
                      </c:if>
                    </c:forEach>
                    <c:if test="${sessionScope.LIST_USER.size() == 0}">
                      <tr class="empty-row">
                        <td>You don't have any user</td>
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
                  value="Management Product"
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
              <a href="UserController?offset=${i}&search=${param.search}"
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
