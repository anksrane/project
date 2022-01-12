<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ page import="bean.User" %>
<%@ page errorPage="Error.jsp" %>
<%
String admin="Admin";
String manager="Manager";
String employee="Employee";

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
		.form-control:disabled{
	    	border: none;
    		border-bottom: 1px solid #ced4da;
    		background-color: #fff;
    		border-radius:0px;
		}
		label{
			font-weight:bold;
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
		<nav class="navbar navbar-expand-md bg-dark d-flex justify-content-between">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">User Management</a>
			</div>
			<div>
			<%
			if(loggedUser.getrole().equals(admin)){
			%>
				<h5 class="text-white">Admin Panel</h5>
			<%} else if(loggedUser.getrole().equals(manager)){
			%>
				<h5 class="text-white">Manager Panel</h5>
			<%}else{
			%>
				<h5 class="text-white">Employee Panel</h5>
			<%} %>
			</div>
			<div>
				<a href="<%=request.getContextPath()%>/logout" class="nav-link"><span class="fa fa-user">Logout</a></li>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
					<h2>
            			View User
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text" disabled
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="email" disabled
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Password</label> <input type="password" disabled
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>
				<fieldset class="form-group">
					<label>User Password</label> <input type="text" disabled
						value="<c:out value='${user.role}' />" class="form-control"
						name="password">
				</fieldset>
				
				<c:if test="${user != null}">
				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">Back to Users</a>
				</c:if>

				</form>
			</div>
		</div>
	</div>
</body>
</html>