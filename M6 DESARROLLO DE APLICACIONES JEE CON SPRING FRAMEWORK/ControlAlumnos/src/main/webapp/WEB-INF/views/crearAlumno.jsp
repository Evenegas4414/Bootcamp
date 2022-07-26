<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alumnos: Agregar</title>
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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/alumno/alumnos">Alumnos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/direccion/direcciones">Direcciones</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Agregar Alumno</h1>
						<form action="/alumno/guardarAlumno" method="post">
							<div class="row mb-3">
								<label for="rut" class="col-sm-2 col-form-label">Rut</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="rut"
										name="rut">
								</div>
							</div>
							<div class="row mb-3">
								<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="nombre"
										name="nombre">
								</div>
							</div>
							<div class="row mb-3">
								<label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="apellido"
										name="apellido">
								</div>
							</div>
							<div class="row mb-3">
								<label for="email" class="col-sm-2 col-form-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="email"
										name="email">
								</div>
							</div>
							<div class="row mb-3">
								<label for="edad" class="col-sm-2 col-form-label">Edad</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="edad"
										name="edad">
								</div>
							</div>
							<div class="row mb-3">
								<label for="fechaIngreso" class="col-sm-2 col-form-label">Fecha Ingreso</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="fechaIngreso"
										name="fechaIngreso" value="mm/dd/yyyy">
								</div>
							</div>
							<div class="row mb-3">
								<label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
								<div class="col-sm-10">
									<select class="form-select" aria-label="Default select example"
										name="direccion" id="direccion">
										<c:forEach var="direccion" items="${listaDirecciones}">
											<option value="${direccion.idDireccion}">${direccion}</option>
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
							href="/alumno/alumnos" role="button">Descartar</a>							
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