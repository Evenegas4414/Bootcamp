<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Agregar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">

	<nav class="navbar navbar-dark navbar-expand-lg bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="listar">PDL inc.</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" href="listar">Listar</a> <a
						class="nav-link active" aria-current="page" href="agregar">Agregar</a>
				</div>
			</div>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Agregar Producto</h1>
						<form action="" method="post">
							<div class="row mb-3">
								<label for="nombreProducto" class="col-sm-2 col-form-label">Nombre</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="nombreProducto"
										name="nombreProducto">
								</div>
							</div>
							<div class="row mb-3">
								<label for="precioProducto" class="col-sm-2 col-form-label">Precio</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="precioProducto"
										name="precioProducto">
								</div>
							</div>
							<div class="row mb-3">
								<label for="descripcionProducto" class="col-sm-2 col-form-label">Descripcion</label>
								<div class="col-sm-10">
									<textarea class="form-control" id="descripcionProducto"
										rows="2" name="descripcionProducto"></textarea>
								</div>
							</div>
							<fieldset class="row mb-3">
								<label for="idCategoria" class="col-sm-2 col-form-label">Categoria</label>
								<div class="col-sm-10">
									<select class="form-select" aria-label="lista de categorias"
										id="idCategoria" name="idCategoria">
										<c:forEach var="c" items="${listaCategorias}">
											<option value="${c.idCategoria}">${c.nombreCategoria}</option>
										</c:forEach>
									</select>
								</div>
							</fieldset>
							<div class="col-2 mx-auto mt-5">
								<button id="enviar"
									class="btn btn-success text-uppercase form-control"
									type="submit">Agregar</button>
							</div>
						</form>
						<div class="col-2 mx-auto mt-4">
							<a class="btn btn-outline-secondary text-uppercase form-control" 
							href="listar" role="button">Descartar</a>							
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