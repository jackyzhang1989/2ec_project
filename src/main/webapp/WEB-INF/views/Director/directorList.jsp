<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Director List</title>
</head>
<body>
	<h1 style="text-align: center">IMDb</h1>
	<div style="text-align: center">
		<a href="directors/add"> Add Director</a> &nbsp;&nbsp; <a
			href="/SpringImdb"> Home</a>
	</div>
	<br>
	<br>
	<h2 style="text-align: center">Movie Directors</h2>


	<div style="margin-left: 600px;">
		<c:if test="${not empty directorList}">
			<table  border="1">

				<thead>
					<tr>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>

				<c:forEach var="director" items="${directorList}">
					<tr>
						<td>${director.firstName}&nbsp;${director.lastName}</td>
						<td>
							<form action="directors/update/${director.id}" method="get">
								<button>Update</button>
							</form>
						</td>
						<td><form action="directors/delete/${director.id}"
								method="post">
								<button type="submit">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>