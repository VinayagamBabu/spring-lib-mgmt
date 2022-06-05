<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Book</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3> Save Book</h3>
		<form action="/save" method="post">
			<input type="hidden" name="id" value=${book.id}>
			<div class="form-inline">
			<input type="text"  name="name" value="${book.name}" placeholder="Book Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="category" value="${book.category}" placeholder="Book Category" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="Author" value="${book.author}" placeholder="Author" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>
		
		<a href="/LibraryApp/books/list">Back to Book List</a>
	
	</div>
</body>
</html>