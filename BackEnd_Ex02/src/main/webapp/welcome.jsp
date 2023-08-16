<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Boas-Vindas</title>
    <!-- Adicione as folhas de estilo do Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
   </head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h1 class="text-center mb-4">Boas-Vindas</h1>
                <div class="alert alert-success">
                    <p>Olá, <strong>${username}</strong>! Bem-vindo ao sistema.</p>
                     <a href="LogoutServlet">Sair</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>