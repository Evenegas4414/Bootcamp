<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mantenedor Cursos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>


<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Mantenedor Cursos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="PreListarInscripciones">Listado</a></li>
					<li class="nav-item"><a class="nav-link" href="PreInscripcion">Inscribir</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="container">
		<form id="formularioInscripcion" action="PosInscripcion" method="get">
		
			<div class="form-group">
				<label for="nombre">Nombre:</label> 
				<input type="text" class="form-control" id="nombre" name="nombre">
			</div>
			
			<div class="form-group">
				<label for="telefono">Telefono:</label> 
				<input type="text" class="form-control" id="telefono" name="telefono">
			</div>
			<br>
			
			<div class="form-group">
				<label for="cursos">Cursos:</label> 
				<select name="idCurso">
					<c:forEach var="c" items="${listaCursos}">
						<option value="${c.idCurso}">${c.descripcion}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			
			<div class="form-group">
				<label for="formasPago">Formas de Pago:</label> 
				<select	name="idFormaPago">
					<c:forEach var="fp" items="${listaFormasPago}">
						<option value="${fp.idFormaPago}">${fp.descripcion}</option>
					</c:forEach>					
				</select>
			</div>
			<br>
			
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</section>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>