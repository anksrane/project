<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ page import="bean.User" %>
<%@ page errorPage="Error.jsp" %>
<%
User loggedUser=(User)session.getAttribute("currentUser");
if(loggedUser==null){
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<style>
		body {
			margin: 0;
			padding: 0;
			background-color: #17a2b8;
			height: 100vh;
			overflow:hidden;
		}
		.action,.action:hover{
			padding:0px 5px;
			text-decoration:none;
			color:#17a2b8;
			font-weight:bold;
		}
		.navbar-brand{
			color:white;
		}
		.navbar-brand:hover{
			color:white;
			font-weight:bold;
		}
		.nav-link{
			color:#d0ecf0;
		}
		.nav-link:hover{
			color:#d0ecf0;
			font-weight:bold;
		}
		.btn-success {
		    color: #fff;
		    background-color: #b817a2;
		    border-color: #b817a2;
		    font-weight:bold;
		}
		.btn-success:hover {
		    color: #fff;
		    background-color: #6e0d61;
		    border-color: #6e0d61;
		}
		#login .container #login-row #login-column #login-box {
		  margin-top: 120px;
		  max-width: 600px;
		  height: 320px;
		  border: 1px solid #9C9C9C;
		  background-color: #EAEAEA;
	      border-radius: 10px;
		}
		#login .container #login-row #login-column #login-box #login-form {
		  padding: 20px;
		}
		#register-link {
		 	width:100%;
		}
		.navbar-brand{
			color:white;
		}
		h2{
			text-align:center;
		}
	</style>	
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md bg-dark">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">User Management</a>
			</div>

			<ul class="navbar-nav d-flex justify-content-end" style="width:100%">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            				Edit User
            			</c:if>
						<c:if test="${user == null}">
            				Add New User
            			</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text" id="name"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required pattern="[A-Za-z\s]+" title="Only alphabets allowed">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="email" id="email"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
				</fieldset>

				<fieldset class="form-group">
					<label>User Password</label> <input type="password" id="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password" required pattern=".{8,}" title="Eight or more characters">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Role</label>
						<SELECT class="form-control"
						name="role" required>
							<option disabled selected> -- select an option -- </option>
							<OPTION Value="Admin" <c:if test="${user.role=='Admin'}">selected</c:if>>Admin</OPTION>
							<OPTION Value="Manager"<c:if test="${user.role=='Manager'}">selected</c:if>>Manager</OPTION>
							<OPTION Value="Employee"<c:if test="${user.role=='Employee'}">selected</c:if>>Employee</OPTION>
						</SELECT>
				</fieldset>
				<c:if test="${user != null}">
				<button type="submit" class="btn btn-success" >Update</button>
				</c:if>
				<c:if test="${user == null}">
				<button type="submit" class="btn btn-success" >Save</button>
				</c:if>

				</form>
			</div>
		</div>
	</div>
</body>
</html>