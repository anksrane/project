<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ page import="bean.User" %>
<%@ page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
	
	.table-bordered{
		text-align:center;
    	border:1px solid white;
	}
	.table-bordered th{
		background-color:#8bd0db;
	}
	.table-bordered tr td{
		background-color:#e7f5f7;	
	}
	hr{
		background-color:white;
	}
	</style>
</head>
<body>
<%
String admin="Admin";
String manager="Manager";
String employee="Employee";

User loggedUser=(User)session.getAttribute("currentUser");
if(loggedUser==null){
	response.sendRedirect("login.jsp");
}
%>
	<header>
		<nav class="navbar navbar-expand-md bg-dark">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">User Management</a>
			</div>

			<ul class="navbar-nav d-flex justify-content-end" style="width:100%">
				<li class="nav-item">
				<a href="<%=request.getContextPath()%>/logout" class="nav-link"><span class="fa fa-user">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>

			<div class="row">
			<%
			if(loggedUser.getrole().equals(admin)){
			%>
			<div class="col-6 text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
			</div>
			<%} %>

			<div class="col-6 text-right">
			    <form class="form-inline my-2 my-lg-0" style="display: block">
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
			      <a href="<%=request.getContextPath()%>/list" class="btn btn-success">Search</a>
			    </form>
			</div>
				


			<br>
			<br>
			<div class="col-12">
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Role</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td><a class="action" href="edit?id=<c:out value='${user.id}' />">Edit</a>
								<a class="action" href="view?id=<c:out value='${user.id}' />">View</a>
								<a class="action" href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
			
			</div>
			

			</div>
		</div>
	</div>
</body>
</html>