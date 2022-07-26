<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Logistiqal - Agregar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">


	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand">Logistiqal</a>
			<form class="d-flex" role="search" method="post" action="buscar">
				<input class="form-control me-2" type="text"
					placeholder="Producto..." name="textoBuscado" aria-label="Search">
				<button class="btn btn-secondary" type="submit">Buscar</button>
			</form>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Agregar Producto</h1>
						<form action="/agregar" method="post">
							<div class="row mb-3">
								<label for="codigo" class="col-sm-2 col-form-label">Codigo</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="codigo"
										name="codigo">
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
								<label for="precio" class="col-sm-2 col-form-label">Precio</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="precio"
										name="precio">
								</div>
							</div>
							<div class="row mb-3">
								<label for="stock" class="col-sm-2 col-form-label">Stock</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="stock"
										name="stock">
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
							href="home" role="button">Descartar</a>							
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