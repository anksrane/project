<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="bean.Visitor"%>
<%@page import="bean.Message"%>
<%@page import="bean.Links"%>
<jsp:useBean id="dateValue" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitors</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body class="visiter-page">
<h3 class="text-center">List of URL Visitors</h3>
			<hr>
		<div class="container">
			<div class="row">
			<br>
			<div class="col-12">				
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>Long URL</th>
						<th>Short URL</th>
						<th>IP Address</th>
						<th>Date</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td><c:out value="${user.longUrlVisitor}" /></td>
						<td><c:out value="${user.shortUrlVisitor}" /></td>
						<td><c:out value="${user.ipAddress}" /></td>
						<td><c:out value="${user.visitedDate}" /></td>
						<td><c:out value="${user.visitedTime}" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
				
			</div>
			

			</div>
		</div>

</body>
</html>