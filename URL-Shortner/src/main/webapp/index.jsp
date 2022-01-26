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
<title>URL Shortener</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript">
<!-- //
	function ClearForm() {
		document.longUrlForm.reset();
		document.shortUrlForm.reset();
	}
// -->
</script>
</head>
<body onload="ClearForm()" class="index-body">
<div class="container main-center">
        <h1 class="logo">URL Shortener</h1>
        <div class="container">
            <form action="addUrl" method="post" name="longUrlForm">
                <div class="form-group">
                    <label for="LongURL">Enter Long URL</label>
                    <textarea id="LongURL" class="form-control" name="longUrl" rows="4" required></textarea>
                </div>
                    <button class="btn btn-success" type="submit">Shorten URL</button>
            </form>
        </div>
		
		<div class="container">
			<%
			Message m = (Message) session.getAttribute("msg");
			if (m != null && m.getType() == "error") {
			%>
				<h2 class="text-danger">
					<%=m.getContent()%>
				</h2>
			<%
			session.removeAttribute("msg");
			} else if (m != null && m.getType() == "success") {
			%>
				<h2 class="text-success">
					<%=m.getContent()%>
				</h2>
			<%
			session.removeAttribute("msg");
			}
			%>
		</div>

		<div class="container">
        <form action="visitLink" method="post" name="shortUrlForm">
            <div class="form-group">
                <label for="ShortURL">Short URL</label>
                <input id="ShortURL" type="text" name="shortUrl" class="form-control"
			value="<% String shortenURL=(String)request.getAttribute("shortUrlInput");
			if (shortenURL == null || shortenURL.length() == 0) {
			out.print("");
		    } else {
			    out.print(shortenURL);
		    }%>" required>
            </div>
                <button class="btn btn-success" type="submit" value="Shorten URL" id="visitShortURL">Open Long URL</button>
        </form>
	</div>
    
	<div class="container visiter-link">
    <form action="viewList" method="post">
		<button class="btn btn-success link" type="submit">Open Visitors List</button>
	</form>
	</div>
	
</div>
</body>
</html>