<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Users"%>
<%@page import="bean.Message"%>
<%@page import="bean.Links"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #f8d7da;
	text-align: center;
}

.alert {
	margin: 10%;
	border-style: none;
}

h2 {
	font-weight: bold;
	font-size: 48px;
}
</style>
</head>
<body>
<div class="alert alert-danger" role="alert">
  <h1>	<%Message m =(Message)session.getAttribute("msg");
	if(m != null){%>
	<div class="alert alert-danger container" role="alert">
        <h2>
            <%=m.getContent()%>
        </h2>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%></h1>
</div>
</body>
</html>