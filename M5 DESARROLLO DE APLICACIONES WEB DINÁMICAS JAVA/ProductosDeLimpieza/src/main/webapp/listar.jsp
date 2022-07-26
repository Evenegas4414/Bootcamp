<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">

	<nav class="navbar navbar-dark navbar-expand-lg bg-primary">
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
					<a class="nav-link active" aria-current="page" href="listar">Listar</a>
					<a class="nav-link" href="agregar">Agregar</a>
				</div>
			</div>
		</div>
	</nav>

	<section class="mx-5">
		<div class="row">
			<div class="mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-5">Lista de Productos</h1>
						<table class="table table-hover table-bordered text-center">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">NOMBRE</th>
									<th scope="col">PRECIO</th>
									<th scope="col">DESCRIPCION</th>
									<th scope="col">CATEGORIA</th>
									<th scope="col">OPCIONES</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="p" items="${listaProductoCategoria}">
									<tr>
										<th scope="row">${p.producto.idProducto}</th>
										<td>${p.producto.nombreProducto}</td>
										<td><fmt:formatNumber
												value="${p.producto.precioProducto}" type="currency"
												maxFractionDigits="0" currencySymbol="$" /></td>
										<td>${p.producto.descripcionProducto}</td>
										<td>${p.categoria.nombreCategoria}</td>
										<td>
											<a
											class="btn btn-sm btn-outline-warning text-uppercase fw-bold mx-1"
											href="modificar?idProducto=${p.producto.idProducto}">MODIFICAR</a>
											<a
											class="btn btn-sm btn-outline-danger text-uppercase fw-bold mx-1"
											href="eliminar?idProducto=${p.producto.idProducto}">ELIMINAR</a>
										</td>
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