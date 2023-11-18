<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<title>Aplicacion Gestión Usuarios</title>
	</head>
	<body>
	<header>
		<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Gestión de Usuarios</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarText">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" href="<%=request.getContextPath()%>/list">Usuarios</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="<%=request.getContextPath()%>/new">Agregar Usuario</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	</header>
		<br>
		<div class="row">
        	<div class="container">
	            <h3 class="text-center">Lista de Usuarios</h3>
	            <hr>
	            <br>
	            <table class="table table-bordered">
	                <thead>
	                    <tr>
	                        <th>ID</th>
	                        <th>Nombre</th>
	                        <th>Correo</th>
	                        <th>Pais</th>
	                        <th>Acción</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach var="usuario" items="${listUsuarios}">
	                        <tr>
	                            <td>
	                                <c:out value="${usuario.id}" />
	                            </td>
	                            <td>
	                                <c:out value="${usuario.nombre}" />
	                            </td>
	                            <td>
	                                <c:out value="${usuario.email}" />
	                            </td>
	                            <td>
	                                <c:out value="${usuario.pais}" />
	                            </td>
	                            <td><a href="edit?id=<c:out value='${usuario.id}' />" class="btn btn-outline-dark">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${usuario.id}' />" class="btn btn-outline-dark">Eliminar</a></td>
	                        </tr>
                    	</c:forEach>
	                </tbody>
	            </table>
	        </div>
     	</div>
	</body>
</html>