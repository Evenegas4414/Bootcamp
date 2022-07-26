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
	<section id="datosFactura" class="container-fluid my-2 ">
		<div class="row">
			<div class="col-6 text-start">
				<p class="fw-bold">Información de cliente</p>
				<p>${param.nombreCompleto}</p>
				<p>${param.empresa}</p>
				<p>${param.ciudad},${param.pais}</p>
				<p>${param.direccion}</p>
			</div>
			<div class="col-6 text-end">
				<p class="fw-bold">Detalles de pago</p>
				<p>NUM FACTURA: 213123</p>
				<p>ID FACTURA: 4545454</p>
				<p>TIPO PAGO: Dinero</p>
				<p>EMPRESA: Importadora</p>
			</div>
		</div>
	</section>
	<section id="tablaValoresTotales" class="container-fluid my-2 ">
		<table class="table table-dark table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">ITEM</th>
					<th scope="col">DESCRIPCIÓN</th>
					<th scope="col">VALOR UNIDAD</th>
					<th scope="col">CANTIDAD</th>
					<th scope="col">VALOR TOTAL</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaItems}">

					<tr>
						<td>${p.producto.item}</td>
						<td>${p.producto.descripcion}</td>

						<td><fmt:formatNumber value="${p.producto.valor}"
								type="currency" maxFractionDigits="0" currencySymbol="$" /></td>
						<td>${p.cantidad}</td>
						<td><fmt:formatNumber
								value="${p.cantidad * p.producto.valor}" type="currency"
								maxFractionDigits="0" currencySymbol="$" /></td>
					</tr>
					<c:set var="total"
						value="${total + (p.cantidad * p.producto.valor)}"></c:set>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<section class="d-flex flex-row-reverse bg-dark text-white p-4 mt-5">
		<div class="py-3 px-5 text-right">
			<div class="mb-2">VALOR TOTAL</div>
			<div class="h2 font-weight-light">
				<fmt:formatNumber value="${total}" type="currency"
					maxFractionDigits="0" currencySymbol="$" />
			</div>
		</div>

		<div class="py-3 px-5 text-right">
			<div class="mb-2">Descuento</div>
			<div class="h2 font-weight-light">10%</div>
		</div>

		<div class="py-3 px-5 text-right">
			<div class="mb-2">VALOR TOTAL NETO</div>
			<div class="h2 font-weight-light">
				<fmt:formatNumber value="${total * 0.90}" type="currency"
					maxFractionDigits="0" currencySymbol="$" />
			</div>
		</div>
	</section>
</body>
</html>