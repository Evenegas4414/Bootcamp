<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Logistiqal - Home</title>
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
						<h1 class="text-center mb-5">Lista de Productos</h1>
						<div class="my-2">
							<a class="btn btn-primary text-uppercase fw-bold mx-1"
								href="/agregarForm">Agregar</a>
						</div>

						<table class="table table-hover table-bordered text-center">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">CODIGO</th>
									<th scope="col">NOMBRE</th>
									<th scope="col">PRECIO</th>
									<th scope="col">STOCK</th>
									<th scope="col">OPCIONES</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="producto" items="${VO.productos}">
									<tr>
										<th scope="row">${producto.idProducto}</th>
										<td>${producto.codigo}</td>
										<td>${producto.nombre}</td>
										<td><fmt:formatNumber value="${producto.precio}"
												type="currency" maxFractionDigits="0" currencySymbol="$" /></td>
										<td>${producto.stock}</td>
										<td><a
											class="btn btn-sm btn-warning text-uppercase fw-bold mx-1"
											href="/modificarForm?idProducto=${producto.idProducto}">MODIFICAR</a>
											<a class="btn btn-sm btn-danger text-uppercase fw-bold mx-1"
											href="/eliminarForm?idProducto=${producto.idProducto}">ELIMINAR</a>
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