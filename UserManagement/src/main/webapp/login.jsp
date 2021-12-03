<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@page import="bean.Message" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	 <link rel="stylesheet" href="style.css">
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
	</style>
</head>
<body>
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="login" method="post">
                            <h3 class="text-center text-info">Login</h3>
  			         		
  			         		<%
  			         			Message m=(Message)session.getAttribute("msg");
  			         		if(m!=null){
  			         		%>
		         			<div class="alert alert-danger" role="alert">
							  	<%=m.getContent() %>
							</div>
  			         		<%
  			     				session.removeAttribute("msg");    		
  			         		} 
  			           		%>
  			         
  			         
                            <div class="form-group">
                                <label for="email" class="text-info">Email:</label><br>
                                <input type="email" name="email" id="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control" required>
                            </div>
                            <hr>
                            <div id="register-link">
                                <button type="submit" value="login" class="btn btn-success">Login</button>
                            </div>
                        </form>
                                               
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>