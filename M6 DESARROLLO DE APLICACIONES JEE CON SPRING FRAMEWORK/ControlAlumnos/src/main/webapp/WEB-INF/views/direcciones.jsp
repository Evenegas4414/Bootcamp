<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Direcciones</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">ControlAlumnos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/alumno/alumnos">Alumnos</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/direccion/direcciones">Direcciones</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Lista de Direcciones</h1>
						<div class="my-2">
							<a class="btn btn-primary text-uppercase fw-bold mx-1"
								href="/direccion/crearDireccion">Agregar</a>
						</div>

						<table class="table table-hover table-bordered text-center">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">CALLE</th>
									<th scope="col">NUMERO</th>
									<th scope="col">CIUDAD</th>
									<th scope="col">TIPO</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="direccion" items="${listaDirecciones}">
									<tr>
										<th scope="row">${direccion.idDireccion}</th>
										<td>${direccion.calle}</td>
										<td>${direccion.numero}</td>
										<td>${direccion.ciudad}</td>
										<td>${direccion.tipo}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>