<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List</title>
</head>
<body>
	<h1 style="text-align: center">IMDb</h1>

	<br>
	<div style="text-align: center">
		<a href="artists">Search Artists</a> &nbsp;&nbsp; <a href="directors">Search
			Directors</a> &nbsp;&nbsp; <a href="movies/add"> Add Movie</a>
	</div>
	<br>
	<br>
	<br>
	<h2 style="text-align: center">Search Movies</h2>
	<div style="text-align: center">
		<form:form action="${pageContext.request.contextPath}/movies/search"
			modelAttribute="filter" method="post">


			<div style="display: block; margin-left: 20px;">
				<form:radiobuttons path="id" items="${filterList }"
					itemLabel="filter" itemValue="id" />
				&nbsp;
				<form:errors path="id" cssStyle="color:red" />
			</div>
			<br>

			<div style="display: inline; margin-left: 20px;">

				<form:input path="text" size="99"
					placeholder="Pleass input key word" />
				&nbsp;
				<form:errors path="text" cssStyle="color:red" />
				<button type="submit">Search</button>
			</div>


		</form:form>


	</div>
	<br>
	<c:if test="${not empty movieList}">
		<table style="cellpadding: 10px;">

			<thead>
				<tr>
					<th>Name</th>
					<th>Year</th>
					<th>Rating</th>

				</tr>
			</thead>

			<c:forEach var="movie" items="${movieList}">
				<tr>
					<td>${movie.name}</td>
					<td>${movie.year}</td>
					<td>${movie.rating }</td>
					<td><form action="movies/update/${movie.id}" method="get">
							<button>Update</button>
						</form></td>
					<td><form action="movies/delete/${movie.id}" method="post">
							<button type="submit">Delete</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>

</body>
</html>