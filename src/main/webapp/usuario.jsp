<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Aplicación Gestión de Usuarios</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${usuario != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${usuario == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${usuario != null}">
                                    Editar Usuario
                                </c:if>
                                <c:if test="${usuario == null}">
                                    Agregar Nuevo Usuario
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${usuario != null}">
                            <input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Nombre de Usuario</label> <input type="text" value="<c:out value='${usuario.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email del Usuario</label> <input type="text" value="<c:out value='${usuario.email}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Pais del Usuario</label> <input type="text" value="<c:out value='${usuario.pais}' />" class="form-control" name="pais">
                        </fieldset>

                        <button type="submit" class="btn btn-dark">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>