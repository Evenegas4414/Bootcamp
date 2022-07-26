<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Booklet - Editar</title>
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
				<input class="form-control me-2" type="text"
					placeholder="Titulo o autor" name="textoBuscado"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
		</div>
	</nav>

	<section class="container p-2">
		<div class="card">
			<form action="editar" method="post">
				<input type="hidden" name="idLibro" value="${VO.getIdLibro()}" />
				<table>

					<tr>
						<td class="p-2"><label for="anho">Año:</label></td>
						<td><input class="form-control" type="number" name="anio"
							placeholder="Año" value="${VO.getAnio()}" /></td>
					</tr>
					<tr>
						<td class="p-2"><label for="titulo">Titulo:</label></td>
						<td><input class="form-control" type="text"
							placeholder="Titulo" name="titulo" value="${VO.getTitulo()}" /></td>
					</tr>
					<tr>
						<td class="p-2"><label for="autor">Autor:</label></td>
						<td><input class="form-control" type="text"
							placeholder="Autor" name="autor" value="${VO.getAutor()}" /></td>
					</tr>

					<tr>
						<td class="p-2"><label for="imprenta">Imprenta:</label></td>
						<td><input class="form-control" type="text"
							placeholder="Imprenta" name="imprenta"
							value="${VO.getImprenta()}" /></td>
					</tr>

					<tr>
						<td class="p-2"></td>
						<td><c:if test="${VO.getDisponibilidad() == false}">
								<input class="form-check-input" type="checkbox"
									id="disponibilidad" name="disponibilidad">
								<label class="form-check-label" for="disponibilidad">
									Disponible </label>
							</c:if> <c:if test="${VO.getDisponibilidad() == true}">
								<input class="form-check-input" type="checkbox" checked="true"
									id="disponibilidad" name="disponibilidad">
								<label class="form-check-label" for="disponibilidad">
									Disponible </label>
							</c:if>
					</tr>
					<tr>
						<td class="p-2"><a class="btn m-2 btn-secondary form-control"
							href="home" role="button">Descartar</a></td>
						<td class="p-2"><input type="submit"
							class="btn m-2 btn-warning form-control" value="Guardar" /></td>
					</tr>
				</table>
			</form>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>