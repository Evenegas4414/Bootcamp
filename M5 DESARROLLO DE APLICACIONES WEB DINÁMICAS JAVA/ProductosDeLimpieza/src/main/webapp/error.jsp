<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-light">

	<section class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4">
						<h1 class="text-center mb-4 text-danger">¡Error!</h1>
						<h5 class="text-center">Texto descripcion</h5>
						<div class="collapse p-3" id="collapseExample">
							<div class="card card-body">Some placeholder content for
								the collapse component. This panel is hidden by default but
								revealed when the user activates the relevant trigger.
							</div>
						</div>
					</div>
					<div class="col-6 mx-auto my-3">
						<button class="btn btn-outline-secondary text-uppercase form-control"
							type="button" data-bs-toggle="collapse"
							data-bs-target="#collapseExample" aria-expanded="false"
							aria-controls="collapseExample">Detalles</button>
					</div>
					<div class="col-6 mx-auto my-3">
						<a class="btn btn-primary text-uppercase form-control" href="listar" role="button">Volver a Inicio</a>
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