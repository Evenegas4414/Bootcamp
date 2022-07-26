<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Generador de Factura</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<header class="container-fluid my-2 ">
		<div class="row">
			<h1 class="col-6 text-center">Desafio Latam</h1>
			<div class="col-6 text-end">
				<p class="fw-bold">Generado Factura</p>
				<p class="fw-bold">Competition Part Ltda.</p>
				<p>Año 2019 Abri JC.</p>
			</div>
		</div>
	</header>

	<hr>

	<section id="datosPersonales" class="container-fluid my-2">
		<form id="datosFormulario" method="post">
			<div class="row">
				<div class="col">
					<div class="mb-3">
						<label for="nombreCompleto" class="form-label">Nombre
							Completo</label> <input type="text" class="form-control"
							id="nombreCompleto" name="nombreCompleto">
					</div>
					<div class="mb-3">
						<label for="direccion" class="form-label">Dirección</label> <input
							type="text" class="form-control" id="direccion" name="direccion">
					</div>
				</div>
				<div class="col">
					<div class="mb-3">
						<label for="empresa" class="form-label">Empresa</label> <input
							type="text" class="form-control" id="empresa" name="empresa">
					</div>
					<div class="mb-3">
						<label for="ciudad" class="form-label">Ciudad</label> <input
							type="text" class="form-control" id="ciudad" name="ciudad">
					</div>
				</div>
				<div class="col">
					<div class="mb-3">
						<label for="rut" class="form-label">Rut</label> <input type="text"
							class="form-control" id="rut" name="rut">
					</div>
					<div class="mb-3">
						<label for="pais" class="form-label">País</label> <input
							type="text" class="form-control" id="pais" name="pais">
					</div>
				</div>
			</div>

			<section id="tablaDetalles" class="container-fluid my-1 ">
				<div>
					<table class="table table-dark table-striped table-hover">
						<thead>
							<tr>
								<th scope="col">ITEM</th>
								<th scope="col">DESCRIPCIÓN</th>
								<th scope="col">VALOR UNIDAD</th>
								<th scope="col">CANTIDAD</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${listaProductos}">
								<tr>
									<td>${p.item}</td>
									<td>${p.descripcion}</td>
									<td><fmt:formatNumber value="${p.valor}" type="currency"
											maxFractionDigits="0" currencySymbol="$" /></td>
									<td><input type="text" id="cantidad" name="cantidad"
										value="0"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div id="botones"
					class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button class="btn btn-success" type="submit">Genera
						Factura</button>
					<button class="btn btn-secondary" type="reset">Limpiar</button>
				</div>
			</section>

		</form>
	</section>

</body>
</html>