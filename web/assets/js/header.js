const transitionNavBar = () => {
  var navbar = document.getElementById("header");
  if (window.scrollY > 100) {
    navbar.classList.add("scroll-active");
  } else {
    navbar.classList.remove("scroll-active");
  }
};
window.addEventListener("scroll", transitionNavBar);
