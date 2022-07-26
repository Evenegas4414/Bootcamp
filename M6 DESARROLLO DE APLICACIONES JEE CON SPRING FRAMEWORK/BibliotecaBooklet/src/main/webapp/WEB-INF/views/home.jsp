<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Booklet - Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>


	<nav class="navbar bg-light">
		<div class="container-fluid">
			<a class="navbar-brand">Booklet</a>
			<form class="d-flex" role="search" method="post" action="buscar">
				<a href="agregarForm" class="btn m-2 btn-primary">Agregar</a> <input
					class="form-control me-2" type="text" placeholder="Titulo o autor"
					name="textoBuscado" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
		</div>
	</nav>

	<section class="container p-3">
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</section>

	<section class="container">
		<div class="card">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Titulo</th>
						<th scope="col">Autor</th>
						<th scope="col">Imprenta</th>
						<th scope="col">Año</th>
						<th scope="col">Disponibilidad</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${VO.libros}" var="libro">
						<tr>
							<td>${libro.getTitulo()}</td>
							<td>${libro.getAutor()}</td>
							<td>${libro.getImprenta()}</td>
							<td>${libro.getAnio()}</td>
							<td>${libro.getDisponibilidad() == 1 ? 'Si' : 'No'}</td>

							<td><a href="editarForm?id=${libro.getIdLibro()}"
								class="btn btn-warning btn-sm">Editar</a> <a
								href="eliminar?id=${libro.getIdLibro()}"
								class="btn btn-danger btn-sm">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>