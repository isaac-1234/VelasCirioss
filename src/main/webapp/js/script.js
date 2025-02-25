document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert("Inicio de sesión exitoso");
    window.location.href = "dashboard.html"; // Redirigir a otra página
});

