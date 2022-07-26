<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Direcciones: Agregar</title>
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
						<h1 class="text-center mb-5">Agregar Direccion</h1>
						<form action="/direccion/guardarDireccion" method="post">
							<div class="row mb-3">
								<label for="calle" class="col-sm-2 col-form-label">Calle</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="calle" name="calle">
								</div>
							</div>
							<div class="row mb-3">
								<label for="numero" class="col-sm-2 col-form-label">Numero</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="numero"
										name="numero">
								</div>
							</div>
							<div class="row mb-3">
								<label for="ciudad" class="col-sm-2 col-form-label">Ciudad</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="ciudad"
										name="ciudad">
								</div>
							</div>


							<div class="row mb-3">
								<label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
								<div class="col-sm-10">
									<select class="form-select" aria-label="Default select example"
										name="tipo" id="tipo">
										<c:forEach var="tipo" items="${tipos}">
											<option value="${tipo}">${tipo}</option>
										</c:forEach>
									</select>
								</div>
							</div>


							<div class="col-2 mx-auto mt-5">
								<button id="enviar"
									class="btn btn-primary text-uppercase form-control"
									type="submit">Agregar</button>
							</div>
						</form>
						<div class="col-2 mx-auto mt-4">
							<a class="btn btn-outline-secondary text-uppercase form-control"
								href="/direccion/direcciones" role="button">Descartar</a>
						</div>
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