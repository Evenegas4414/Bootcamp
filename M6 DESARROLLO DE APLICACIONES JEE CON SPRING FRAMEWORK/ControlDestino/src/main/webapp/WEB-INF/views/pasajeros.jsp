<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pasajeros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">ControlDestinos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/pasajero/pasajeros">Pasajeros</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/destino/destinos">Destinos</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Lista de Pasajeros</h1>
						<div class="my-2">
							<a class="btn btn-primary text-uppercase fw-bold mx-1"
								href="/pasajero/crearPasajero">Agregar</a>
						</div>

						<table class="table table-hover table-bordered text-center">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">RUT</th>
									<th scope="col">NOMBRE</th>
									<th scope="col">APELLIDO</th>
									<th scope="col">EDAD</th>
									<th scope="col">CIUDAD NATAL</th>
									<th scope="col">DESTINOS</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pasajero" items="${listaPasajeros}">
									<tr>
										<th scope="row">${pasajero.idPasajero}</th>
										<td>${pasajero.rut}</td>
										<td>${pasajero.nombre}</td>
										<td>${pasajero.apellido}</td>
										<td>${pasajero.edad}</td>
										<td>${pasajero.ciudadNatal}</td>
										<td><c:forEach var="destino" items="${pasajero.destinos}">
											${destino}<br>
										</c:forEach></td>
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