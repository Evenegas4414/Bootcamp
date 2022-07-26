<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Eliminar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">

	<nav class="navbar navbar-dark navbar-expand-lg bg-danger">
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
					<a class="nav-link" href="listar">Listar</a> 
					<a class="nav-link"	href="agregar">Agregar</a>
				</div>
			</div>
		</div>
	</nav>

	<section class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Eliminar Producto</h1>
						<table class="table table-hover">
							<tr>
								<th>Id</th>
								<td>${producto.idProducto}</td>
							</tr>
							<tr>
								<th>Nombre</th>
								<td>${producto.nombreProducto}</td>
							</tr>
							<tr>
								<th>Precio</th>
								<td>${producto.precioProducto}</td>
							</tr>
							<tr>
								<th>Descripción</th>
								<td>${producto.descripcionProducto}</td>
							</tr>
							<tr>
								<th>Id Categoria</th>
								<td>${producto.idCategoria}</td>
							</tr>
						</table>
					</div>
					<form action="" method="post">
						<input type="hidden" id="idProducto" name="idProducto" value="${producto.idProducto}">
						<div class="col-6 mx-auto">
							<button
								class="btn btn-danger text-uppercase form-control">Eliminar</button>
						</div>
					</form>
					<div class="col-6 mx-auto my-3">
						<a class="btn btn-outline-secondary text-uppercase form-control" 
							href="listar" role="button">Descartar</a>	
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