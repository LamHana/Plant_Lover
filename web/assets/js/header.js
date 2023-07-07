const transitionNavBar = () => {
  var navbar = document.getElementById("header");
  if (window.scrollY > 100) {
    navbar.classList.add("scroll-active");
  } else {
    navbar.classList.remove("scroll-active");
  }
};
window.addEventListener("scroll", transitionNavBar);

var cartDropdown = document.querySelector(".cart-dropdown");
var miniCart = document.querySelector(".mini-cart");
const dropdownCartShow = () => {
  console.log("2");
  var op = 0.5; // initial opacity
  cartDropdown.classList.remove("hidden");
  cartDropdown.style.cssText =
    "padding-top: 30px; margin-top: 0px; padding-bottom: 15px; margin-bottom: 0px; ";
};

const dropdownCart = () => {
  console.log("1");
  cartDropdown.classList.add("hidden");
  cartDropdown.style.cssText =
    "padding-top: 30px; margin-top: 0px; padding-bottom: 15px; margin-bottom: 0px; display:none";
};

miniCart.addEventListener("mouseover", dropdownCartShow);
cartDropdown.addEventListener("mouseout", dropdownCart);

jQuery(function ($) {
  $("#mirror").text($("#alice").val());

  $("#alice").on("input", function () {
    $("#mirror").text($("#alice").val());
  });
});

$(document).ready(function () {
  $(".toast").toast({
    animation: true,
    autohide: true,
    delay: 5000,
  });
});

window.onbeforeunload = function () {
  // Show the toast
  $(".toast").toast("show");
};
