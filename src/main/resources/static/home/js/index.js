/*------------------------------------------------------------INICIO HEADER---------------------------------------------------- */
document.addEventListener("DOMContentLoaded", function () {
  var label_open_silebar = document.querySelector("label[for='open-silebar']");
  var label_close_silebar = document.querySelector(
    "label[for='close-silebar']"
  );

  var contenedor_silebar = document.getElementById("background-silebar");
  var silevar = document.getElementById("contenedor-silebar");

  label_open_silebar.addEventListener("click", function () {
    silevar.style.display = "block"; // Mostrar el sidebar
    setTimeout(() => {
      silevar.style.left = "0"; // Mover a la posición inicial
    }, 50); // Pequeña espera antes de mover para permitir que se muestre el sidebar primero
    contenedor_silebar.style.display = "block"; // Mostrar el fondo del sidebar
  });

  label_close_silebar.addEventListener("click", function () {
    silevar.style.left = "-300px"; // Mover a la izquierda
    setTimeout(() => {
      silevar.style.display = "none"; // Ocultar después de la animación
      contenedor_silebar.style.display = "none"; // Ocultar el fondo del sidebar
    }, 300); // Esperar la duración de la animación (0.3s)
  });
});
/*------------------------------------------------------------FIN HEADER---------------------------------------------------- */

/*------------------------------------------------------------SWIPER CODE---------------------------------------------------- */
var swiper = new Swiper(".swiper-container", {
  slidesPerView: 4,
  spaceBetween: 4,
  slidesPerGroup: 4,
  loop: true,
  autoplay: {
    delay: 3000,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
    dynamicBullets: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  breakpoints: {
    0: {
      slidesPerView: 1,
      spaceBetween: 1, // puedes ajustar el espacio entre slides para dispositivos móviles
    },
    375: {
      slidesPerView: 1,
      spaceBetween: 0,
    },
    520: {
      slidesPerView: 2,
      spaceBetween: 15,
    },
    768: {
      slidesPerView: 3,
      spaceBetween: 20,
    },
    1000: {
      slidesPerView: 4,
      spaceBetween: 20,
    },
  },
});
/*------------------------------------------------------------FIN SWIPER------------------------------------------------------- */

/*------------------------------------------------------------Slider Main------------------------------------------------------- */
var swiper = new Swiper(".mySwiper", {
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});
/*------------------------------------------------------------Cierre de Slide Main------------------------------------------------------- */
