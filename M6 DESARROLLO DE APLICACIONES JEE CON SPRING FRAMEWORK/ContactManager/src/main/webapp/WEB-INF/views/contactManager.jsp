<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html> 
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ContactManager</title>
<script type="text/javascript">
	var idSeleccionado = 0;
	function submitFormAction(action, method) {
		document.getElementById("formAcciones").action = action;
		document.getElementById("formAcciones").method = method;
		document.getElementById("formAcciones").submit();
	}
	function setIdSeleccionado(id) {
		idSeleccionado = id;
	}
	function borrarFila() {
		window.location.href = "/contactManager/deleteContact/?id=" + idSeleccionado;
	}
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="container">

	<form:form id="formAcciones" modelAttribute="contacto"
		action="/addContact">
		<div>
			<fieldset>
				<legend class="text-center my-4">Contact Manager</legend>
				<table class="table table-hover table-bordered">
					<tr>
						<td>Nombre</td>
						<td><input class="form-control" type="text" id="nombre" name="nombre" /></td>
						<td>Apellido Paterno</td>
						<td><input class="form-control" type="text" id="apellidoPaterno"
							name="apellidoPaterno" /></td>
						<td>Apellido Materno</td>
						<td><input class="form-control" type="text" id="apellidoMaterno"
							name="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td>Direccion</td>
						<td colspan="3"><input class="form-control" type="text" id="direccion" name="direccion" /></td>
						<td>Telefono</td>
						<td><input class="form-control" type="text" id="telefono" name="telefono" /></td>
					</tr>
					<tr>
						<td colspan="4">

							<button type="button" value="Agregar" class="btn btn-success"
								onclick="submitFormAction('/contactManager/addContact', 'post')">Agregar</button>
							<button type="button" value="Eliminar" class="btn btn-danger"
								onclick="borrarFila()">Borrar</button> <!--  
						<input type="button" value="Buscar" /> 
						<input type="button" value="Agregar" onclick="submitFormAction('/contactManager/addContact', 'post')" />
						<input  /></td>
						-->
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>

	<br>
	<br>
	<br>

	<div>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th></th>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Direccion</th>
					<th>Telefono</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaContactos}" var="c">
					<tr>
						<td><input type="radio" name="optSelectRow"
							onclick="setIdSeleccionado(${c.idContacto})" /></td>
						<td>${c.idContacto}</td>
						<td>${c.nombre}</td>
						<td>${c.apellidoPaterno}</td>
						<td>${c.apellidoMaterno}</td>
						<td>${c.direccion}</td>
						<td>${c.telefono}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>




		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
			crossorigin="anonymous"></script>
</body>
</html>